package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] Filmarkiv;


    public Filmarkiv(int antall){
        Filmarkiv = new Film[antall];
    }
    @Override
    public Film finnFilm(int nr) {
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
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

    }
}