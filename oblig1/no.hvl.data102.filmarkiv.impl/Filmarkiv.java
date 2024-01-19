package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv implements FilmarkivADT {
    private Film[] filmarkiv;
    private int storrelseFilm;


    public Filmarkiv(int antall) {
        filmarkiv = new Film[antall];
        storrelseFilm = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        Film film = null;
        for(int i = 0; i <storrelseFilm;i++) {
           if(filmarkiv[i] != null){
              if(filmarkiv[i].getFilmnr() == nr){
                  film = filmarkiv[i];
               }
           }
        }
        return film;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean gjort = false;
        for(int i = 0; i <storrelseFilm;i++){
            if(filmarkiv[i].getFilmnr() == filmnr){
                storrelseFilm--;
                filmarkiv[i] = null;
                gjort = true;
            }
        }
        return gjort;
    }

    //Gir nullpointerexception vist delstrengen ikkje finnest
    @Override
    public Film[] soekTittel(String delstreng) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for (int i = 0; i < medDelStreng.length; i++) {
            if (filmarkiv[i].getTittel().contains(delstreng)) {
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }
        return trimTab(medDelStreng,nyLengde);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for (int i = 0; i < medDelStreng.length; i++) {
            if (filmarkiv[i].getFilmskaper().contains(delstreng)) {
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }
        return trimTab(medDelStreng, nyLengde);
    }

    @Override
    public int antall() {
        return storrelseFilm;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for (int i = 0; i < medDelStreng.length; i++) {
            if (filmarkiv[i].getSjanger() == sjanger) {
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }
        return medDelStreng.length;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (storrelseFilm != filmarkiv.length) {
            filmarkiv[storrelseFilm] = nyFilm;
            storrelseFilm++;
        } else {
            filmarkiv = kopier(filmarkiv);
        }
    }

    private Film[] kopier(Film[] Filmarkiv) {
        Film[] kopi = new Film[Filmarkiv.length * 2];
        for (int i = 0; i < Filmarkiv.length; i++) {
            kopi[i] = Filmarkiv[i];
        }
        return trimTab(kopi, storrelseFilm);
    }

    private Film[] trimTab(Film[] tab, int n) {
// n er antall elementer
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }

    public int getStorrelseFilm() {
        return storrelseFilm;
    }

    public void setStorrelseFilm(int storrelseFilm) {
        this.storrelseFilm = storrelseFilm;
    }

    public void skrivUtFilmArkiv() {
        for (int i = 0; i < storrelseFilm; i++) {
            if(filmarkiv[i] != null){
                System.out.println("\n -------------------");
                System.out.print("\n Filmskaper: " + filmarkiv[i].getFilmskaper());
                System.out.print("\n Tittel: " + filmarkiv[i].getTittel());
                System.out.print("\n År: " + filmarkiv[i].getAr());
                System.out.print("\n Filmnummer: " + filmarkiv[i].getFilmnr());
                System.out.print("\n Filmselskap: " + filmarkiv[i].getFilmselskap());
                System.out.print("\n Sjanger: " + filmarkiv[i].getSjanger());
            }
        }
    }

    public void skrivUtFilmListe(Film[] liste) {

        for (int i = 0; i < liste.length; i++) {
            System.out.println("\n -------------------");
            System.out.print("\n Filmskaper: " + liste[i].getFilmskaper());
            System.out.print("\n Tittel: " + liste[i].getTittel());
            System.out.print("\n År: " + liste[i].getAr());
            System.out.print("\n Filmnummer: " + liste[i].getFilmnr());
            System.out.print("\n Filmselskap: " + liste[i].getFilmselskap());
            System.out.print("\n Sjanger: " + liste[i].getSjanger());
        }
    }
}
