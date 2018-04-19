package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Take {

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .take(3)
                  .subscribe(s -> System.out.println("RECEIVED: " + s));
    }

}
