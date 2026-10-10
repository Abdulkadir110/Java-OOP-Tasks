import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CreditCardValidator;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    private CreditCardValidator validator;

    @BeforeEach
    void startWith() {
        validator = new CreditCardValidator("4388576018410707");
    }
    @Test
    public void testThatCreditCardNumberOnlyContainsNumbers() {
        assertTrue(validator.isValidNumber());
    }
    @Test
    public void testThatCreditCardNumberContainsNumbersAndOtherCharacters() {
        CreditCardValidator validity = new CreditCardValidator("45d355-4322d355e");
        assertFalse(validity.isValidNumber());
    }
    @Test
    public void testThatCreditCardNumberIsWithinTheLengthOf_13_and_16() {
        assertTrue(validator.isValidNumber());
        assertTrue(validator.isValidLength());
    }
    @Test
    public void testThatCreditCardNumberIsNotWithinTheLengthOf_13_and_16() {
        CreditCardValidator validity = new CreditCardValidator("457543554322355565");
        assertTrue(validity.isValidNumber());
        assertFalse(validity.isValidLength());
    }
    @Test
    public void testThatCreditCardNumberIsNotOnlyNumbers_WithinTheLengthOf_13_and_16() {
        CreditCardValidator validity = new CreditCardValidator("45754\\seada556");
        assertFalse(validity.isValidNumber());
        assertFalse(validity.isValidLength());
    }
    @Test
    public void testThatCardNumberFallUnderTheTypesOfCreditCard() {
        assertTrue(validator.isValidCardType());
        validator.setCardType();
        assertEquals(validator.getCardType(),"Visa Cards");
    }
    @Test
    public void testThatMasterCardIsDetected() {
        CreditCardValidator mastercard = new CreditCardValidator("5597405559875559");
        assertTrue(mastercard.isValidCardType());
        mastercard.setCardType();
        assertEquals(mastercard.getCardType(),"MasterCard");
    }
    @Test
    public void testThatAmericanExpressIsDetected() {
        CreditCardValidator americanExp = new CreditCardValidator("374245455400126");
        assertTrue(americanExp.isValidCardType());
        americanExp.setCardType();
        assertEquals(americanExp.getCardType(),"American Express Cards");
    }
    @Test
    public void testThatDiscoverCardIsDetected() {
        CreditCardValidator discover = new CreditCardValidator("6011000990139424");
        assertTrue(discover.isValidCardType());
        discover.setCardType();
        assertEquals(discover.getCardType(),"Discover cards");
    }

    @Test
    public void testThatUnrecognizedPrefixIsNotAValidCardType() {
        CreditCardValidator validator1 = new CreditCardValidator("9988576018410707");
        assertFalse(validator1.isValidCardType());
        assertNull(validator1.getCardType());
    }
    @Test
    public void testThatTheCardIsValid() {
        assertTrue(validator.checkValidity());
    }

    @Test
    public void testThatACardWithABadLuhnSumIsInvalid() {
        CreditCardValidator invalid = new CreditCardValidator("4388576018410708");
        assertFalse(invalid.checkValidity());
    }
}