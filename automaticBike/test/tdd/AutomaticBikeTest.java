import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.AutomaticBike;

import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {
    private AutomaticBike bike;
    @BeforeEach
    public void startWith(){
        bike = new AutomaticBike();
    }
    @Test
    public void theBikeIsOff(){
       bike.turnOff();
       assertFalse(bike.status());
    }
    @Test
    public void theBikeIsOn(){
        bike.turnOn();
        assertTrue(bike.status());
    }
    @Test
    public void onAndOffTheBike(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.turnOff();
        assertFalse(bike.status());
    }
    @Test
    public void bikeOnGearOne(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
    }`
    @Test
    public void bikeIsOff_GearOne(){
        bike.turnOff();
        assertFalse(bike.status());
        assertThrows(IllegalArgumentException.class,() -> bike.setGear(1));
        assertEquals(bike.getGear(), 0);
    }
    @Test
    public void bikeOnGearTwo(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(2);
        assertEquals(bike.getGear(), 2);
    }
    @Test
    public void bikeOnGearOne_SpeedOnOne(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(1);
        assertEquals(bike.getSpeed(), 1);
    }
    @Test
    public void bikeOnGearOne_SpeedOnFifteen(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(15);
        assertEquals(bike.getSpeed(), 15);
    }
    @Test
    public void bikeOnGearOne_SpeedOnFifteen_accelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(15);
        assertEquals(bike.getSpeed(), 15);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 16);
    }
    @Test
    public void bikeOnGear2_SpeedOn30_accelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(2);
        assertEquals(bike.getGear(), 2);
        bike.setSpeed(30);
        assertEquals(bike.getSpeed(), 30);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 32);
    }
    @Test
    public void bikeOnGear3_SpeedOn37_accelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(3);
        assertEquals(bike.getGear(), 3);
        bike.setSpeed(37);
        assertEquals(bike.getSpeed(), 37);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 40);
    }
    @Test
    public void bikeOnGear4_SpeedOn45_accelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(4);
        assertEquals(bike.getGear(), 4);
        bike.setSpeed(45);
        assertEquals(bike.getSpeed(), 45);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 49);
    }
    @Test
    public void bikeOnGear1_SpeedOn15_deccelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(15);
        assertEquals(bike.getSpeed(), 15);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 14);
    }
    @Test
    public void bikeOnGear2_SpeedOn24_deccelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(2);
        assertEquals(bike.getGear(), 2);
        bike.setSpeed(24);
        assertEquals(bike.getSpeed(), 24);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 22);
    }
    @Test
    public void bikeOnGear3_SpeedOn35_deccelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(3);
        assertEquals(bike.getGear(), 3);
        bike.setSpeed(35);
        assertEquals(bike.getSpeed(), 35);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 32);
    }
    @Test
    public void bikeOnGear4_SpeedOn44_deccelerate(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(4);
        assertEquals(bike.getGear(), 4);
        bike.setSpeed(44);
        assertEquals(bike.getSpeed(), 44);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 40);
    }
    @Test
    public void acceleratingFromSpeed15To_21(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(15);
        assertEquals(bike.getSpeed(), 15);
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        assertEquals(bike.getSpeed(), 21);
    }
    @Test
    public void automaticTransmissionFromGear1_to_2(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(1);
        assertEquals(bike.getGear(), 1);
        bike.setSpeed(15);
        assertEquals(bike.getSpeed(), 15);
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        bike.accelerate();
        assertEquals(bike.getSpeed(), 21);
        assertEquals(bike.getGear(), 2);
    }
    @Test
    public void automaticTransmissionFromGear3_to_4(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(3);
        assertEquals(bike.getGear(), 3);
        bike.setSpeed(31);
        assertEquals(bike.getSpeed(), 31);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 34);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 37);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 40);
        bike.accelerate();
        assertEquals(bike.getSpeed(), 43);
        assertEquals(bike.getGear(), 4);

    }
    @Test
    public void decceleratingFrom40to24(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(3);
        assertEquals(bike.getGear(), 3);
        bike.setSpeed(40);
        assertEquals(bike.getSpeed(), 40);
        bike.deccelerate();
        bike.deccelerate();
        bike.deccelerate();
        bike.deccelerate();
        bike.deccelerate();
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 24);
    }
    @Test
    public void automaticTransmissionFromGear4_to_2(){
        bike.turnOn();
        assertTrue(bike.status());
        bike.setGear(4);
        assertEquals(bike.getGear(), 4);
        bike.setSpeed(44);
        assertEquals(bike.getSpeed(), 44);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 40);
        assertEquals(bike.getGear(), 3);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 37);
        assertEquals(bike.getGear(), 3);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 34);
        assertEquals(bike.getGear(), 3);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 31);
        assertEquals(bike.getGear(), 3);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 28);
        assertEquals(bike.getGear(), 2);
        bike.deccelerate();
        assertEquals(bike.getSpeed(), 26);
        assertEquals(bike.getGear(), 2);
    }
}
