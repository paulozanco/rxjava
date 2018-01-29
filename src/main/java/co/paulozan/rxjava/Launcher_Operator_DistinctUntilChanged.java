package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_DistinctUntilChanged {

  public static void main(String[] args) {
    Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
        .distinct()
        .subscribe(i -> System.out.println("RECEIVED: " + i));

    Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
        "Delta")
        .distinctUntilChanged(String::length)
        .subscribe(i -> System.out.println("RECEIVED: " + i));

  }
}
