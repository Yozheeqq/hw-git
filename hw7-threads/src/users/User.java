package users;

import sharedvartiables.SharedBuffer;

public class User<T extends Integer> {
    protected final SharedBuffer<T> buffer;

    public User(SharedBuffer<T> buffer) {
        this.buffer = buffer;
    }

    public SharedBuffer<T> getSharedBuffer() {
        return buffer;
    }
}
