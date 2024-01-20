package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {

    private LinearNode<Film> first;
    private int antall;

    public Filmarkiv2() {
        first = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int filmnr) {
        LinearNode<Film> currentNode = first;

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

        if (first.getData() == null) {
            first = node;
        } else {
            LinearNode<Film> last = first;
            while (last.getNeste() != null) {
                last = last.neste;
            }
            last.neste = node;
        }
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (first.getData().getFilmnr() == filmnr) {
            first = first.neste;
            return true;
        }

        LinearNode<Film> currentNode = first;

        while (currentNode != null)  {
            if (currentNode.neste.getData().getFilmnr() == filmnr) {
                currentNode.neste = currentNode.getNeste().neste;
                return true;
            }
            currentNode = currentNode.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> currentNode = first;
        Film[] n = new Film[antall];
        int i = 0;
        while (currentNode != null) {
            if (currentNode.getData().getTittel().contains(delstreng)) {
                n[i] = currentNode.getData();
            }
            i++;
            currentNode = currentNode.neste;
        }
     return n;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> currentNode = first;
        Film[] n = new Film[antall];
        int i = 0;
        while (currentNode != null) {
            if (currentNode.getData().getFilmskaper().contains(delstreng)) {
                n[i] = currentNode.getData();
            }
            i++;
            currentNode = currentNode.neste;
        }
        return n;
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> currentNode = first;
        int antall = 0;
        while (currentNode != null) {
            if (currentNode.getData().getSjanger() == sjanger) {
                antall++;
            }
        }
        return antall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
