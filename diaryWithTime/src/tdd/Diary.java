package tdd;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();


    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void unlockDiary(String userPassword){
        validatePassword(userPassword);
        isLocked = false;
    }
    public void lockDiary(String userPassword){
        validatePassword(userPassword);
        isLocked = true;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void createEntry(String title, String body) {
        checkIfLocked();
        int id = generateId();
        Entry entry = new Entry(id, title, body);
        entries.add(entry);
    }
    public void deleteEntry(int givenId){
        checkIfLocked();
        validate(givenId);
        Entry foundEntry = findEntryById(givenId);
        entries.remove(foundEntry);
    }
    public Entry findEntryById(int givenId) {
        checkIfLocked();
        boolean isValidId = isValid(givenId);
        if(!isValidId) return null;
        for(Entry entry : entries){
            if(entry.getId() == givenId) {
                return entry;
            }
        }
        return null;
    }
    public void updateEntry(int givenId, String newTitle, String newBody) {
        checkIfLocked();
        validate(givenId);
        Entry foundEntry = findEntryById(givenId);
        foundEntry.setTitle(newTitle);
        foundEntry.setBody(newBody);
    }
    public String getUsername() {
        return username;
    }

    private void checkIfLocked() {
        if(isLocked)throw new IllegalArgumentException("Diary is not unlock yet");
    }
    private int generateId() {
        return entries.size() + 1;
    }
    private void validatePassword(String userPassword){
        if(!this.password.equals(userPassword)) throw new IllegalArgumentException("Incorrect Password");
    }
    private boolean isValid(int givenId) {
        return givenId >= 1 && givenId <= entries.size();
    }
    private void validate(int givenId){
        if(!isValid(givenId)) throw new IllegalArgumentException("Invalid id");
    }
}
