package semaphore;

public class Semaphore {
    TrafficLightState light;

    int timer;

    int timeRed;
    int timeYellow;
    int timeGreen;

    public Semaphore(int timeRed, int timeYellow, int timeGreen){
        this.light = RedLight.getInstance();
        this.timer = timeRed;
        this.timeRed = timeRed;
        this.timeYellow = timeYellow;
        this.timeGreen = timeGreen;
    }

    // For testing purposes
    public TrafficLightState getState(){
        return this.light;
    }

    public int getTimeGreen() {
        return timeGreen;
    }

    public int getTimeRed() {
        return timeRed;
    }

    public int getTimeYellow() {
        return timeYellow;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setLight(TrafficLightState newLight){
        this.light = newLight;
    }

    public boolean isIntersectionOpen() {
        return this.light.isIntersectionOpen();
    }

    public void advanceSecond(){
        this.timer--;
        if(this.timer == 0) {
            this.light.changeLight(this);
            this.timer = this.light.getLightTime(this);
        }
    }

    public String toString(){
        return this.light.toString() + " light. Traffic open: " + this.isIntersectionOpen() + ". Remaining time: " + this.timer;
    }
}
