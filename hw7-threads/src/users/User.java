package users;

import sharedvartiables.SharedBuffer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class User<T extends Integer> {
    private final SharedBuffer<T> buffer;
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public User(SharedBuffer<T> buffer) {
        this.buffer = buffer;
    }

    public LinkedList<T> getBuffer() {
        return buffer.getBuffer();
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getBufferNotFull() {
        return bufferNotFull;
    }

    public Condition getBufferNotEmpty() {
        return bufferNotEmpty;
    }
}
