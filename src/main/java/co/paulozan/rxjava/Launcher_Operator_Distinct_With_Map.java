package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Distinct_With_Map {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                  .map(String::length)
                  .distinct()
                  .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
