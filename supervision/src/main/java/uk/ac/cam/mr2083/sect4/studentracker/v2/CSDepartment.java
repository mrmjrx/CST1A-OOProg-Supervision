package uk.ac.cam.mr2083.sect4.studentracker.v2;

import java.util.List;

public class CSDepartment {
    public List<Student> students;

    public int passingStudentCount() {
        int passesCount = 0;

        for (Student student : this.students) {
            if (!student.pass()) continue;

            passesCount++;
        }

        return passesCount;
    }
}
