package tdd;

public class StudentGradeBook {
    private int count;
    private int[][] gradeBook;
    private int numberOfStudents;
    private int numberOfSubjects;
    private int[] totalScoresForStudents;
    private double[] averageScoresForStudents;
    private int[] positions;
    private int[] highestStudentAndScore = new int[2];
    private int[] lowestStudentAndScore = new int[2];
    private int[][] highestScoreForEachSubject;
    private int[][] lowestScoreForEachSubject;
    private int[] totalScoresForSubjects;
    private double[] averageScoresForSubjects;
    private int[] numberOfPassesForSubjects;
    private int[] numberOfFailsForSubjects;
    private int passMark = 50;

    public boolean isEmpty() {
        return count == 0;
    }
    public void setNumberOfStudents(int number){
        if(number < 0)throw new IllegalArgumentException("Invalid inputs");
        numberOfStudents = number;
    }
    public void setNumberOfSubjects(int number){
        if(number < 0)throw new IllegalArgumentException("Invalid inputs");
        numberOfSubjects = number;
    }
    public void setGradeBook(){
        gradeBook = new int[numberOfSubjects][numberOfStudents];
    }
    public int[][] getGradeBook(){
        return gradeBook;
    }
    public void putScoreIn(int subject, int student, int score){
        if(score < 0 || score > 100 || subject <= 0 || subject > numberOfSubjects || student <= 0 || student > numberOfStudents){
            throw new IllegalArgumentException("Invalid inputs");
        }
        gradeBook[subject - 1][student-1] = score;
        count = 1;
    }
    public int[] totalScoreForEachStudent(){
        totalScoresForStudents = new int[numberOfStudents];
        int total = 0;
        for(int student = 0; student < numberOfStudents; student++){
            total = 0;
            for(int subject = 0; subject < numberOfSubjects; subject++){
                total += gradeBook[subject][student];
            }
            totalScoresForStudents[student] = total;
        }
        return totalScoresForStudents;
    }
    public double[] averageScoreForEachStudent() {
        averageScoresForStudents = new double[numberOfStudents];
        double average = 0.0;
        int[] total = totalScoresForStudents;
        for(int score = 0; score < total.length; score++){
            average = (double) total[score] / numberOfSubjects;
            averageScoresForStudents[score] = average;
        }
        return averageScoresForStudents;
    }
    public int[] getPositionOfStudents() {
        positions = new int[numberOfStudents];
        double[] average = averageScoresForStudents;
        int count = 0;
        for(int index = 0; index < average.length; index++){
            count = 0;
            for(int secondIndex = 0; secondIndex < average.length; secondIndex++){
                if(average[secondIndex] >= average[index])count++;
            }
            positions[index] = count;
        }
        return positions;
    }
    public int[] getHighestStudentAndScoreForSubject(int subject){
        if(subject <= 0 || subject > numberOfSubjects) throw new IllegalArgumentException("Invalid inputs");
        int subjectIndex = subject - 1;
        int highestScore = gradeBook[subjectIndex][0];
        int highestStudent = 0;
        for(int student = 1; student < numberOfStudents; student++){
            if(gradeBook[subjectIndex][student] > highestScore){
                highestScore = gradeBook[subjectIndex][student];
                highestStudent = student;
            }
        }
        highestStudentAndScore[0] = highestStudent + 1;
        highestStudentAndScore[1] = highestScore;
        return highestStudentAndScore;
    }
    public int[] getLowestStudentAndScoreForSubject(int subject){
        if(subject <= 0 || subject > numberOfSubjects) throw new IllegalArgumentException("Invalid inputs");
        int subjectIndex = subject - 1;
        int lowestScore = gradeBook[subjectIndex][0];
        int lowestStudent = 0;
        for(int student = 1; student < numberOfStudents; student++){
            if(gradeBook[subjectIndex][student] < lowestScore){
                lowestScore = gradeBook[subjectIndex][student];
                lowestStudent = student;
            }
        }
        lowestStudentAndScore[0] = lowestStudent + 1;
        lowestStudentAndScore[1] = lowestScore;
        return lowestStudentAndScore;
    }
    public int[][] getHighestStudentScoreForEachSubject(){
        highestScoreForEachSubject = new int[numberOfSubjects][2];
        for(int subject = 1; subject <= numberOfSubjects; subject++){
            int[] result = getHighestStudentAndScoreForSubject(subject);
            highestScoreForEachSubject[subject - 1][0] = result[0];
            highestScoreForEachSubject[subject - 1][1] = result[1];
        }
        return highestScoreForEachSubject;
    }
    public int[][] getLowestStudentScoreForEachSubject(){
        lowestScoreForEachSubject = new int[numberOfSubjects][2];
        for(int subject = 1; subject <= numberOfSubjects; subject++){
            int[] result = getLowestStudentAndScoreForSubject(subject);
            lowestScoreForEachSubject[subject - 1][0] = result[0];
            lowestScoreForEachSubject[subject - 1][1] = result[1];
        }
        return lowestScoreForEachSubject;
    }
    public int[] totalScoreForEachSubject(){
        totalScoresForSubjects = new int[numberOfSubjects];
        for(int subject = 0; subject < numberOfSubjects; subject++){
            int total = 0;
            for(int student = 0; student < numberOfStudents; student++){
                total += gradeBook[subject][student];
            }
            totalScoresForSubjects[subject] = total;
        }
        return totalScoresForSubjects;
    }
    public double[] averageScoreForEachSubject(){
        averageScoresForSubjects = new double[numberOfSubjects];
        int[] total = totalScoresForSubjects;
        for(int subject = 0; subject < total.length; subject++){
            averageScoresForSubjects[subject] = (double) total[subject] / numberOfStudents;
        }
        return averageScoresForSubjects;
    }
    public int getPassMark(){
        return passMark;
    }
    public int[] numberOfPassesForEachSubject(){
        numberOfPassesForSubjects = new int[numberOfSubjects];
        for(int subject = 0; subject < numberOfSubjects; subject++){
            int passes = 0;
            for(int student = 0; student < numberOfStudents; student++){
                if(gradeBook[subject][student] >= passMark) passes++;
            }
            numberOfPassesForSubjects[subject] = passes;
        }
        return numberOfPassesForSubjects;
    }
    public int[] numberOfFailsForEachSubject(){
        numberOfFailsForSubjects = new int[numberOfSubjects];
        int[] passes = numberOfPassesForSubjects;
        for(int subject = 0; subject < passes.length; subject++){
            numberOfFailsForSubjects[subject] = numberOfStudents - passes[subject];
        }
        return numberOfFailsForSubjects;
    }
}