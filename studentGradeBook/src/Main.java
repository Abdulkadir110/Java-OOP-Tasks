import tdd.StudentGradeBook;

import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in);
    StudentGradeBook gradeBook = new StudentGradeBook();

    String succesfulComments = """
    Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Saved successfully
    """;
    String design = """
    ====================================================================
    STUDENT         SUB1    SUB2    SUB3        TOT       AVE      POS
    ====================================================================
    """;

    IO.println("How many students do you have?");
    int numberOfStudents = input.nextInt();
    gradeBook.setNumberOfStudents(numberOfStudents);

    IO.println("How many subjects do you have?");
    int numberOfSubjects = input.nextInt();
    gradeBook.setNumberOfSubjects(numberOfSubjects);

    gradeBook.setGradeBook();
    IO.println(succesfulComments);
    int[][] book = gradeBook.getGradeBook();
    for(int student = 1; student <= numberOfStudents; student++){
        for(int subject = 1; subject <= numberOfSubjects; subject++){
            IO.println("Entering score for student " + student);
            IO.println("Entering score for subject " + subject);
            int score = input.nextInt();
            gradeBook.putScoreIn(subject, student, score);
            IO.println(succesfulComments);
            IO.println();
        }
    }

    IO.println(design);
    int[] totalScores = gradeBook.totalScoreForEachStudent();
    double[] averageScores = gradeBook.averageScoreForEachStudent();
    int[] studentPositions = gradeBook.getPositionOfStudents();
    for (int student = 1; student <= numberOfStudents; student++) {
        IO.print("Student " + student);
        for(int subject = 1; subject <= numberOfSubjects; subject++){
            IO.print("\t\t" + book[subject - 1][student - 1]);
        }
        IO.print("\t\t\t" + totalScores[student - 1]);
        System.out.printf("\t\t %.2f", averageScores[student - 1]);
        IO.println("\t\t" + studentPositions[student - 1]);
    }

    IO.println();
    IO.println("====================================================================");
    IO.println("====================================================================");

    int[][] highestPerSubject = gradeBook.getHighestStudentScoreForEachSubject();
    int[][] lowestPerSubject = gradeBook.getLowestStudentScoreForEachSubject();
    int[] totalPerSubject = gradeBook.totalScoreForEachSubject();
    double[] averagePerSubject = gradeBook.averageScoreForEachSubject();
    int[] passesPerSubject = gradeBook.numberOfPassesForEachSubject();
    int[] failsPerSubject = gradeBook.numberOfFailsForEachSubject();

    IO.println("SUBJECT SUMMARY");
    for(int subject = 1; subject <= numberOfSubjects; subject++) {
        IO.println("Subject " + subject);
        IO.println("Highest scoring student is:  Student " + highestPerSubject[subject - 1][0] + " scoring " + highestPerSubject[subject - 1][1]);
        IO.println("Lowest Scoring student is: student " + lowestPerSubject[subject - 1][0] + " scoring " + lowestPerSubject[subject - 1][1]);
        IO.println("Total Score is:  " + totalPerSubject[subject - 1]);
        System.out.printf("Average score is: %.2f%n", averagePerSubject[subject - 1]);
        IO.println("Number of passes: " + passesPerSubject[subject - 1]);
        IO.println("Number of Fails: " + failsPerSubject[subject - 1]);
        IO.println();
    }
}
