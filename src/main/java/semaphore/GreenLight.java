package semaphore;

public class GreenLight extends TrafficLightState {
    static GreenLight greenLight;

    public static TrafficLightState getInstance(){
        if (greenLight == null){
            greenLight = new GreenLight();
        }
        return greenLight;
    }
    @Override
    public boolean isIntersectionOpen() {
        return true;
    }

    @Override
    protected TrafficLightState getNextLight() {
        return YellowLight.getInstance();
    }

    @Override
    protected int getLightTime(Semaphore semaphore) {
        return semaphore.getTimeGreen();
    }

    @Override
    public String toString() {
        return "GREEN";
    }
}
