package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_SkipWhile {

    public static void main(String[] args) {
        Observable.range(1, 100)
                  .skipWhile(i -> i <= 95)
                  .subscribe(i -> System.out.println("RECEIVED: " + i));
    }

}
