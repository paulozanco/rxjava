package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Launcher_Multicasting {

    public static void main(String[] args) {

        ConnectableObservable<Integer> threeIntegers = Observable.range(1, 3).publish();
        threeIntegers.subscribe(s -> System.out.println("Observer One :" + s));
        threeIntegers.subscribe(s -> System.out.println("Observer Two :" + s));
        threeIntegers.connect();

    }

}
