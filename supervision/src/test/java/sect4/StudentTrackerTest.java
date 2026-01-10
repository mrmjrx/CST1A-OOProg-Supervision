package sect4;

import org.junit.jupiter.api.Test;
import uk.ac.cam.mr2083.sect4.studentracker.v1.CSDepartment;
import uk.ac.cam.mr2083.sect4.studentracker.v1.Student;
import uk.ac.cam.mr2083.sect4.studentracker.v2.ComputerScienceStudent;
import uk.ac.cam.mr2083.sect4.studentracker.v2.NaturalScienceComputerScientistStudent;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentTrackerTest {
    private final List<Student> v1StudentList = List.of(
            new Student(12),
            new Student(20),
            new Student(-1),
            new Student(0),
            new Student(7),
            new Student(9),
            new Student(10),
            new Student(24),
            new Student(12),
            new Student(20),
            new Student(-1),
            new Student(0),
            new Student(7),
            new Student(9),
            new Student(10),
            new Student(24)
    );

    private final List<uk.ac.cam.mr2083.sect4.studentracker.v2.Student>  v2StudentList = List.of(
            new ComputerScienceStudent(12),
            new ComputerScienceStudent(20),
            new ComputerScienceStudent(-1),
            new ComputerScienceStudent(0),
            new ComputerScienceStudent(7),
            new ComputerScienceStudent(9),
            new ComputerScienceStudent(10),
            new ComputerScienceStudent(24),
            new NaturalScienceComputerScientistStudent(12),
            new NaturalScienceComputerScientistStudent(20),
            new NaturalScienceComputerScientistStudent(-1),
            new NaturalScienceComputerScientistStudent(0),
            new NaturalScienceComputerScientistStudent(7),
            new NaturalScienceComputerScientistStudent(9),
            new NaturalScienceComputerScientistStudent(10),
            new NaturalScienceComputerScientistStudent(24)
    );

    @Test
    public void v1Test() {
        CSDepartment cst = new CSDepartment();

        cst.students = v1StudentList;

        assertEquals(4, cst.passingStudentCount());
    }

    @Test
    public void v2Test() {
        uk.ac.cam.mr2083.sect4.studentracker.v2.CSDepartment cst = new uk.ac.cam.mr2083.sect4.studentracker.v2.CSDepartment();

        cst.students = v2StudentList;

        assertEquals(6, cst.passingStudentCount());
    }
}
