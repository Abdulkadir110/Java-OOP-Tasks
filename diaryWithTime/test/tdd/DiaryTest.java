package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary myDiary;
    private String username = "Abdulkadir";
    private String correctPassword = "1234";
    private String incorrectPassword = "4321";

    @BeforeEach
    void startWtih(){
        myDiary = new Diary(username, correctPassword);
    }
    @Test
    void testThatDiary_isLocked_ByDefault(){
        assertTrue(myDiary.isLocked());
    }
    @Test
    void DiaryIsLocked_userEntersCorrectPassword_DiaryIsUnlock(){
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
    }
    @Test
    void diaryIsLocked_userEntersWrongPassword_ThrowsException_Diary_remainsLocked(){
        assertTrue(myDiary.isLocked());
        assertThrows(IllegalArgumentException.class, () -> myDiary.unlockDiary(incorrectPassword));
        assertTrue(myDiary.isLocked());
    }
    @Test
    void diaryIsLocked_userEntersCorrectPassword_DiaryIsUnlock_userEntersCorrectPassword_DiaryisLocked(){
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.lockDiary(correctPassword);
        assertTrue(myDiary.isLocked());
    }
    @Test
    void diaryIsLocked_userEntersCorrectPassword_DiaryIsUnlock_userEntersWrongPassword_ThrowsException_DiaryRemainsUnLocked(){
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        assertThrows(IllegalArgumentException.class, () -> myDiary.lockDiary(incorrectPassword));
        assertFalse(myDiary.isLocked());
    }
    @Test
    void diary_isLocked_UserUnlock_UserCreatesAnEntry_checkTheEntryByFindingItWithA_Correct_Id(){
        assertTrue(myDiary.isLocked());
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        Entry expectedEntry = myDiary.findEntryById(1);
        assertEquals("School resumption", expectedEntry.getTitle());
    }
    @Test
    void diary_isLocked_UserCreatesAnEntry_throwsException(){
        assertTrue(myDiary.isLocked());
        assertThrows(IllegalArgumentException.class, ()-> myDiary.createEntry("School resumption", "I am going to school  tomorrow"));
    }
    @Test
    void userCreatesAnEntry_checkTheEntryByFindingItWithA_Wrong_Id_throwsException(){
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        assertNull(myDiary.findEntryById(2));
    }
    @Test
    void userUnlock_UserCreatesTwoEntry_DeleteOne_checkTheDeletedEntry(){
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        myDiary.createEntry("Demo", "Mr. Sk's demo");
        myDiary.deleteEntry(2);
        Entry expectedEntry = myDiary.findEntryById(2);
        assertNull(expectedEntry);
    }
    @Test
    void userCreatesTwoEntry_DeleteWithWrongId_findTheEntries_ThrowsException_NothingWasDeleted(){
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        myDiary.createEntry("Demo", "Mr. Sk's demo");
        assertThrows(IllegalArgumentException.class, () -> myDiary.deleteEntry(3));
        Entry expectedEntryOne = myDiary.findEntryById(1);
        assertEquals("School resumption", expectedEntryOne.getTitle());
        Entry expectedEntryTwo = myDiary.findEntryById(2);
        assertEquals("Demo", expectedEntryTwo.getTitle());
    }
    @Test
    void userUnlock_Creates_XYZ_Update_Y_Find_Y_TitleToCheckForTheUpdatedTitle(){
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        myDiary.createEntry("Demo", "Mr. Sk's demo");
        myDiary.createEntry("Orion Hangouts", "Venue: Beach");
        myDiary.updateEntry(2,"Barbing", "I'm going to barb");
        Entry expectedEntry = myDiary.findEntryById(2);
        assertEquals("Barbing", expectedEntry.getTitle());
    }
    @Test
    void userUnlock_Creates_XYZ_Update_WithWrongId_ThrowsException_XYZ_notUpdated(){
        myDiary.unlockDiary(correctPassword);
        assertFalse(myDiary.isLocked());
        myDiary.createEntry("School resumption", "I am going to school  tomorrow");
        myDiary.createEntry("Demo", "Mr. Sk's demo");
        myDiary.createEntry("Orion Hangouts", "Venue: Beach");
        assertThrows(IllegalArgumentException.class, () -> myDiary.updateEntry(4,"Barbing", "I'm going to barb"));
        Entry expectedEntryOne = myDiary.findEntryById(1);
        assertEquals("School resumption", expectedEntryOne.getTitle());
        Entry expectedEntryTwo = myDiary.findEntryById(2);
        assertEquals("Demo", expectedEntryTwo.getTitle());
        Entry expectedEntryThree = myDiary.findEntryById(3);
        assertEquals("Orion Hangouts", expectedEntryThree.getTitle());
    }

}