import semaphore.Semaphore;

import java.util.concurrent.TimeUnit;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5, 1, 4);
        int simSeconds = 60;

        for (int i=0; i<simSeconds; i++){
            System.out.println(semaphore);
            semaphore.advanceSecond();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
