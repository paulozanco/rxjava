package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.ThreadLocalRandom;

public class Launcher_Multicasting_RandomNumbers {

  public static void main(String[] args) {

    System.out.println("Example 1");

    Observable<Integer> threeIntegers = Observable
        .range(1, 3)
        .map(s -> ThreadLocalRandom.current().nextInt(100000));

    threeIntegers.subscribe(s -> System.out.println("Observer One :" + s));
    threeIntegers.subscribe(s -> System.out.println("Observer Two :" + s));

    System.out.println("Example 2");

    ConnectableObservable<Integer> threeIntegers2 = Observable
        .range(1, 3).publish();

    Observable<Integer> threeRandoms = threeIntegers2
        .map(s -> ThreadLocalRandom.current().nextInt(100000));

    threeRandoms.subscribe(s -> System.out.println("Observer One :" + s));
    threeRandoms.subscribe(s -> System.out.println("Observer Two :" + s));

    threeIntegers2.connect();


    System.out.println("Example 3");

    ConnectableObservable<Integer> threeIntegers3 = Observable
        .range(1, 3)
        .map(s -> ThreadLocalRandom.current().nextInt(100000))
        .publish();

    threeIntegers3.subscribe(s -> System.out.println("Observer One :" + s));
    threeIntegers3.subscribe(s -> System.out.println("Observer Two :" + s));

    threeIntegers3.connect();

  }

}
