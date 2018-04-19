package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Distinct {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                  .distinct(String::length)
                  .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
