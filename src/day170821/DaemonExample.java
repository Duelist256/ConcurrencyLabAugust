package day170821;

public class DaemonExample {
    public static void main(String[] args) {

        System.out.println("start");

        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hi");
                Utils.pause(1000);
            }
        });

        t.setDaemon(true);

        t.start();

        new Thread(() -> {
            Utils.pause(10000);
        }).start();

        Utils.pause(5000);

        System.out.println("finish");
    }
}
