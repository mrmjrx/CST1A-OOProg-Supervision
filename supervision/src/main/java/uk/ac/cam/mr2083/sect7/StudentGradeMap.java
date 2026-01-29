package uk.ac.cam.mr2083.sect7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class StudentGradeMap {
    private HashMap<String, Integer> gradeMap;

    public StudentGradeMap() {
        gradeMap = new HashMap<>();
    }

    public StudentGradeMap(HashMap<String, Integer> gradeMap) {
        if (gradeMap.values().stream().anyMatch(grade -> grade < 0)) {
            throw new RuntimeException("Grades must be greater than 0");
        }

        this.gradeMap = gradeMap;
    }

    public void insertGrade(String studentName, int grade) {
        if (grade < 0) {
            throw new RuntimeException("Grades must be greater than 0");
        }
        this.gradeMap.put(studentName, grade);
    }

    public Integer getGrade(String studentName) { // Integer as can be null
        return this.gradeMap.get(studentName);
    }

    public List<String> allStudents() {
        return new ArrayList<>(this.gradeMap.keySet());
    }

    public int studentCount() {
        return this.gradeMap.size();
    }

    public List<String> topStudents(double percent) {
        int studentsInPercent = Math.max((int) Math.round(percent * this.studentCount() / 100.0), 1);

        return this.gradeMap.keySet().stream()
                .sorted(
                        Comparator
                                .comparingInt(studentName -> this.gradeMap.get(studentName))
                                .reversed()
                )
                .limit(studentsInPercent)
                .toList();
    }

    public double median() {
        List<Integer> allGrades = this.allStudents().stream().map(this::getGrade).sorted().toList();

        if (allGrades.size() % 2 != 0) {
            return allGrades.get(allGrades.size() / 2);
        }

        double grade1 = (double) allGrades.get((allGrades.size() - 1) / 2);
        double grade2 = (double) allGrades.get(allGrades.size() / 2);

        return (grade1 + grade2) / 2.0;
    }
}
