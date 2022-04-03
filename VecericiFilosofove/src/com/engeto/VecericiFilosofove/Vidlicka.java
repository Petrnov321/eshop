package com.engeto.VecericiFilosofove;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vidlicka {

    private int id;
    private Lock lock;

    public Vidlicka(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean zvednutaVidlicka(Filozof filozof) throws InterruptedException{
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(filozof + " zvedl " + this);
            return true;
        }
        else {    return false;      }
    }

    public void polozenaVidlicka(Filozof filozof){
        lock.unlock();
        System.out.println(filozof + " odložil " + this);
    }

    @Override
    public String toString() {
        return "Vidlicka " + id;
    }
}
