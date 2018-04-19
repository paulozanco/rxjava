package co.paulozan.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Launcher_BackPressure_Creating_Flowable_Manually {

    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isCancelled()) {
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

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
