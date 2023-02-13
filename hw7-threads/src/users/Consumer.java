package users;

import sharedvartiables.SharedBuffer;

import java.util.LinkedList;

public class Consumer<T extends Integer> extends User<T> implements Runnable{

    public Consumer(SharedBuffer<T> buffer) {
        super(buffer);
    }

    public void consume() throws InterruptedException{
        getLock().lock();
        try {
            while (getBuffer().isEmpty()) {
                getBufferNotEmpty().await();
            }
            T value = getBuffer().removeFirst();
            System.out.println("Consumer consumed " + value);
            getBufferNotFull().signalAll();
        } finally {
            getLock().unlock();
        }
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; ++i) {
            try {
                consume();
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
