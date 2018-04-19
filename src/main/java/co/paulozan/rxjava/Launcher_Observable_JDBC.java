package co.paulozan.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.davidmoten.rx.jdbc.Database;


public class Launcher_Observable_JDBC {

    public static void main(String[] args) {

        Database db = Database.test();

        Flowable<String> people =
                db.select("select name from person")
                  .getAs(String.class)
                  .subscribeOn(Schedulers.io());

        people.subscribe(System.out::println);
        sleep(20000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
