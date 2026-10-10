package tdd;

import java.util.List;

public class Person {
    private List<String> problemList;
    private boolean problemStatus;

    public void addProblem(String problem){
        problemList.add(problem);
        problemStatus = false;
    }
    public void solveProblem(){
        problemStatus = true;
    }

    public boolean isProblemStatus() {
        return problemStatus;
    }

    public List<String> tellProblem(){
        return problemList;
    }
}
