import org.junit.jupiter.api.Test;
import semaphore.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SemaphoreTest {

    @Test
    void testState() throws NoSuchFieldException, IllegalAccessException {
        Semaphore semaphore = new Semaphore(5, 1, 4);
        assertLight(semaphore, RedLight.class);

        for (int i = 0; i < 5; i++) semaphore.advanceSecond();
        assertLight(semaphore, GreenLight.class);

        for (int i = 0; i < 4; i++) semaphore.advanceSecond();
        assertLight(semaphore, YellowLight.class);

        for (int i = 0; i < 1; i++) semaphore.advanceSecond();
        assertLight(semaphore, RedLight.class);
    }

    void assertLight(Semaphore semaphore, Class<? extends TrafficLightState> lightClass)
        throws NoSuchFieldException, IllegalAccessException {
        Field lightField = semaphore.getClass().getDeclaredField("light");
        lightField.setAccessible(true);
        TrafficLightState light = (TrafficLightState) lightField.get(semaphore);

        assertEquals(lightClass, light.getClass());
    }
}
