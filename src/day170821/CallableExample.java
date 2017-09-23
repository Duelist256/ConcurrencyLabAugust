package day170821;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {

        Callable<String> c = () -> {
            Utils.pause(4000);
            return "hello";
        };

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> future = service.submit(c);
        Future<String> future2 = service.submit(c);
        System.out.println("task sent");

        service.shutdown();

        // do something else

        future2.cancel(false);

        try {
            String result = future.get();
            System.out.println(result);
            String result2 = future2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
