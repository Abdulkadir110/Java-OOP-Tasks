package tdd;

public class airConditional {
    private boolean isOn;
    private int temperature = 16;
    public boolean turnOn() {
        isOn = true;
        return isOn;
    }
    public boolean turnOff() {
        isOn = false;
        return isOn;
    }
    public void increase() {
        if(!(isOn))throw new IllegalArgumentException("The Ac is Off");
        else if(temperature == 30) throw new IllegalArgumentException("The Ac is at maximum");
        temperature++;
    }
    public int getTemperature(){
        return temperature;
    }
    public void decrease() {
        if(!(isOn))throw new IllegalArgumentException("The Ac is Off");
        else if(temperature == 16) throw new IllegalArgumentException("The Ac is at maximum");
        temperature--;
    }
}
