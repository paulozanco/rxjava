package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Launcher_Connectable_Observable {

    public static void main(String[] args) {

        ConnectableObservable<String> source = Observable
                .just("Alpha", "Beta", "Gama", "Delta", "Epsilon")
                .publish();

        source.subscribe(System.out::println);

        source.connect();

    }

}
