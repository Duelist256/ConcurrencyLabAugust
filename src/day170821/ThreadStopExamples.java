package day170821;

public class ThreadStopExamples {
    static X x = new X();

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Task task = new Task();
            while (!Thread.interrupted()) {
                x.change();
            }
            System.out.println("Interrupted!");
        });

        t.start();

        Utils.pause(5000);

        t.interrupt();
    }
}

class X {
    int y;
    int z;

    public void change() {
        y += 100;
        z -= 100;
    }
}