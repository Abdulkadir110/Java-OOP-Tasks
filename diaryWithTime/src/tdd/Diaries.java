package tdd;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();
    public void add(String username, String password) {
        validateDuplicate(username);
        Diary diary = new Diary(username, password);
        diaries.add(diary);
    }
    private void validateDuplicate(String username) {
        Diary validateDiary = findByUsername(username);
        if(validateDiary != null) throw new IllegalArgumentException("Please enter a diary that is not existing yet");
    }
    public Diary findByUsername(String username) {
        for(Diary diary : diaries) {
            if(diary.getUsername().equals(username)){
                return diary;
            }
        }
        return null;
    }
    public void delete(String username, String password){
        Diary foundDiary = findByUsername(username);
        diaries.remove(foundDiary);
    }
}
