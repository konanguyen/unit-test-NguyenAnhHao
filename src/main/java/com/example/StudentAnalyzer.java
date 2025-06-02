package com.example;

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
     * Yêu cầu:
     * - Chỉ tính các điểm hợp lệ từ 0 đến 10.
     * - Bỏ qua điểm âm, >10, hoặc null.
     * - Nếu danh sách rỗng hoặc null, trả về 0.
     *
     * @param scores Danh sách điểm số
     * @return Số lượng học sinh giỏi
     */
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) return 0;

        int count = 0;
        for (Double score : scores) {
            if (isValidScore(score) && score >= 8.0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Tính điểm trung bình các giá trị hợp lệ trong danh sách điểm.
     *
     * Yêu cầu:
     * - Chỉ tính điểm từ 0 đến 10.
     * - Bỏ qua điểm null, âm hoặc lớn hơn 10.
     * - Nếu danh sách rỗng hoặc không có điểm hợp lệ, trả về 0.0.
     *
     * @param scores Danh sách điểm số
     * @return Trung bình điểm hợp lệ
     */
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;

        double sum = 0.0;
        int count = 0;

        for (Double score : scores) {
            if (isValidScore(score)) {
                sum += score;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
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
