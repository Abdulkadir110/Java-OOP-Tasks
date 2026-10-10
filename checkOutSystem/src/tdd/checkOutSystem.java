package tdd;
public class checkOutSystem {
    private String[] products = new String[5];
    private int[] quantities = new int[5];
    private double[] pricesOfProduct = new double[5];
    private double[] totalPriceOfEach = new double[5];
    private double discountAmount = 0.0;
    private int count;

    public boolean isEmpty(){
        return count == 0;
    }
    public void add(String product) {
        products[count] = product;
    }
    public void addQuantity(int quantity){
        if(quantity > 0){
            quantities[count] = quantity;
        }
        else {
            throw new IllegalArgumentException("please add numbers above 0");
        }
    }
    public void addPricePerUnit(double pricePerUnit){
        if(pricePerUnit > 0){
            pricesOfProduct[count++] = pricePerUnit;
        }
        else {
            throw new IllegalArgumentException("please add numbers above 0");
        }
    }
    public double[] totalPriceOfEachProduct(){
        for(int index = 0; index < products.length; index++){
            totalPriceOfEach[index] = pricesOfProduct[index] * quantities[index];
        }
        return totalPriceOfEach;
    }
    public double subTotal() {
        double subTotal = 0.0;
        for(int index = 0; index < products.length; index++){
            subTotal += pricesOfProduct[index] * quantities[index];
        }
        return subTotal;
    }
    public double calculateDiscount(double discount) {
        discountAmount = subTotal() * discount / 100;
        return discountAmount;
    }
    public double calculateVat() {
        return subTotal() * 0.175;
    }
    public double calculateBill() {
        return subTotal() - discountAmount + calculateVat();
    }
    public double getBalanceAfterPayment(double amount) {
        double totalBill = calculateBill();
        if(amount > totalBill)return amount - calculateBill();
        throw new IllegalArgumentException("Transaction unsuccesfull");
    }
}