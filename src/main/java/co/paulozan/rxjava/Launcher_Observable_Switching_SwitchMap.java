package co.paulozan.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Launcher_Observable_Switching_SwitchMap {

    public static void main(String[] args) {

        Observable<String> items = Observable
                .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota");

        Observable<String> processStrings = items.concatMap(
                s -> Observable
                        .just(s)
                        .delay(randomSleepTime(), TimeUnit.MILLISECONDS)
        );

        Observable
                .interval(5, TimeUnit.SECONDS)
                .switchMap(
                        i -> processStrings.doOnDispose(
                                () -> System.out.println("Disposing! Starting next")
                        )
                ).subscribe(System.out::println);

        sleep(20000);
    }

    public static int randomSleepTime() {
        return ThreadLocalRandom.current().nextInt(2000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
