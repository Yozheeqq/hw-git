package sharedvartiables;

import java.util.LinkedList;


public class SharedBuffer<T> {
    private volatile LinkedList<T> buffer;


    public SharedBuffer() {
        buffer = new LinkedList<>();
    }

    public LinkedList<T> getBuffer() {
        return buffer;
    }


}
