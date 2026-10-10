import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.airConditional;

import static org.junit.jupiter.api.Assertions.*;

public class airConditionalTest {
    private airConditional thermocool;
    @BeforeEach
    public void startWith(){
        thermocool = new airConditional();
    }
    @Test
    public void Ac_IsOnTest(){
        assertTrue(thermocool.turnOn());
    }
    @Test
    public void Ac_IsOffTest(){
        assertTrue(thermocool.turnOn());
        assertFalse(thermocool.turnOff());
    }
    @Test
    public void Ac_IsOn_IncreaseTheTemperatureTest(){
        assertTrue(thermocool.turnOn());
        thermocool.increase();
        assertEquals(thermocool.getTemperature(), 17);
    }
    @Test
    public void Ac_IsOff_IncreaseTheTemperatureThrowsException(){
        assertFalse(thermocool.turnOff());
        assertThrows(IllegalArgumentException.class,() -> thermocool.increase());
        assertEquals(thermocool.getTemperature(), 16);
    }
    @Test
    public void Ac_isOn_IncreaseAndDecreaseTheTemperature(){
        assertTrue(thermocool.turnOn());
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        assertEquals(thermocool.getTemperature(), 21);

        thermocool.decrease();
        assertEquals(thermocool.getTemperature(),20);
    }
    @Test
    public void Ac_isOn_IDecreaseWhenTheTemperatureIsAtMinimum(){
        assertTrue(thermocool.turnOn());
        assertThrows(IllegalArgumentException.class,() -> thermocool.decrease());
    }
    @Test
    public void Ac_isOn_IncreaseTheTemperatureToMax_Increase_throwsException(){
        assertTrue(thermocool.turnOn());
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        assertEquals(thermocool.getTemperature(), 21);
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        thermocool.increase();
        assertEquals(thermocool.getTemperature(), 28);
        thermocool.increase();
        thermocool.increase();
        assertEquals(thermocool.getTemperature(), 30);
        assertThrows(IllegalArgumentException.class,() -> thermocool.increase());
    }
}
