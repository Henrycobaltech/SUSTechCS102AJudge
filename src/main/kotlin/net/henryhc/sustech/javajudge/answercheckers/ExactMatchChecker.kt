package net.henryhc.sustech.javajudge.answercheckers

import net.henryhc.sustech.javajudge.sakai.TestCaseJudgeResult

class ExactMatchChecker(
        private val expected: String,
        override var caseName: String = ""
) : AnswerChecker {
    override fun check(actual: String) =
            if (actual == expected) TestCaseJudgeResult(1.0, caseName, "Nice Work")
            else TestCaseJudgeResult(0.0, caseName, "Wrong answer\nExpected:\n$expected\nActual:\n$actual")
}