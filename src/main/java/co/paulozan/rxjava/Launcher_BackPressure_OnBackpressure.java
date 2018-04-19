package co.paulozan.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Launcher_BackPressure_OnBackpressure {

    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(5);
                    System.out.println(i);
                });
        sleep(5000);
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
