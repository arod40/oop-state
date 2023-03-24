package semaphore;

public abstract class TrafficLightState {
    public abstract boolean isIntersectionOpen();

    protected abstract TrafficLightState getNextLight();

    protected abstract int getLightTime(Semaphore semaphore);

    protected void changeLight(Semaphore semaphore) {
        semaphore.setLight(getNextLight());
    }
}
