package net.henryhc.sustech.javajudge.sakai

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import net.henryhc.sustech.javajudge.Problem
import net.henryhc.sustech.javajudge.concurrentJudgingCount
import net.henryhc.sustech.javajudge.sakaiI18n
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.csv.QuoteMode
import java.io.File
import java.io.StringWriter
import java.util.concurrent.Semaphore

class Assignment(
        val path: String,
        val problemsWithScore: Map<Problem, Double> = emptyMap()
) {
    private val i18n = sakaiI18n
    private val submissions: List<Submission>
    private val csvFirstTwoLines: String
    private val csvFormat = CSVFormat.DEFAULT.withSkipHeaderRecord().withQuoteMode(QuoteMode.ALL)
            .withHeader(*i18n.csvHeader)

    private val channel: Channel<Int> = Channel(concurrentJudgingCount)

    init {
        val csvFileLines = File(path, GradeFileName).readLines()
        this.csvFirstTwoLines = csvFileLines.take(2).joinToString("\n")
        this.submissions = csvFileLines.drop(2).joinToString("\n")
                .let { CSVParser.parse(it, csvFormat) }.map {
                    val studentInfo = StudentInfo(
                            it.get(i18n.studentIdKey),
                            "${it.get(i18n.lastNameKey)}, ${it.get(i18n.firstNameKey)}"
                    )
                    val submissionPath = File(
                            path,
                            "${it.get(i18n.lastNameKey)}, ${it.get(i18n.firstNameKey)}(${it.get(i18n.studentIdKey)})"
                    ).absolutePath
                    Submission(
                            submissionPath,
                            studentInfo,
                            it.get(i18n.isLateSubmissionKey) == i18n.lateSubmissionText,
                            it.get(i18n.submissionTimeKey)
                    )
                }
        repeat(concurrentJudgingCount) { runBlocking { channel.send(1) } }
    }

    fun judge(beforeEachJudge: (Submission) -> Unit = {}): Map<Submission, SubmissionJudgeResult> = this.submissions.map {
        GlobalScope.async {
            channel.receive()
            val result = it to it.judge(problemsWithScore, beforeEachJudge)
            channel.send(1)
            result
        }
    }.map { runBlocking { it.await() } }.toMap()

    fun writeGradeCsv(results: List<SubmissionJudgeResult>) {
        val writer = StringWriter()
        val csvWriter = CSVPrinter(writer, csvFormat)
        csvWriter.printRecord(*i18n.csvHeader)
        results.forEach {
            csvWriter.printRecord(
                    it.submission.student.id,
                    it.submission.student.id,
                    it.submission.student.name.split(", ")[0],
                    it.submission.student.name.split(", ")[1],
                    String.format("%.1f", it.score),
                    it.submission.timeStampStr,
                    if (it.submission.isLateSubmission) i18n.lateSubmissionText else i18n.onTimeSubmissionText
            )
        }
        csvWriter.flush()
        File(path, GradeFileName).writeText("${this.csvFirstTwoLines}\n$writer")
    }

    companion object {
        private const val GradeFileName = "grades.csv"
    }
}
