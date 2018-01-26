package co.paulozan.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Launcher_Observer_Subscre_Lambda {

  public static void main(String[] args) {

    Observable<String> source = Observable.just("Alpha", "Beta", "Gama", "Delta", "Epsilon");

    Observer<Integer> myObserver = new Observer<Integer>(){

      @Override
      public void onSubscribe(Disposable d) {
      }

      @Override
      public void onNext(Integer value) {
        System.out.println(value);
      }

      @Override
      public void onError(Throwable e) {
        e.printStackTrace();
      }

      @Override
      public void onComplete() {
        System.out.println("Done!");
      }
    } ;

    source.map(String::length)
        .filter(i -> i >= 5 )
        .subscribe(
            System.out::println
            , Throwable::printStackTrace
            , () -> System.out.println("Done")
        );

  }

}
