package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Defer {

    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {

        Observable<Integer> source = Observable.defer(
                () -> Observable.range(start, count)
        );

        source.subscribe(s -> System.out.println("Observer1 : " + s));

        count = 10;

        source.subscribe(s -> System.out.println("Observer2 : " + s));


    }

}
