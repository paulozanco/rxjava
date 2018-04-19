package co.paulozan.rxjava;

import io.reactivex.Observable;

public class Launcher_Operator_Cast {

    public static void main(String[] args) {

        Observable<Object> items =
                Observable.just("Alpha", "Beta", "Gamma").cast(Object.class);

    }
}
