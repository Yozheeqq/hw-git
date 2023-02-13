package users;

import sharedvartiables.SharedBuffer;

public class Consumer<T extends Integer> extends User<T> implements Runnable{

    public Consumer(SharedBuffer<T> buffer) {
        super(buffer);
    }

    public void consume() throws InterruptedException{
        buffer.getLock().lock();
        try {
            while (buffer.getBuffer().isEmpty()) {
                buffer.getBufferNotEmpty().await();
            }
            T value = buffer.getBuffer().removeFirst();
            System.out.println("Consumer consumed " + value);
            buffer.getBufferNotFull().signalAll();

        } finally {
            buffer.getLock().unlock();
        }
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; ++i) {
            try {
                consume();
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
