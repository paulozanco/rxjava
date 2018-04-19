package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Launcher_Concurrency_SubscribeOn {

    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .subscribeOn(Schedulers.computation()) //preferred
                  .map(String::length)
                  .filter(i -> i > 5)
                  .subscribe(System.out::println);

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .map(String::length)
                  .subscribeOn(Schedulers.computation())
                  .filter(i -> i > 5)
                  .subscribe(System.out::println);

        Observable
                .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(String::length)
                .filter(i -> i > 5)
                .subscribeOn(Schedulers.computation())
                .subscribe(System.out::println);

        sleep(20000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
