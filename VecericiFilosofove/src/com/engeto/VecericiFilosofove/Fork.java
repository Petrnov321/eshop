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

    public boolean pickUpFork(Philosopher philosopher) throws InterruptedException{
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(philosopher + " pick up " + this);
            return true;
        }
        else {    return false;      }
    }

    public void downFork(Philosopher philosopher) {
        lock.unlock();
        System.out.println(philosopher + " down " + this);
    }

    @Override
    public String toString() {
        return "Fork " + id;
    }
}
