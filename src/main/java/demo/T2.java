package demo;

import java.util.ArrayList;
import java.util.List;

public class T2 {
    volatile List list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                if (t2.getSize() != 5) {
                    try {
                        lock.wait();
                        System.out.println("t2 结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 9; i++) {
                    t2.add(i);
                    System.out.println("add " + i);
                    if (t2.getSize() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
