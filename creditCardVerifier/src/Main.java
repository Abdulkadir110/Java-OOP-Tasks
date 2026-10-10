import tdd.CreditCardValidator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner input = new Scanner(System.in);
    System.out.println("Hello, Kindly Enter Card details to verify: ");
    String cardNumber = input.nextLine();

    CreditCardValidator validator = new CreditCardValidator(cardNumber);

    String banner = "***************************************";
    String cardStatus;
    if(validator.checkValidity()){
        cardStatus = "Valid";
    }
    else {
        cardStatus = "Invalid";
    }
    validator.setCardType();
    IO.println(banner);
    IO.println("***Credit Card Type: " + validator.getCardType());
    IO.println("***Credit Card Number: " + cardNumber);
    IO.println("***Credit Card Digit Length: " + cardNumber.length());
    IO.println("***Credit Card Type: " + cardStatus);
    IO.println(banner);
}
