package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv implements FilmarkivADT {
    private Film[] filmarkiv;
    private int storrelseFilm;


    public Filmarkiv(int antall){
        filmarkiv = new Film[antall];
        storrelseFilm = 0;
    }
    @Override
    public Film finnFilm(int nr) {
        if(filmarkiv[nr] != null){
            return filmarkiv[nr];
        }
        else {
            return null;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if(filmarkiv[filmnr] != null){
            filmarkiv[filmnr] = null;
            storrelseFilm--;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for(int i = 0; i < medDelStreng.length; i++){
            if(filmarkiv[i].getTittel().contains(delstreng)){
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }

        return medDelStreng;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for(int i = 0; i < medDelStreng.length; i++){
            if(filmarkiv[i].getFilmskaper().contains(delstreng)){
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }
        return medDelStreng;
    }

    @Override
    public int antall() {
        return storrelseFilm;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int nyLengde = 0;
        Film[] medDelStreng = new Film[storrelseFilm];
        for(int i = 0; i < medDelStreng.length; i++){
            if(filmarkiv[i].getSjanger() == sjanger){
                medDelStreng[nyLengde] = filmarkiv[i];
                nyLengde++;
            }
        }
        return medDelStreng.length;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(storrelseFilm != filmarkiv.length){
            filmarkiv[storrelseFilm] = nyFilm;
            storrelseFilm++;
        }
        else{
            filmarkiv = kopier(filmarkiv);
        }
    }
    private Film[] kopier(Film[] Filmarkiv){
        Film[] kopi = new Film[Filmarkiv.length*2];
        for(int i = 0; i < Filmarkiv.length;i++){
            kopi[i] = Filmarkiv[i];
        }
        return kopi;
    }
}
