package no.hvl.data102.filmarkiv.impl;

public class Film {

    private int filmnr, ar;
    private String filmskaper, tittel, filmselskap;

    private Sjanger sjanger;


    public Film() {

    }

    public Film(int filmnr, int ar, String filmskaper, String tittel, String filmselskap) {
        this.filmnr = filmnr;
        this.år = ar;
        this.filmskaper = filmskaper;
        this.tittel = tittel;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getTittel(String tittel) {
        return tittel;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    @Override
    public boolean equals(Film film1, Film film2) {
        return film1.getAr() == film2.getAr();
    }

    @Override
    public boolean hashCode(Film film1, Film film2) {
        return film1.hashCode() == film2.hashCode();
    }
}
