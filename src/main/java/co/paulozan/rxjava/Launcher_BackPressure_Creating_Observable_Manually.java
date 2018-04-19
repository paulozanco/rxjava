package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Launcher_BackPressure_Creating_Observable_Manually {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isDisposed()) {
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        });

        source.observeOn(Schedulers.io())
              .subscribe(System.out::println);

        sleep(1000);
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
