package co.paulozan.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher_Operator_Take_Interval {

    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                  .take(2, TimeUnit.SECONDS)
                  .subscribe(i -> System.out.println("RECEIVED: " + i));
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
