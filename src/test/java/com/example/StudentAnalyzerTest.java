package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    // === countExcellentStudents() tests ===

    @Test
    public void testExcellentStudentExactly8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test
    public void testExcellentStudentAbove8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(9.5)));
    }

    @Test
    public void testNotExcellentStudentJustBelow8() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.9)));
    }

    @Test
    public void testScoreZero() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
    }

    @Test
    public void testScoreTen() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
    }

    @Test
    public void testNegativeScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-2.0)));
    }

    @Test
    public void testScoreAboveTen() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(11.0)));
    }

    @Test
    public void testNullScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList((Double) null)));
    }

    @Test
    public void testEmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testNullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    // === calculateValidAverage() tests ===

    @Test
    public void testValidAverageSingleScore() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(7.5)), 0.01);
    }

    @Test
    public void testValidAverageMultipleScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(8.5, analyzer.calculateValidAverage(Arrays.asList(8.0, 9.0)), 0.01);
    }

    @Test
    public void testAverageWithInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(8.0, analyzer.calculateValidAverage(Arrays.asList(8.0, -1.0, 12.0, null)), 0.01);
    }

    @Test
    public void testAverageAllInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-5.0, 15.0, null)), 0.01);
    }

    @Test
    public void testAverageEmptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testAverageNullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }

    @Test
    public void testAverageEdgeValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.01);
    }
}
