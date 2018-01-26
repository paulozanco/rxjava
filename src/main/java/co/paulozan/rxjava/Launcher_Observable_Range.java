package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Range {

  public static void main(String[] args) {

    Observable
        .range(5,10)
        .subscribe(System.out::println);

  }

}
