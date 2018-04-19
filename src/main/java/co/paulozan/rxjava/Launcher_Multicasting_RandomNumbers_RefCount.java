package co.paulozan.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher_Multicasting_RandomNumbers_RefCount {

    public static void main(String[] args) {

        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                          .publish()
                          .refCount();

        seconds.take(5)
               .subscribe(l -> System.out.println("Observer 1: " + l));

        sleep(3000);

        seconds.take(2)
               .subscribe(l -> System.out.println("Observer 2: " + l));

        sleep(5000);

        seconds.subscribe(l -> System.out.println("Observer 3: " + l));

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
