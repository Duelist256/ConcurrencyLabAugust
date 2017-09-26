package day170823;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    static class Counter {
        int count;
        Semaphore sem = new Semaphore(1);

        public void inc() {
            sem.acquireUninterruptibly(); // 0 permits
            try {
                count++;
            } finally {
                sem.release(); // 1 permit
            }
        }

        public int get() {
            sem.acquireUninterruptibly(); // 0 permits
            try {
                return count;
            } finally {
                sem.release();
            }
        }
    }


    public static void main(String[] args) {

    }

}
