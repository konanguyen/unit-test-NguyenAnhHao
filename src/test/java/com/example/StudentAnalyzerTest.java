package com.example;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // === Tests for countExcellentStudents() ===

    @Test
    public void testExactly8Point() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
    }

    @Test
    public void testAbove8Point() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(9.5)));
    }

    @Test
    public void testJustBelow8() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.9)));
    }

    @Test
    public void testScoreIsZero() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
    }

    @Test
    public void testScoreIsTen() {
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
    }

    @Test
    public void testNegativeScore() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-2.0)));
    }

    @Test
    public void testScoreGreaterThanTen() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(11.0)));
    }

    @Test
    public void testNullScore() {
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList((Double) null)));
    }

    @Test
    public void testEmptyListOfScores() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testNullListOfScores() {
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    // === Tests for calculateValidAverage() ===

    @Test
    public void testSingleScoreAverage() {
        assertEquals(7.5, analyzer.calculateValidAverage(Arrays.asList(7.5)), 0.01);
    }

    @Test
    public void testMultipleValidScoresAverage() {
        assertEquals(8.5, analyzer.calculateValidAverage(Arrays.asList(8.0, 9.0)), 0.01);
    }

    @Test
    public void testAverageWithInvalidIncluded() {
        assertEquals(8.0, analyzer.calculateValidAverage(Arrays.asList(8.0, -1.0, 12.0, null)), 0.01);
    }

    @Test
    public void testAverageOnlyInvalid() {
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-5.0, 15.0, null)), 0.01);
    }

    @Test
    public void testAverageEmptyScoreList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testAverageNullScoreList() {
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }

    @Test
    public void testAverageWithEdgeValues() {
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)), 0.01);
    }
}
