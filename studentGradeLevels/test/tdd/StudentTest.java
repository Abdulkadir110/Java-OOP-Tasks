import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    Student student1;
    @BeforeEach
    void startWith(){
        student1 = new Student("Abdulkadir");
    }
    @Test
    void testToDisplayStudentName_And_GradeLevel(){
        assertEquals("Abdulkadir, your grade level is 1",student1.display());
    }
    @Test
    void testThatStudentWasPromoted(){
        assertEquals("Abdulkadir, your grade level is 1", student1.display());
        student1.promote();
        assertEquals("Abdulkadir, your grade level is 2", student1.display());
    }
    @Test
    void testThatStudentWasPromotedTwice(){
        assertEquals("Abdulkadir, your grade level is 1", student1.display());
        student1.promote();
        student1.promote();
        assertEquals("Abdulkadir, your grade level is 3", student1.display());
    }
    @Test
    void testThatStudentGotAScore_AndPassed(){
        assertTrue(student1.hasPassed(70));
    }
    @Test
    void testThatStudentGotAScore_AndPassed_GetPromotion(){
        assertTrue(student1.hasPassed(70));
        student1.promote();
        assertEquals("Abdulkadir, your grade level is 2", student1.display());
    }
    @Test
    void testThatStudentGotAScore_AndFailed(){
        assertFalse(student1.hasPassed(40));
    }
    @Test
    void testThatStudentScoreIsNegative_And_above_100(){
        assertThrows(IllegalArgumentException.class, () -> student1.hasPassed(-6));
        assertThrows(IllegalArgumentException.class, () -> student1.hasPassed(105));
    }
    @Test
    void testThatIUpdateName(){
        student1.updateName("Opeyemi");
        assertEquals("Opeyemi, your grade level is 1", student1.display());
    }
    @Test
    void testThatIUpdateName_And_GradeLevel(){
        student1.updateName("Opeyemi");
        assertEquals("Opeyemi, your grade level is 1", student1.display());
        student1.promote();
        student1.promote();
        student1.promote();
        assertEquals("Opeyemi, your grade level is 4", student1.display());
    }
    @Test
    void testThatStudentIsGraduating(){
        assertFalse(student1.isGraduating());
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        assertEquals("Abdulkadir, your grade level is 12", student1.display());
        assertTrue(student1.isGraduating());
    }
    @Test
    void testThatStudentCannotBePromotedMore12(){
        assertFalse(student1.isGraduating());
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        student1.promote();
        assertEquals("Abdulkadir, your grade level is 12", student1.display());
    }
    @Test
    void testThatStudentIsNotGraduating(){
        assertFalse(student1.isGraduating());
        student1.promote();
        student1.promote();
        assertFalse(student1.isGraduating());
    }
}
