package com.engeto.VecericiFilosofove;

public class Main {

    public static void main(String[] args) {

        int pocetFilozofuAVidlicek = 10;
        int nasycen = 10000;

        Filozof[] filozofove = new Filozof[pocetFilozofuAVidlicek];
        Vidlicka[] vidlicky = new Vidlicka[pocetFilozofuAVidlicek];

        try {
            for (int i = 0; i < pocetFilozofuAVidlicek; i++){
                vidlicky[i] = new Vidlicka(i + 1);
                filozofove[i] = new Filozof(i + 1,nasycen, vidlicky[i], vidlicky[(i + 1) % pocetFilozofuAVidlicek]);
            }
            for (int i = 0; i < pocetFilozofuAVidlicek; i++){
                filozofove[i] = new Filozof(i + 1,nasycen, vidlicky[i], vidlicky[(i + 1) % pocetFilozofuAVidlicek]);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for ( Filozof filozof : filozofove ) {
            filozof.start();
        }
    }
}
