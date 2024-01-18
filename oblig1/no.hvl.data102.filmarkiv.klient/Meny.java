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
                    "\n 2: Finn film" +
                    "\n 3: Slett film" +
                    "\n 4: Søk etter tittel" +
                    "\n 5: Søk etter produsent" +
                    "\n 6: Antall filmer og antall i hver sjanger" +
                    "\n 7: Søk etter tittel med tillegsinfo"+
                    "\n 8: Stop");
            System.out.println("--------------------------------------------------");
            String inputString = insc.nextLine();
            int input = Integer.parseInt(inputString);
            Scanner ibruk = new Scanner(System.in);

            switch (input) {
                case 1:
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    break;
                case 2:
                    System.out.println("Skriv inn en delstring til filmen du leter etter");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, ibruk.nextLine());
                    break;
                case 3:
                    System.out.println("Skriv inn filmnummeret til filmen du vil slette");
                    System.out.println("Filmnummeret kan finnest med bruk av 7:");
                    filmarkiv.slettFilm(ibruk.nextInt());
                    break;
                case 4:
                    System.out.println("Skriv inn tittelen du vil søke etter");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, ibruk.nextLine());
                    break;
                case 5:
                    System.out.println("Hvilken produsent letter du etter? ");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, ibruk.nextLine());
                    break;
                case 6:
                    tekstgr.skrivUtStatistikk(filmarkiv);
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
    }
    private void leggTilStartFilmer(FilmarkivADT filmarkiv){
        Film nummer1 = new Film();
        Film nummer2 = new Film();
        Film nummer3 = new Film();
        filmarkiv.leggTilFilm(nummer1);
        filmarkiv.leggTilFilm(nummer2);
        filmarkiv.leggTilFilm(nummer3);
    }
}
