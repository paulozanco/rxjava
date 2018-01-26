package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Just {

  public static void main(String[] args) {
    Observable<String> source = Observable
        .just("Alpha", "Beta", "Gama", "Delta", "Epsilon");

    source.map(String::length)
        .filter(s -> s >= 5)
        .subscribe(System.out::println);

  }

}
