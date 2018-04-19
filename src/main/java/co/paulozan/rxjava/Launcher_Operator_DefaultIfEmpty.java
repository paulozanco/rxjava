package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_DefaultIfEmpty {

    public static void main(String[] args) {

        Observable<String> items =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        items.filter(s -> s.startsWith("A"))
             .defaultIfEmpty("None")
             .subscribe(System.out::println);

    }
}
