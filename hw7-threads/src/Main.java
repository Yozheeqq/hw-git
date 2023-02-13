import sharedvartiables.SharedBuffer;
import users.Consumer;
import users.Producer;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        SharedBuffer<Integer> buffer = new SharedBuffer<>();
        Thread producer = new Thread(new Producer<>(buffer, 10));
        Thread consumer = new Thread(new Consumer<>(buffer));
        producer.start();
        consumer.start();
    }
}