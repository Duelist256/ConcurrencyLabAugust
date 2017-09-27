package day170825;

import day170821.Utils;

public class RunnerExample {
    public static void main(String[] args) {
        System.out.println("start");

        Runner runner = new Runner();

        new Thread(runner).start();
        Utils.pause(5000);
        runner.stop();

        System.out.println("finish");
    }
}

class Runner implements Runnable {
    volatile boolean stop = false;

    @Override
    public void run() {
        long count = 0;
        while (!isStop()) {
            count++;
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
