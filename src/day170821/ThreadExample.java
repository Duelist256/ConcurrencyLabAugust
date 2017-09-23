package day170821;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello, world!");
            }
        };

        t = new Thread(() -> {
            System.out.println("Hello there!");
        });

        t.start();
    }
}
