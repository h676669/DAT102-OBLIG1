//package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FilmarkivTest {
    @Test
    public void test1() {
        Filmarkiv testFilmer = new Filmarkiv(10);
        Film testfilm1 = new Film(10,2012,"test","test","test");
        Film testfilm2 = new Film(12,2011,"hei","hei","hei");


        testFilmer.leggTilFilm(testfilm1);
        testFilmer.leggTilFilm(testfilm1);
        testFilmer.leggTilFilm(testfilm2);
        testFilmer.leggTilFilm(testfilm2);
        assertEquals(testFilmer.antall(),4);
        System.out.println(testFilmer.toString());
        System.out.println(testFilmer.getStorrelseFilm());

        testFilmer.skrivUtFilmListe(testFilmer.soekTittel("test"));
    }
}
