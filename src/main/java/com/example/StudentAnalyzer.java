package com.example;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Lớp StudentAnalyzer chứa các hàm xử lý điểm số học sinh:
 * - Đếm số học sinh giỏi
 * - Tính trung bình điểm hợp lệ
 */
public class StudentAnalyzer {

    /**
     * Đếm số học sinh đạt loại Giỏi (điểm từ 8.0 trở lên).
     *
     * @param scores Danh sách điểm số
     * @return Số lượng học sinh giỏi
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null) return 0;

        return (int) scores.stream()
                .filter(this::isValidScore)
                .filter(score -> score >= 8.0)
                .count();
    }

    /**
     * Tính điểm trung bình các giá trị hợp lệ trong danh sách điểm.
     *
     * @param scores Danh sách điểm số
     * @return Trung bình điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null) return 0.0;

        DoubleSummaryStatistics stats = scores.stream()
                .filter(this::isValidScore)
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        return stats.getCount() > 0 ? stats.getAverage() : 0.0;
    }

    /**
     * Kiểm tra một điểm số có hợp lệ hay không (từ 0 đến 10, không null).
     *
     * @param score Điểm số cần kiểm tra
     * @return true nếu hợp lệ, false nếu không
     */
    private boolean isValidScore(Double score) {
        return score != null && score >= 0 && score <= 10;
    }
}
