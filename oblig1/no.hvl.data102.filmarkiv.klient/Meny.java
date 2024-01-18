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
        boolean stop = false;
        leggTilStartFilmer(filmarkiv);

        while(!stop) {
            Scanner insc = new Scanner(System.in);
            System.out.println("Hva vil du?(skriv tallet til det du vil)" +
                    "\n 1: Legg til film" +
                    "\n 2: Slett film" +
                    "\n 3: Søk etter tittel" +
                    "\n 4: Søk etter produsent" +
                    "\n 5: Antall filmer og antall i hver sjanger" +
                    "\n 8: Stop");
            System.out.println("--------------------------------------------------");
            System.out.println(": ");
            String inputString = insc.next();

            int input = Integer.parseInt(inputString);
            Scanner ibruk = new Scanner(System.in);

            switch (input) {
                case 1:
                    //funker
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    break;
                case 2:
                    //funker
                    System.out.println("Skriv inn filmnummeret til filmen du vil slette");
                    System.out.println("Filmnummeret kan finnest med bruk av 7:");
                    int filmnr = ibruk.nextInt();
                    System.out.println(filmarkiv.slettFilm(filmnr));
                    break;
                case 3:
                    //Funker
                    System.out.println("Skriv inn tittelen du vil søke etter");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, ibruk.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;
                case 4:
                    //Funker
                    System.out.println("Hvilken produsent letter du etter? ");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, ibruk.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;
                case 5:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    System.out.println("--------------------------------------------------");
                    break;
                case 6:
                    //funker
                    stop = true;
                    break;
                default:
                    System.out.println("skriv en lovlig verdi");
                    System.out.println("--------------------------------------------------");
                    break;
            }
        }
    }
    private void leggTilStartFilmer(FilmarkivADT filmarkiv){
        Film nummer1 = new Film(10,2012,"test","test","test");
        Film nummer2 = new Film(12,2011,"hei","hei","hei");
        Film nummer3 = new Film(105,5690,"hadde","hadde","hadde");
        filmarkiv.leggTilFilm(nummer1);
        filmarkiv.leggTilFilm(nummer2);
        filmarkiv.leggTilFilm(nummer3);
    }
}
