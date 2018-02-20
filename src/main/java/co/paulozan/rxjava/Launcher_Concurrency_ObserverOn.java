package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Launcher_Concurrency_ObserverOn {

  public static void main(String[] args) {

    Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
        .subscribeOn(Schedulers.io())
        .flatMap(s -> Observable.fromArray(s.split("/")))
        .observeOn(Schedulers.computation())
        .filter(s -> s.matches("[0-9]+"))
        .map(Integer::valueOf)
        .reduce((total, next) -> total + next)
        .subscribe(i -> System.out.println("Received " + i
            + " on thread "
            + Thread.currentThread().getName()));

    sleep(1000);

  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
