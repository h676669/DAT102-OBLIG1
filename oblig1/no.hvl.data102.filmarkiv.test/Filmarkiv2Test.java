//package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.klient.Tekstgrensesnitt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Filmarkiv2Test {
    private Tekstgrensesnitt testSnitt;
    private Filmarkiv2 testFilmer;
    private Film testfilm1;
    private Film testfilm2;

    @Test
    public void testLeggTilOgSlett() {
        testFilmer = new Filmarkiv2();
        testfilm1 = new Film(10,2012,"test","test","test", Sjanger.TEST);
        testfilm2 = new Film(12,2011,"hei","hei","hei",Sjanger.TEST);
        testFilmer.leggTilFilm(testfilm1);
        testFilmer.leggTilFilm(testfilm2);

        assertEquals(2,testFilmer.antall());
        testFilmer.slettFilm(12);
        assertEquals(1,testFilmer.antall());
    }
    @Test
    public void testFinnFilm(){
        testSnitt = new Tekstgrensesnitt();
        testFilmer = new Filmarkiv2();
        testfilm1 = new Film(10,2012,"test","test","test", Sjanger.TEST);
        testfilm2 = new Film(12,2011,"hei","hei","hei",Sjanger.TEST);
        testFilmer.leggTilFilm(testfilm2);
        testFilmer.leggTilFilm(testfilm1);
        
        assertEquals(testFilmer.finnFilm(10), testfilm1);
        assertEquals(testFilmer.finnFilm(12), testfilm2);

    }
    @Test
    public void testSoek(){
        testFilmer = new Filmarkiv2();
        testfilm1 = new Film(10,2012,"test","test","test", Sjanger.TEST);
        testfilm2 = new Film(12,2011,"hei","hei","hei",Sjanger.TEST);
        testFilmer.leggTilFilm(testfilm2);
        testFilmer.leggTilFilm(testfilm1);

        assertEquals(testFilmer.soekTittel("test").length,1);
        assertEquals(testFilmer.soekProdusent("test").length,1);
    }
}
