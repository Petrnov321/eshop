package com.engeto.VecericiFilosofove;



public class Filozof extends Thread{

    private int id;
    private int porceJídla = 0;//hodnata kolik porcí jídla filozof spořádal
    private int nasycen;//hodnota kdy bude filozof nasycen
    private volatile boolean jeSyty = false;
    private Vidlicka pravaVidlicka, levaVidlicka;

    public Filozof(int id,int nasycen, Vidlicka pravaVidlicka, Vidlicka levaVidlicka) {
        this.id = id;
        this.nasycen = nasycen;
        porceJídla = 0;
        this.nasycen = nasycen;
        this.levaVidlicka = levaVidlicka;
        this.pravaVidlicka = pravaVidlicka;
    }

    public int getPorceJídla() {
        return porceJídla;
    }


    @Override
    public void run() {
        try {
            while (!jeSyty){
                think();
                if(levaVidlicka.zvednutaVidlicka(this)){
                    if(pravaVidlicka.zvednutaVidlicka(this)){
                        eat();
                        pravaVidlicka.polozenaVidlicka(this);
                    }
                    levaVidlicka.polozenaVidlicka(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eat() throws InterruptedException{

        System.out.println(this + " jí");
        porceJídla++;
        System.out.println("Filozof " + id + " snědl     " + porceJídla + "     porcí jídla");
        if(porceJídla == nasycen){     jeSyty = true;      }
        Thread.sleep(300);
    }

    private void think() throws InterruptedException{
        System.out.println(this + " myslí...");
        Thread.sleep(300);
    }

    public void setJeSyty(boolean jeSyty){
        this.jeSyty = jeSyty;
    }

    @Override
    public String toString() {
        return "Filozof " + id;
    }
}
