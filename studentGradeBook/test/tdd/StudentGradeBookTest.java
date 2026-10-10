import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.StudentGradeBook;

import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeBookTest {
    private StudentGradeBook gradeBook;

    @BeforeEach
    public void startWiths(){
        gradeBook = new StudentGradeBook();
    }
    public void newGradeBookShouldBeEmpty() {
        assertTrue(gradeBook.isEmpty());
    }
    @Test
    public void testThatNumberOfStudentsWasCollected() {
        gradeBook.setNumberOfStudents(5);
    }
    @Test
    public void testThatNumberOfSubjectsWasCollected() {
        gradeBook.setNumberOfSubjects(3);
    }
    @Test
    public void testThatMinusOne_NumberOfSubjectsWasRejected() {
        assertThrows(IllegalArgumentException.class,() -> gradeBook.setNumberOfSubjects(-1));
    }
    @Test
    public void testGradeBookWasCreated() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();
        int[][] actual = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        assertArrayEquals(gradeBook.getGradeBook(), actual);
    }
    @Test
    public void addScoreInGradeBookTest() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 95);
    }
    @Test
    public void addScoreInGradeBookTest2() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(3, 5, 10);
    }
    @Test
    public void addScoreInGradeBookTest_NotEmpty() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(3, 5, 10);
        assertFalse(gradeBook.isEmpty());
    }
    @Test
    public void addInvalidScoreInGradeBookTest() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();

        assertThrows(IllegalArgumentException.class,() -> gradeBook.putScoreIn(1, 1, 105));
    }
    @Test
    public void IAddSetInvalidSubjectNumberAndStudentNumberInGradeBookTest() {
        gradeBook.setNumberOfStudents(5);
        gradeBook.setNumberOfSubjects(3);
        gradeBook.setGradeBook();

        assertThrows(IllegalArgumentException.class,() -> gradeBook.putScoreIn(0, 6, 65));
    }
    @Test
    public void afterAddingScores_GetTotalForEachStudent(){
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[][] actualGradeBook = {{30,50},{30,40}};
        assertArrayEquals(gradeBook.getGradeBook(), actualGradeBook);

        int[] actualTotal = {60, 90};
        assertArrayEquals(gradeBook.totalScoreForEachStudent(), actualTotal);

    }
    @Test
    public void afterAddingScores_GetTotalForEachStudent_Average(){
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[][] actualGradeBook = {{30,50},{30,40}};
        assertArrayEquals(gradeBook.getGradeBook(), actualGradeBook);

        int[] actualTotal = {60, 90};
        assertArrayEquals(gradeBook.totalScoreForEachStudent(), actualTotal);

        double[] actualAverage = {30, 45};
        assertArrayEquals(gradeBook.averageScoreForEachStudent(), actualAverage);

    }
    @Test
    public void afterAddingScores_GetTotalForEachStudent_Average_Position(){
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[][] actualGradeBook = {{30,50},{30,40}};
        assertArrayEquals(gradeBook.getGradeBook(), actualGradeBook);

        int[] actualTotal = {60, 90};
        assertArrayEquals(gradeBook.totalScoreForEachStudent(), actualTotal);

        double[] actualAverage = {30, 45};
        assertArrayEquals(gradeBook.averageScoreForEachStudent(), actualAverage);

        int[] actualPositions = {2,1};
        assertArrayEquals(gradeBook.getPositionOfStudents(), actualPositions);
    }
    @Test
    public void highestStudentAndScoreForSubject() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);
        int[] result = gradeBook.getHighestStudentAndScoreForSubject(1);
        int[] actual = {2, 50};
        assertArrayEquals(result, actual);
    }
    @Test

    public void highestStudentAndScoreForSubject_invalidSubjectAboveRange_throws() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[] actualPositions = {2,1};
        assertThrows(IllegalArgumentException.class, () -> gradeBook.getHighestStudentAndScoreForSubject(4));
    }
    @Test
    public void LowestStudentAndScoreForSubject() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);
        int[] result = gradeBook.getLowestStudentAndScoreForSubject(2);
        int[] actual = {1, 30};
        assertArrayEquals(result, actual);
    }
    @Test
    public void highestStudentScoreForEachSubject() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[][] highest = gradeBook.getHighestStudentScoreForEachSubject();
        int[][] actualHighest = {{2,50},{2,40}};
        assertArrayEquals(highest,actualHighest);

    }
    @Test
    public void totalScoreForEachSubject() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);
        int[] expectedTotal = gradeBook.totalScoreForEachSubject();
        int[] actualTotal = {80,70};
        assertArrayEquals(expectedTotal,actualTotal);
    }
    @Test
    public void averageScoreForEachSubjectTest() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[] expectedTotal = gradeBook.totalScoreForEachSubject();
        int[] actualTotal = {80,70};
        assertArrayEquals(expectedTotal,actualTotal);
        double[] expected = gradeBook.averageScoreForEachSubject();
        double[] actual = {40, 35};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void numberOfPassesForEachSubjectTest() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);

        int[] expectedPasses = gradeBook.numberOfPassesForEachSubject();
        int[] actualPasses = {1,0};
        assertArrayEquals(expectedPasses,actualPasses);
    }

    @Test
    public void numberOfFailsForEachSubjectTest() {
        gradeBook.setNumberOfSubjects(2);
        gradeBook.setNumberOfStudents(2);
        gradeBook.setGradeBook();

        gradeBook.putScoreIn(1, 1, 30);
        gradeBook.putScoreIn(1, 2, 50);
        gradeBook.putScoreIn(2, 1, 30);
        gradeBook.putScoreIn(2, 2, 40);


        int[] expectedPasses = gradeBook.numberOfPassesForEachSubject();
        int[] actualPasses = {1,0};
        assertArrayEquals(expectedPasses,actualPasses);

        int[] expectedFails = gradeBook.numberOfFailsForEachSubject();
        int[] actualFails = {1,2};
        assertArrayEquals(expectedFails,actualFails);
    }

}