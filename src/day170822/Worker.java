package day170822;

import day170821.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class Worker implements Executor {

    private Queue<Runnable> tasks = new LinkedList<>();

    public Worker() {
        new Thread(this::process).start();
    }

    @Override
    public void execute(Runnable task) {
        synchronized (tasks) {
            tasks.offer(task);
            tasks.notify();
            System.out.println("notified");
            Utils.pause(3000);
        }
    }

    private void process() {
        while (true) {
            Runnable task = null;
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = tasks.poll();
            }
            if (task != null) {
                task.run();
            }
        }
    }
}
