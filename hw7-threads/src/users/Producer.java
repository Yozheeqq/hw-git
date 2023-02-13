package users;

import sharedvartiables.SharedBuffer;

public class Producer<T extends Integer> extends User<T> implements Runnable{
    private final int size;

    public Producer(SharedBuffer<T> buffer, int size) {
        super(buffer);
        this.size = size;
    }

    public void produce(T value) throws InterruptedException {
        getLock().lock();
        try {
            while (getBuffer().size() == size) {
                getBufferNotFull().await();
            }
            System.out.println("Producer produced " + value);
            getBuffer().add(value);
            getBufferNotEmpty().signalAll();
        } finally {
            getLock().unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            try {
                produce((T)(Integer)(i));
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
