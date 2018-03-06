package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Buffering_Skip {

  public static void main(String[] args) {

    Observable.range(1, 10)
        .buffer(2, 3)
        .subscribe(System.out::println);

  }

}
