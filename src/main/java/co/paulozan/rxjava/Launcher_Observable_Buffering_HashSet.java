package co.paulozan.rxjava;

import io.reactivex.Observable;
import java.util.HashSet;

public class Launcher_Observable_Buffering_HashSet {

  public static void main(String[] args) {

    Observable.range(1, 50)
        .buffer(8, HashSet::new)
        .subscribe(System.out::println);

  }

}
