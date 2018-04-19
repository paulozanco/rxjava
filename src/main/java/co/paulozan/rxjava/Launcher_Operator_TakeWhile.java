package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_TakeWhile {

    public static void main(String[] args) {
        Observable.range(1, 100)
                  .takeWhile(i -> i < 5)
                  .subscribe(i -> System.out.println("RECEIVED: " + i));
    }

}
