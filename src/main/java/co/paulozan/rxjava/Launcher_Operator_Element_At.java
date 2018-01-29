package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Element_At {

  public static void main(String[] args) {
    Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
        "Delta")
        .elementAt(3)
        .subscribe(i -> System.out.println("RECEIVED: " + i));
  }
}
