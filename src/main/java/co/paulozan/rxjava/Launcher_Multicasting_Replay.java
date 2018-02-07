package co.paulozan.rxjava;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class Launcher_Multicasting_Replay {

  public static void main(String[] args) {

    System.out.println("Example 1");
    Observable<Long> seconds =
        Observable.interval(1, TimeUnit.SECONDS)
            .replay()
            .autoConnect();

    seconds.subscribe(l -> System.out.println("Observer 1: " + l));
    sleep(3000);

    seconds.subscribe(l -> System.out.println("Observer 2: " + l));
    sleep(3000);

    System.out.println("Example 2");

    Observable<String> source2 =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .replay(1)
            .autoConnect();

    source2.subscribe(l -> System.out.println("Observer 1: " +        l));
    source2.subscribe(l -> System.out.println("Observer 2: " +        l));

    System.out.println("Example 3");

    Observable<String> source3 =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .replay(1)
            .refCount();

    source3.subscribe(l -> System.out.println("Observer 1: " +        l));
    source3.subscribe(l -> System.out.println("Observer 2: " +        l));

  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
