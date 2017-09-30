package day170829;

import day170821.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ChatSession {

    static AtomicInteger counter = new AtomicInteger();

    private Socket socket;
    PrintWriter pw;

    private long delayMillis;

    {
        int count = counter.incrementAndGet();

        if (count == 1) {
            delayMillis = 5000;
        }
    }

    public ChatSession(Socket socket) {

        this.socket = socket;
    }

    public void process(Consumer<String> broadcaster) {
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            OutputStream outputStream = socket.getOutputStream();

            pw = new PrintWriter(outputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                broadcaster.accept(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String messsage) {
        Utils.pause(delayMillis);
        pw.println(">> " + messsage);
        pw.flush();
    }
}
