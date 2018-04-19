package co.paulozan.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Launcher_BackPressure {

    public static void main(String[] args) {
        Observable.range(1, 999_999_999)
                  .map(MyItem::new)
                  .subscribe(myItem -> {
                      sleep(50);
                      System.out.println("Received MyItem " +
                                                 myItem.id);
                  });
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static final class MyItem {
        final int id;
        MyItem(int id) {
            this.id = id;
            System.out.println("Constructing MyItem " + id);
        }
    }

}
