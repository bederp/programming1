package pl.beder;

import java.time.Duration;

public class App {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long total = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            total += i;
        }
        long stopTime = System.nanoTime();
        long seconds = Duration.ofNanos(stopTime - startTime).toMillis();
        System.out.println(seconds + "ms");
    }
}
