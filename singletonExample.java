package Singleton;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class singletonExample implements Runnable {
    private static singletonExample instance;
    Lock l = new ReentrantLock();
    static int c = 0;
    private singletonExample(Lock l){
        c = 0;
        this.l = l;
    }

    static singletonExample getInstance(Lock l){
        if( instance == null ){
            synchronized (singletonExample.class){
                if( instance == null ){
                    instance = new singletonExample(l);
                }
            }
        }
        return instance;
    }

    @Override
    public void run() {
        l.lock();
        c++;
        l.unlock();
    }

    public static int getC() {
        return c;
    }

}
