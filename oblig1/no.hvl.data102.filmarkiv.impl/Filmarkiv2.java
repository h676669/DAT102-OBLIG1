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
            currentNode = currentNode.getNeste();
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> newNode = new LinearNode<>(nyFilm);
        newNode.setNeste(start);
        start = newNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {

        LinearNode<Film> currentNode = start;
        while (currentNode != null)  {
            if ((currentNode.getData().getFilmnr() == filmnr)) {
                currentNode.setData(start.getData());
                start = start.getNeste();
                antall--;
                return true;
            }
            currentNode = currentNode.getNeste();
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
                currentNode = currentNode.getNeste();
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
            currentNode = currentNode.getNeste();
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
                currentNode = currentNode.getNeste();
            }
        }
        return antall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
