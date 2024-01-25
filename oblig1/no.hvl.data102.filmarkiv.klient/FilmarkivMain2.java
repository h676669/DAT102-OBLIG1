package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;

public class FilmarkivMain2 {
    public static void main(String[] args) {
        FilmarkivADT filma = new Filmarkiv2();
        Meny meny = new Meny(filma);
        meny.start();
    }
}
