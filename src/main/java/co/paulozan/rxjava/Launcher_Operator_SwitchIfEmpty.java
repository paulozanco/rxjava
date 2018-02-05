package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_SwitchIfEmpty {

  public static void main(String[] args) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta","Epsilon")
        .filter(s -> s.startsWith("Z"))
        .switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
        .subscribe(i -> System.out.println("RECEIVED: " + i),
            e -> System.out.println("RECEIVED ERROR: " + e)
        );

  }
}
