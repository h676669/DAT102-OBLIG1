package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt {
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
        Scanner lesInn = new Scanner(System.in);
        System.out.print("Skriv inn filmnummer: ");
        int filmnr = lesInn.nextInt();
        System.out.print("Skriv inn år: ");
        int ar = lesInn.nextInt();
        lesInn.nextLine();
        System.out.print("Skriv inn filmskaper: ");
        String filmskaper = lesInn.nextLine();
        System.out.print("Skriv inn tittel: ");
        String tittel = lesInn.nextLine();
        System.out.print("Skriv inn filmselskap: ");
        String filmselskap=lesInn.nextLine();
        System.out.print("Skriv inn Sjanger: ");
        String sjanger=lesInn.nextLine();
        return new Film(filmnr,ar,tittel,filmselskap,sjanger);
    }


    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("År: " + film.getAr());
        System.out.println("Filmskaper: " + film.getFilmskaper());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Filmselskap: " + film.getFilmselskap());
        //System.out.println("Sjanger: " + film.getSjanger().toString());
        System.out.println("--------------------------------------------------");
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] liste = arkiv.soekTittel(delstreng);
        for(int i = 0; i < liste.length;i++){
            skrivUtFilm(liste[i]);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] liste = arkiv.soekProdusent(delstreng);
        for(int i = 0; i < liste.length;i++){
            skrivUtFilm(liste[i]);
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println(arkiv.antall());
        System.out.println((Sjanger.ACTION));
        System.out.println((Sjanger.DRAMA));
        System.out.println((Sjanger.HISTORY));
        System.out.println((Sjanger.SCIFI));
    }
        // osv ... andre metoder
}
