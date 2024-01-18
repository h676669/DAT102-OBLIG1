package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        Scanner insc = new Scanner(System.in);
        System.out.println("Hva vil du?(skriv tallet til det du vil)" +
                "\n 1: Legg til film" +
                "\n 2: Finn film" +
                "\n 3: Slett film" +
                "\n 4: Søk etter tittel" +
                "\n 5: Søk etter produsent" +
                "\n 6: Antall filmer" +
                "\n 7: Antall sjangere" +
                "\n 8: Stop");

        String inputString = insc.nextLine();
        int input = Integer.parseInt(inputString);
        boolean stop = false;

        leggTilStartFilmer(filmarkiv);
        while(!stop){
            Scanner ibruk = new Scanner(System.in);
            switch (input){
                case 1:
                    filmarkiv.leggTilFilm(laggFilm());
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    stop = true;
                    break;
                default:
                    System.out.println("skriv en lovlig verdi");
                    break;
            }
        }

// legg inn en del forhåndsdefinerte filmer for å teste metodene
// ..
// TODO
    }
    private void leggTilStartFilmer(FilmarkivADT filmarkiv){
        Film nummer1 = new Film();
        Film nummer2 = new Film();
        Film nummer3 = new Film();
        filmarkiv.leggTilFilm(nummer1);
        filmarkiv.leggTilFilm(nummer2);
        filmarkiv.leggTilFilm(nummer3);
    }
    private Film laggFilm(){
        Scanner input = new Scanner(System.in);
        System.out.println("skriv filmnr");
        int filmnr = input.nextInt();

        System.out.println("skriv År");
        int ar = input.nextInt();

        System.out.println("Skriv filmskaper");
        String filmskaper = input.nextLine();

        System.out.println("Skriv tittel");
        String tittel = input.nextLine();

        System.out.println("Skriv filmselskap");
        String filmselskap = input.nextLine();

        return new Film(filmnr,ar,filmskaper,tittel,filmselskap);
    }
}
