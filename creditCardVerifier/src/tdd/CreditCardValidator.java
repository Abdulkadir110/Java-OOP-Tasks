package tdd;

public class CreditCardValidator {
    private final String cardNumber;
    private String cardType;

    public CreditCardValidator(String cardNumber){
        this.cardNumber = cardNumber;
    }
    public boolean isValidNumber() {
        boolean valid = false;
        for(int digit = 0; digit < cardNumber.length(); digit++){
            if(Character.isDigit(cardNumber.charAt(digit))) valid = true;
            else {
                return false;
            }
        }
        return valid;
    }

    public boolean isValidLength() {
        if(!isValidNumber()) return false;
        int length = cardNumber.length();
        return length >= 13 && length <= 16;
    }
    public boolean isValidCardType() {
        if(!isValidNumber() || !isValidLength()) return false;
        if(cardNumber.charAt(0) == '4')  {
            return true;
        }
        else if(cardNumber.charAt(0) == '5') {
            return true;
        }
        else if(cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7') {
            return true;
        }
        else if(cardNumber.charAt(0) == '6') {
            return true;
        }
        return false;
    }
    public void setCardType(){
        if(cardNumber.charAt(0) == '4')  {
            cardType = "Visa Cards";
        }
        else if(cardNumber.charAt(0) == '5') {
            cardType = "MasterCard";
        }
        else if(cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7') {
            cardType = "American Express Cards";
        }
        else if(cardNumber.charAt(0) == '6') {
            cardType = "Discover cards";
        }
    }
    public String getCardType(){
        return cardType;
    }

    private int[] toDigitArray() {
        int[] cardNumbers = new int[cardNumber.length()];
        for (int index = 0; index < cardNumber.length(); index++) {
            int digits = Character.getNumericValue(cardNumber.charAt(index));
            cardNumbers[index] = digits;
        }
        return cardNumbers;
    }

    private int sumDoubledEvenIndexDigits(int[] cardNumbers) {
        int sum = 0;
        for (int index = 0; index < cardNumbers.length; index += 2) {
            sum += reduceToSingleDigit(cardNumbers[index] * 2);
        }
        return sum;
    }

    private int sumOddIndexDigits(int[] cardNumbers) {
        int sum = 0;
        for (int index = 1; index < cardNumbers.length; index += 2) {
            sum += cardNumbers[index];
        }
        return sum;
    }

    private int reduceToSingleDigit(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    public boolean checkValidity() {
        int[] cardNumbers = toDigitArray();
        int sum = sumDoubledEvenIndexDigits(cardNumbers) + sumOddIndexDigits(cardNumbers);
        return sum % 10 == 0;
    }
}
