package com.example;

import java.util.List;

/**
 * Lớp StudentAnalyzer chứa hàm đếm số học sinh giỏi.
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
            if (score != null && score >= 0 && score <= 10 && score >= 8.0) {
                count++;
            }
        }
        return count;
    }
}
