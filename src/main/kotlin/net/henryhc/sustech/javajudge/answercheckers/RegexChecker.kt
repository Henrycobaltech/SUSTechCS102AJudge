package net.henryhc.sustech.javajudge.answercheckers

import net.henryhc.sustech.javajudge.sakai.TestCaseJudgeResult

class RegexChecker(
        private val regex: Regex,
        override var caseName: String = "") : AnswerChecker {
    override fun check(actual: Any) =
            if (regex.matches(actual.toString())) TestCaseJudgeResult(1.0, caseName, "Nice Work")
            else TestCaseJudgeResult(0.0, caseName,
                    "Wrong answer\nYour output should match regular expression:\n${regex.pattern}\nActual:\n$actual")
}