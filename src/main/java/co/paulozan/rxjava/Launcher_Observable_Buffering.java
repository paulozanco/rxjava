package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Buffering {

    public static void main(String[] args) {

        Observable.range(1, 50)
                  .buffer(8)
                  .subscribe(System.out::println);

    }

}
