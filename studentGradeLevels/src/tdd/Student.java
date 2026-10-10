package tdd;

public class Student {
    private String name;
    private int gradeLevel = 1;

    public Student(String name) {
        this.name = name;
    }
    public String display() {
        return this.name + ", your grade level is " + this.gradeLevel;
    }
    public void promote() {
        if (this.gradeLevel < 12)this.gradeLevel++;
    }
    public boolean hasPassed(double score) {
        if (score < 0 || score > 100) throw new IllegalArgumentException("Wrong score");
        return score >= 50;
    }
    public void updateName(String newName) {
        this.name = newName;
    }
    public boolean isGraduating() {
        return this.gradeLevel == 12;
    }
}
