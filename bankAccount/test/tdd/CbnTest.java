package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CbnTest {
    @Test
    void test_that_all_banks_are_added_and_get_bank_at_index_2(){
        Cbn cbn = new Cbn();
        cbn.addAllBanks();
        assertEquals(BankCodes.AFRIBANK, cbn.getBank(2));
    }
}
