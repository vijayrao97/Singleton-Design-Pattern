package Singleton;


import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        singletonExample s1 = singletonExample.getInstance();
//        singletonExample s2 = singletonExample.getInstance();
//        System.out.println(s1+" "+s2);
        Lock l = new ReentrantLock();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=1; i<=50; i++){
            singletonExample s1 = singletonExample.getInstance(l);
            System.out.println(s1);
            Thread t1 = new Thread(s1);
            System.out.println(t1.getName());
            t1.start();
//            Thread.sleep(10);
        }



//        Thread t1 = new Thread(s1);
//        Thread t2 = new Thread(s2);
//        t1.start();
//        t2.start();
        Thread.sleep(100);
        System.out.println(singletonExample.getC());
    }
}
