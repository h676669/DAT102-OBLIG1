package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv implements FilmarkivADT {
    private Film[] Filmarkiv;
    private int storrelseFilm;


    public Filmarkiv(int antall){
        Filmarkiv = new Film[antall];
        storrelseFilm = 0;
    }
    @Override
    public Film finnFilm(int nr) {
        if(Filmarkiv[nr] != null){
            return Filmarkiv[nr];
        }
        else {
            return null;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if(Filmarkiv[filmnr] != null){
            Filmarkiv[filmnr] = null;
            storrelseFilm--;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] medDelStreng = new Film[storrelseFilm];
        for(int i = 0; i < medDelStreng.length; i++){
            if(){

            }
        }

        return medDelStreng;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(storrelseFilm != Filmarkiv.length){
            Filmarkiv[storrelseFilm] = nyFilm;
            storrelseFilm++;
        }
    }
}
