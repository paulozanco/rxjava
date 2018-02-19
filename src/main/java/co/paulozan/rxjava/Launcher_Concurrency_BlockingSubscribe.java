package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ThreadLocalRandom;

public class Launcher_Concurrency_BlockingSubscribe {

  public static void main(String[] args) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        .subscribeOn(Schedulers.computation())
        .map(s -> intenseCalculation((s)))
        .blockingSubscribe(
            System.out::println
            ,Throwable::printStackTrace
            ,() -> System.out.println("Done")
        );


  }

  public static <T> T intenseCalculation(T value) {
    sleep(ThreadLocalRandom.current().nextInt(3000));
    return value;
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
