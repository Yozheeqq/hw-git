package users;

import sharedvartiables.SharedBuffer;

public class Producer<T extends Integer> extends User<T> implements Runnable{
    private final int size;

    public Producer(SharedBuffer<T> buffer, int size) {
        super(buffer);
        this.size = size;
    }

    public void produce(T value) throws InterruptedException {
        buffer.getLock().lock();
        try {
            while (buffer.getBuffer().size() == size) {
                buffer.getBufferNotFull().await();
            }
            System.out.println("Producer produced " + value);
            buffer.getBuffer().add(value);
            buffer.getBufferNotEmpty().signalAll();
        } finally {
            buffer.getLock().unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            try {
                produce((T)(Integer)(i));
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
