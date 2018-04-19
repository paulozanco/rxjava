package co.paulozan.rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Launcher_Observable_FromIterable {

    public static void main(String[] args) {
        List<String> itens = Arrays.asList("Alpha", "Beta", "Gama", "Delta", "Epsilon");

        Observable<String> source = Observable.fromIterable(itens);

        source.map(String::length)
              .filter(s -> s >= 5)
              .subscribe(System.out::println);

    }

}
