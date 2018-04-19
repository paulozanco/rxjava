package co.paulozan.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Launcher_BackPressure_Turn_Observable_InBackpressure {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 1000);
        source.toFlowable(BackpressureStrategy.BUFFER)
              .observeOn(Schedulers.io())
              .subscribe(System.out::println);
        sleep(10000);
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
