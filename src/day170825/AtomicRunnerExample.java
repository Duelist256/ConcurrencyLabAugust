package day170825;

import day170821.Utils;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicRunnerExample {
    public static void main(String[] args) {
        System.out.println("start");

        AtomicRunner runner = new AtomicRunner();

        new Thread(runner).start();
        new Thread(runner).start();
        Utils.pause(5000);
        runner.stop();

        System.out.println("finish");
    }
}

class AtomicRunner implements Runnable {
    volatile boolean stop = false;

    AtomicLong count = new AtomicLong(0);

    @Override
    public void run() {
        while (!isStop()) {
            count.incrementAndGet();
        }
        System.out.println("stopped at " + count);
    }

    //    synchronized
    public void stop() {
        stop = true;
    }

    //    synchronized
    public boolean isStop() {
        return stop;
    }
}
