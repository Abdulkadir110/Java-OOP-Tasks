package tdd;

public class Problem {
    private String name;
    private String description;
    ProblemType type;
    private boolean status;

    public Problem(String problemName, ProblemType type){
        this.name = problemName;
        this.type = ProblemType.FINANCIAL;
    }

    public Problem(String problemName){
        this.name = problemName;
    }
    public Problem(ProblemType type){
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
