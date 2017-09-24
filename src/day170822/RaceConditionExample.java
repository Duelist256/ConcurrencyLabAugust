package day170822;

import day170821.Utils;

public class RaceConditionExample {
    static int count;
    static Object mutex = new Object();

    static class Counter implements Runnable{

        private static final int MAX = 20;

        @Override
        public void run() {
            for (int i = 0; i < MAX; i++) {
                synchronized (mutex) {
                    Utils.pause(1000);
                    count++;
                    System.out.println(count);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Counter());
        thread1.start();
        Thread thread2 = new Thread(new Counter());
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
