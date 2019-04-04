package net.henryhc.sustech.javajudge.spring19.assignment1

import net.henryhc.sustech.javajudge.Problem
import net.henryhc.sustech.javajudge.testcases.ArgsTestCase
import net.henryhc.sustech.javajudge.testCases
import net.henryhc.sustech.javajudge.worth

val a1q1 = Problem("A1Q1", testCases(
        ArgsTestCase("Case 1", "A1Q1", listOf("3"), "18.84\n28.26") worth 0.2,
        ArgsTestCase("Case 2", "A1Q1", listOf("4.2"), "26.38\n55.39") worth 0.2,
        ArgsTestCase("Case 3", "A1Q1", listOf("5.9"), "37.05\n109.30") worth 0.2,
        ArgsTestCase("Case 4", "A1Q1", listOf("7.2"), "45.22\n162.78") worth 0.2,
        ArgsTestCase("Case 5", "A1Q1", listOf("8.4"), "52.75\n221.56") worth 0.2
))

val a1q2 = Problem("A1Q2", testCases(
        ArgsTestCase("Case 1", "A1Q2", listOf("123.4"), "85.88") worth 0.2,
        ArgsTestCase("Case 2", "A1Q2", listOf("30"), "0.00") worth 0.2,
        ArgsTestCase("Case 3", "A1Q2", listOf("51"), "1.17") worth 0.2,
        ArgsTestCase("Case 4", "A1Q2", listOf("87.2"), "43.52") worth 0.2,
        ArgsTestCase("Case 5", "A1Q2", listOf("3200"), "3685.50") worth 0.2
))

val a1q3 = Problem("A1Q3", testCases(
        ArgsTestCase("Case 1", "A1Q3", listOf("90", "90", "80", "100", "95"), "90.50\nA") worth 0.2,
        ArgsTestCase("Case 2", "A1Q3", listOf("60", "50", "78", "82", "90"), "77.80\nB") worth 0.2,
        ArgsTestCase("Case 3", "A1Q3", listOf("80", "70", "34", "50", "39"), "46.90\nC") worth 0.2,
        ArgsTestCase("Case 4", "A1Q3", listOf("100", "100", "80", "70", "40"), "70.00\nB") worth 0.2,
        ArgsTestCase("Case 5", "A1Q3", listOf("0", "0", "40", "60", "98"), "53.40\nB") worth 0.2
))

val a1q4 = Problem("A1Q4", testCases(
        ArgsTestCase("Case 1", "A1Q4", listOf("10"), "55") worth 0.2,
        ArgsTestCase("Case 2", "A1Q4", listOf("30"), "465") worth 0.2,
        ArgsTestCase("Case 3", "A1Q4", listOf("45"), "1035") worth 0.2,
        ArgsTestCase("Case 4", "A1Q4", listOf("67"), "2278") worth 0.2,
        ArgsTestCase("Case 5", "A1Q4", listOf("205"), "21115") worth 0.2
))

