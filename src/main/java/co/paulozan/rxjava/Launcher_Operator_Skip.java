package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Skip {

  public static void main(String[] args) {
    Observable.range(1, 100)
        .skip(90)
        .subscribe(i -> System.out.println("RECEIVED: " + i));
  }

}
