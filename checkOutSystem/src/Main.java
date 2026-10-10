import tdd.checkOutSystem;
import java.util.Scanner;

private String[] products = new String[5];
private int[] quantities = new int[5];
private double[] pricesOfProduct = new double[5];
private double[] totalPriceOfEach = new double[5];

void main() {
    Scanner input = new Scanner(System.in);

    checkOutSystem cart = new checkOutSystem();
    String customerName = "";
    String item = "";
    int quantity;
    String price = "";
    double pricePerUnit;
    String choice = "";
    int itemCount = 0;

    System.out.println("What is the customer's Name: ");
    customerName = input.nextLine();

    while (!(choice.equals("no"))) {

        IO.println("What did the user buy?");
        item = input.next();
        cart.add(item);

        IO.println("How many pieces: ");
        String numberOfPieces = input.next();
        quantity = Integer.parseInt(numberOfPieces);
        cart.addQuantity(quantity);

        IO.println("How much per unit: ");
        price = input.next();
        pricePerUnit = Double.parseDouble(price);
        cart.addPricePerUnit(pricePerUnit);

        // Populate the local display arrays so tableContents() has data to print
        if (itemCount < products.length) {
            products[itemCount] = item;
            quantities[itemCount] = quantity;
            pricesOfProduct[itemCount] = pricePerUnit;
            totalPriceOfEach[itemCount] = quantity * pricePerUnit;
            itemCount++;
        } else {
            IO.println("Cart is full, cannot add more than " + products.length + " items.");
        }

        IO.println("Add more Items? ");
        choice = input.next().toLowerCase();
    }

    // consume the leftover newline left behind by input.next() before using nextLine()
    input.nextLine();

    IO.println("What is your name? ");
    String cashierName = input.nextLine().toLowerCase();
    IO.println();

    System.out.print("How much discount will he/she get? ");
    String discount = input.next();
    double discountValue = Double.parseDouble(discount);

    String banner = """
    ABDULKADIR STORES
    MAIN BRANCH
    LOCATION : 7, BODE-THOMAS, SURULERE, LAGOS.
    TEL : 08090010101
    DATE : 03-SEP-2026 7:36:11 pm
    """;
    IO.println(banner);
    IO.println("Cashier: " + cashierName);
    IO.println("Customer Name: " + customerName);

    String tableHeading = """
    =========================================================================
            ITEM               QTY            PRICE               TOTAL(NGN)

    --------------------------------------------------------------------------
    """;
    IO.println(tableHeading);
    tableContents();
    IO.println("----------------------------------------------------------------------");
    IO.print("\t\t\t\t\t\t\t\t\t\t\tSub Total:\t\t\t");
    IO.println(cart.subTotal());
    IO.print("\t\t\t\t\t\t\t\t\tDiscount:\t\t\t");
    IO.println(cart.calculateDiscount(discountValue));
    IO.print("\t\t\t\t\t\t\t\t\tVAT @17.5:\t\t\t");
    IO.println(cart.calculateVat());
    IO.println("========================================================================");
    IO.print("\t\t\t\t\t\t\t\t\t\tBill Total:\t\t\t");
    IO.println(cart.calculateBill());

    IO.println("========================================================================");
    IO.println("THIS IS NOT A RECEIPT KINDLY PAY " + cart.calculateBill());
    IO.println("========================================================================");

    IO.println("How much did the customer give to you ");
    String customerAmount = input.next();
    double amount = Double.parseDouble(customerAmount);

    IO.println(banner);
    IO.println("Cashier: " + cashierName);
    IO.println("Customer Name: " + customerName);
    IO.println(tableHeading);
    tableContents();
    IO.print("\t\t\t\t\t\t\t\t\t\t\tBill Total:\t\t\t");
    IO.println(cart.calculateBill());
    IO.print("\t\t\t\t\t\t\t\t\t\t\tAmountPaid:\t\t\t");
    IO.println(amount);
    IO.print("\t\t\t\t\t\t\t\t\t\t\tBalance:\t\t\t");
    IO.println(cart.getBalanceAfterPayment(amount));

    IO.println("========================================================================");
    IO.println("                    THANK YOU FOR YOUR PATRONAGE"                        );
    IO.println("========================================================================");
}

public void tableContents() {
    for (int index = 0; index < products.length; index++) {
        if (products[index] != null) IO.print("\t\t" + products[index] + "\t\t\t ");
        if (quantities[index] != 0) IO.print( quantities[index] + "\t\t\t");
        if (pricesOfProduct[index] != 0) IO.print( pricesOfProduct[index] + "\t\t\t\t");
        if (totalPriceOfEach[index] != 0) IO.println(totalPriceOfEach[index]);
    }
}