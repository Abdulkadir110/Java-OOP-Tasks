import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    Person person;
    @BeforeEach
    public void startWith(){
        person = new Person();
    }
    @Test
    public void testThat_A_PersonCanAddToProblem(){
        person.addProblem("Got Scammed");
        assertTrue(person.isProblemStatus());

    }
}
