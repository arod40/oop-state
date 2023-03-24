package semaphore;

public class YellowLight extends TrafficLightState {
    static YellowLight yellowLight;

    public static TrafficLightState getInstance(){
        if (yellowLight == null){
            yellowLight = new YellowLight();
        }
        return yellowLight;
    }
    @Override
    public boolean isIntersectionOpen() {
        return false;
    }

    @Override
    protected TrafficLightState getNextLight() {
        return RedLight.getInstance();
    }

    @Override
    protected int getLightTime(Semaphore semaphore) {
        return semaphore.getTimeYellow();
    }

    @Override
    public String toString() {
        return "YELLOW";
    }
}
