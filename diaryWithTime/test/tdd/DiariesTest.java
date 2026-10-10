package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    private Diaries myDiaries;
    @BeforeEach
    void startWith(){
        myDiaries = new Diaries();
    }
    @Test
    void testThatIAdd_DiaryX_X_IsInDiaries(){
        myDiaries.add("Abdulkadir", "1111");
        Diary expectedDiary = myDiaries.findByUsername("Abdulkadir");
        assertEquals("Abdulkadir", expectedDiary.getUsername());
    }
    @Test
    void IAddX_findY_returnsNull(){
        myDiaries.add("Abdulkadir", "1111");
        Diary expectedDiary = myDiaries.findByUsername("Opeyemi");
        assertNull(expectedDiary);
    }
    @Test
    void testThatIAdd_DiaryXY_DeleteX_cantFindXAnyMore(){
        myDiaries.add("Abdulkadir", "1111");
        myDiaries.add("Opeyemi", "234");
        myDiaries.delete("Abdulkadir", "1111");
        Diary expectedDiary = myDiaries.findByUsername("Abdulkadir");
        assertNull(expectedDiary);
    }
    @Test
    void IAdd_X_And_X_Diaries_Contains_No_duplicates(){
        myDiaries.add("Abdulkadir", "1111");
        assertThrows(IllegalArgumentException.class, () -> myDiaries.add("Abdulkadir", "234"));
        Diary expectedDiary = myDiaries.findByUsername("Abdulkadir");
        assertEquals("Abdulkadir", expectedDiary.getUsername());
    }

}
