package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Multicasting_Caching {

  public static void main(String[] args) {

    Observable<Integer> cachedRollingTotals =
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
            .scan(0, (total, next) -> total + next)
            .cache();

    cachedRollingTotals.subscribe(System.out::println);

  }
}
