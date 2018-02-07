package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.ThreadLocalRandom;

public class Launcher_Multicasting_RandomNumbers_Reduce {

  public static void main(String[] args) {

    ConnectableObservable<Integer> threeRandoms = Observable
        .range(1, 3)
        .map(s -> ThreadLocalRandom.current().nextInt(100000))
        .publish();

    threeRandoms.subscribe(s -> System.out.println("Observer One :" + s));

    threeRandoms
        .reduce(0, (total,next) -> total+next)
        .subscribe(s -> System.out.println("Observer Two :" + s));

    threeRandoms.connect();

  }

}
