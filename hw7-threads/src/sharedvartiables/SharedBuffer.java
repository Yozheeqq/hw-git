package sharedvartiables;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SharedBuffer<T> {
    private final LinkedList<T> buffer;
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public SharedBuffer() {
        buffer = new LinkedList<>();
    }

    public LinkedList<T> getBuffer() {
        return buffer;
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
