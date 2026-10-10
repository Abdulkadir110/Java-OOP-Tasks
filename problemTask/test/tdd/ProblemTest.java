import org.junit.jupiter.api.Test;
import tdd.Problem;
import tdd.ProblemType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemTest {

    @Test
    void test(){
        Problem problem = new Problem("got Scammed", ProblemType.FINANCIAL);
        assertEquals("got Scammed", problem.getName());
    }
    @Test
    void anotherTest(){
        Problem problem = new Problem("Sapa");
        assertEquals("Sapa", problem.getName());
    }
}
