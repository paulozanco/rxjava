package co.paulozan.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Launcher_BackPressure_Flowable_Generate {

    public static void main(String[] args) {
        randomGenerator(1, 10)
                .subscribeOn(Schedulers.computation())
                .doOnNext(i -> System.out.println("Emitting " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(50);
                    System.out.println("Received " + i);
                });
        sleep(Long.MAX_VALUE);
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Flowable<Integer> randomGenerator(int min, int max) {
        return Flowable.generate(emitter -> emitter.onNext(ThreadLocalRandom.current().nextInt(min, max)));
    }
}
