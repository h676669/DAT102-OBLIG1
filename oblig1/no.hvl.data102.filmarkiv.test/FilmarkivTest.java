//package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FilmarkivTest {
    @Test
    public void test1() {
        Filmarkiv testFilmer = new Filmarkiv(10);
        Film testfilm1 = new Film(10,2012,"test","test","test", Sjanger.TEST);
        Film testfilm2 = new Film(12,2011,"hei","hei","hei",Sjanger.TEST);


        testFilmer.leggTilFilm(testfilm1);
        testFilmer.leggTilFilm(testfilm2);
        assertEquals(2,testFilmer.antall());
        testFilmer.slettFilm(12);
        assertEquals(1,testFilmer.antall());
        testFilmer.leggTilFilm(testfilm2);



}
}
