package demo;

import java.time.LocalTime;
import java.util.Date;

public class SchedService1 implements Runnable {
    @Override
    public void run() {
        System.out.println("每3s执行一次：" + Thread.currentThread().getName() + " " + LocalTime.now());

    }
}
