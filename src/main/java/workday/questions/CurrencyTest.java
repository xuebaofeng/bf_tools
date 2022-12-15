package workday.questions;

import java.util.concurrent.Semaphore;

/**
 * @author baofeng.xue
 * @since Dec-2022
 */
public class CurrencyTest {

    public static void main(String[] args)
        throws Exception {
        final Foo f = new Foo();

        new Thread(() -> f.third()).start();
        new Thread(() -> f.second()).start();
        new Thread(() -> f.first()).start();
    }
}

class Foo {

    public Semaphore sem1;
    public Semaphore sem2;

    public Foo()
        throws Exception {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        sem1.acquire();
        sem2.acquire();
    }

    public void first() {
        System.out.println("first");
        sem1.release();
    }

    public void second() {
        try {
            sem1.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second");
        sem2.release();
    }

    public void third() {
        try {
            sem2.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("third");
    }
}
