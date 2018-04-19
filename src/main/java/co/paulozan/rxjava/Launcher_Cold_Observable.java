package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Cold_Observable {

    public static void main(String[] args) {
        Observable<String> source = Observable
                .just("Alpha", "Beta", "Gama", "Delta", "Epsilon");

        source.subscribe(s -> System.out.println("First observer : " + s));
        source.subscribe(s -> System.out.println("Second observer : " + s));

    }

}
