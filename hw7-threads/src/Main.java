import sharedvartiables.SharedBuffer;
import users.Consumer;
import users.Producer;

public class Main {
    public static void main(String[] args){
        SharedBuffer<Integer> buffer = new SharedBuffer<>();
        Thread producer = new Thread(new Producer<>(buffer, 10));
        Thread consumer = new Thread(new Consumer<>(buffer));

        consumer.start();
        producer.start();
    }
}