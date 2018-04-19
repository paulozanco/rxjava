package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Create {

    public static void main(String[] args) {
        Observable<String> source = Observable.create(
                emitter -> {
                    try {
                        emitter.onNext("Alpha");
                        emitter.onNext("Beta");
                        emitter.onNext("Gama");
                        emitter.onNext("Delta");
                        emitter.onNext("Epsilon");
                    } catch (Throwable e) {

                        emitter.onError(e);
                    }
                }
        );

        source.map(String::length)
              .filter(s -> s >= 5)
              .subscribe(System.out::println);

    }

}
