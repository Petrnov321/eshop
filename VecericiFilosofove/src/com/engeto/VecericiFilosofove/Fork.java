package com.engeto.VecericiFilosofove;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

    private int id;
    private Lock lock;

    public Fork(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public boolean pickUpFork() throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void downFork() {
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Fork " + id;
    }
}
