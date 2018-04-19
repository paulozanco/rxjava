package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Observable_Windowing {

    public static void main(String[] args) {

        Observable.range(1, 50)
                  .window(8)
                  .flatMapSingle(
                          obs -> obs.reduce("",
                                            (total, next) -> total + (total.equals("") ? "" : "|") + next
                          )
                  )
                  .subscribe(System.out::println);

    }

}
