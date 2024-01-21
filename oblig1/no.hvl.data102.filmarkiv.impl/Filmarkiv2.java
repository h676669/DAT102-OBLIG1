package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT {

    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2() {
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int filmnr) {
        LinearNode<Film> currentNode = start;
        while (currentNode != null) {
            if (currentNode.getData().getFilmnr() == filmnr) {
                return currentNode.getData();
            }
            currentNode = currentNode.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> node = new LinearNode<>(nyFilm);

        if (start == null) {
            start = node;
        } else {
            LinearNode<Film> currentNode = start;
            while (currentNode.getNeste() != null) {
                currentNode = currentNode.neste;
            }
            currentNode.neste = node;
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start.getData().getFilmnr() == filmnr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> currentNode = start;
        while (currentNode != null)  {
            if (currentNode.neste.getData().getFilmnr() == filmnr) {
                currentNode.neste = currentNode.getNeste().neste;
                antall--;
                return true;
            }
            currentNode = currentNode.neste;
        }
        return false;
    }

        @Override
        public Film[] soekTittel(String delstreng) {
            LinearNode<Film> currentNode = start;
            ArrayList<Film> a = new ArrayList<>();
            while (currentNode != null) {
                if (currentNode.getData().getTittel().contains(delstreng)) {
                    a.add(currentNode.getData());
                }
                currentNode = currentNode.neste;
            }
            return a.toArray(new Film[0]);
        }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> currentNode = start;
        ArrayList<Film> a = new ArrayList<>();
        while (currentNode != null) {
            if (currentNode.getData().getFilmskaper().contains(delstreng)) {
                a.add(currentNode.getData());
            }
            currentNode = currentNode.neste;
        }
        return a.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> currentNode = start;
        int antall = 0;
        while (currentNode != null) {
            if (currentNode.getData().getSjanger() == sjanger) {
                antall++;
                currentNode = currentNode.neste;
            }
        }
        return antall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
