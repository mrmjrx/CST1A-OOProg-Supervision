package sect7;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect7.StudentGradeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

public class StudentGradeMapTest {
    @Test
    public void studentGradeMapTest() {
        HashMap<String, Integer> studentGradeHashMap = new HashMap<>();
        studentGradeHashMap.put("A", 12);
        studentGradeHashMap.put("B", 27);
        studentGradeHashMap.put("C", 32);

        StudentGradeMap studentGradeMap = new StudentGradeMap(studentGradeHashMap);
        studentGradeMap.insertGrade("D", 72);
        studentGradeMap.insertGrade("E", 31);

        assertTrue(studentGradeMap.allStudents().containsAll(List.of("A", "B", "C", "D", "E")));

        List<String> topStudents = studentGradeMap.topStudents(33);
        assertEquals(2, topStudents.size());
        assertTrue(topStudents.containsAll(List.of("D", "C")));

        assertEquals(31, studentGradeMap.median());

        Object x = new Object();
    }
}
