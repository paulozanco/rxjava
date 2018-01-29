package co.paulozan.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.davidmoten.rx.jdbc.Database;


public class Launcher_Observable_JDBC {

  public static void main(String[] args) {

    Database db = Database.test();

    Flowable<String> people = db.select("select name from person").getAs(String.class);

    people.subscribe(System.out::println);


  }

}
