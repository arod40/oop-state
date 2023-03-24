package semaphore;

public class RedLight extends TrafficLightState {
    static RedLight redLight;

    public static TrafficLightState getInstance(){
        if (redLight == null){
            redLight = new RedLight();
        }
        return redLight;
    }

    @Override
    public boolean isIntersectionOpen() {
        return false;
    }

    @Override
    protected TrafficLightState getNextLight() {
        return GreenLight.getInstance();
    }

    @Override
    protected int getLightTime(Semaphore semaphore) {
        return semaphore.getTimeRed();
    }

    @Override
    public String toString() {
        return "RED";
    }
}
