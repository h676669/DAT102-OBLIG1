package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
    private Film film;
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
        film=new Film();
        Scanner lesInn = new Scanner(System.in);
        System.out.print("Skriv inn filmnummer");
        int filmnr = lesInn.nextInt();
        System.out.print("Skriv inn ar");
        int ar = lesInn.nextInt();
        System.out.print("Skriv inn filmskaper");
        String filmskaper = lesInn.nextLine();
        System.out.print("Skriv inn tittel");
        String setTittel = lesInn.nextLine();
        System.out.print("Skriv inn filmselskap");
        String filmselskap=lesInn.nextLine();
        System.out.print("Skriv inn Sjanger");
        String sjanger=lesInn.nextLine();
        film.setFilmnr(filmnr);
        film.setAr(ar);
        film.setFilmskaper(filmskaper);
        film.setTittel(setTittel);
        film.setFilmselskap(filmselskap);
        film.setSjanger(Sjanger.valueOf(sjanger));
        return film;
    }


    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("År: " + film.getAr());
        System.out.println("Filmskaper: " + film.getFilmskaper());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Filmselskap: " + film.getFilmselskap());
        System.out.println("Sjanger: " + film.getSjanger().toString());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        arkiv.soekTittel(delstreng);
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        arkiv.soekProdusent(delstreng);
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
// TODO
    }
// osv ... andre metoder
}
