package tdd;

public class AutomaticBike {
    private boolean isOn;
    private int gearStatus;
    private int gearSpeed;
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }
    public boolean status(){
        return isOn;
    }
    public void setGear(int gear) {
        if(!(status()))throw new IllegalArgumentException("The bike is not on");
        gearStatus = gear;
    }
    public int getGear() {
        return gearStatus;
    }
    public void setSpeed(int initalSpeed){
        gearSpeed = initalSpeed;
    }
    public int getSpeed(){
        return gearSpeed;
    }
    public void accelerate() {
        if(gearStatus == 1) gearSpeed += 1;
        if(gearStatus == 2) gearSpeed += 2;
        if(gearStatus == 3) gearSpeed += 3;
        if(gearStatus >= 4) gearSpeed += 4;
        shiftGear();
    }
    public void deccelerate() {
        if(gearStatus == 1) gearSpeed -= 1;
        if(gearStatus == 2) gearSpeed -= 2;
        if(gearStatus == 3) gearSpeed -= 3;
        if(gearStatus >= 4) gearSpeed -= 4;
        shiftGear();
    }
    public void shiftGear(){
        if(gearSpeed >= 0 && gearSpeed <= 20) gearStatus = 1;
        if(gearSpeed >= 21 && gearSpeed <= 30) gearStatus = 2;
        if(gearSpeed >= 31 && gearSpeed <= 40) gearStatus = 3;
        if(gearSpeed >= 41) gearStatus = 4;
    }
}
