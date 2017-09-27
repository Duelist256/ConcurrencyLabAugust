package day170822;

import day170821.Utils;

public class UseWorker {
    public static void main(String[] args) {
        Worker worker = new Worker();

        worker.execute(() -> {
            Utils.pause(1000);
            System.out.println("Hello, world!");
        });

        System.out.println("finish");
    }
}
