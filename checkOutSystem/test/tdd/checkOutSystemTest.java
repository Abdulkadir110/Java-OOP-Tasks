import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.checkOutSystem;

import static org.junit.jupiter.api.Assertions.*;

public class checkOutSystemTest {
    private checkOutSystem cart;
    @BeforeEach
    public void startWiths(){
        cart = new checkOutSystem();
    }
    @Test
    public void theCartIsEmptyTest(){
        assertTrue(cart.isEmpty());
    }
//    @Test
//    public void IAddProductXToTheCart(){
//        assertTrue(cart.isEmpty());
//        cart.add("Rice");
//        assertFalse(cart.isEmpty());
//    }
//    @Test
//    public void IAddProductX_And_NumberOfXToTheCart(){
//        assertTrue(cart.isEmpty());
//        cart.add("Rice");
//        cart.addQuantity(9);
//        assertFalse(cart.isEmpty()
    @Test
    public void IAddProductX_And_NumberOfX_pricePerXToTheCart(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(9);
        cart.addPricePerUnit(1000);
        assertFalse(cart.isEmpty());
    }
    @Test
    public void IAddProductX_And_NegativeNumberOfXThrowsException(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        assertThrows(IllegalArgumentException.class,() -> cart.addQuantity(-1));
    }
    @Test
    public void IAddProductX_And_NumberOfXAnd_NegativePriceThrowsException(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(9);
        assertThrows(IllegalArgumentException.class,() -> cart.addPricePerUnit(-1));
    }
    @Test
    public void IAddProductX_numberOfX_pricePerX_totalForTheBill(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        double[] expectedTotal = cart.totalPriceOfEachProduct();
        double[] actualTotal = {2000, 0, 0, 0, 0};
        assertArrayEquals(expectedTotal, actualTotal);
    }
    @Test
    public void IAddProductXY_numberOfXY_pricePerXY_totalForTheBillXY() {
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        double[] actualXTotal = {2000, 0, 0, 0, 0};
        assertArrayEquals(cart.totalPriceOfEachProduct(), actualXTotal);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);
        double[] actualYTotal = {2000, 5000, 0, 0, 0};
        assertArrayEquals(cart.totalPriceOfEachProduct(), actualYTotal);
    }
    @Test
    public void IGetSubTotalBillXYTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000);
    }
    @Test
    public void discountOfTheSubTotalTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000);
        double expectedDiscount = cart.calculateDiscount(8);
        assertEquals(expectedDiscount, 560.00);
    }
    @Test
    public void valueAddedTaxOfTheSubTotalTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000.0);
        assertEquals(cart.calculateVat(), 1225.0);
    }
    @Test
    public void totalBillOfTheSubTotalTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000.0);
        assertEquals(cart.calculateDiscount(8), 560.00);
        assertEquals(cart.calculateVat(), 1225.0);
        assertEquals(cart.calculateBill(), 7665.0);

    }
    @Test
    public void amountPaidMinusBillTotalTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000.0);
        assertEquals(cart.calculateDiscount(8), 560.00);
        assertEquals(cart.calculateVat(), 1225.0);
        assertEquals(cart.calculateBill(), 7665.0);
        assertEquals(cart.getBalanceAfterPayment(8000),335);
    }
    @Test
    public void amountPaidIsLesserThanBillTotalTest(){
        assertTrue(cart.isEmpty());
        cart.add("Rice");
        cart.addQuantity(5);
        cart.addPricePerUnit(400);
        assertFalse(cart.isEmpty());
        cart.add("Beans");
        cart.addQuantity(10);
        cart.addPricePerUnit(500);

        assertEquals(cart.subTotal(), 7000.0);
        assertEquals(cart.calculateDiscount(8), 560.00);
        assertEquals(cart.calculateVat(), 1225.0);
        assertEquals(cart.calculateBill(), 7665.0);
        assertThrows(IllegalArgumentException.class,() -> cart.getBalanceAfterPayment(7000));
    }

}
