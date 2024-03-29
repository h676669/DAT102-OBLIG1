package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

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
                    "\n 6: Finn film med Film nummer"+
                    "\n 8: Stop");
            System.out.println("--------------------------------------------------");
            System.out.println(": ");

            Scanner ibruk = new Scanner(System.in);

            switch (Integer.parseInt(insc.next())) {
                case 1:
                    //Funker
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    pause();
                    break;
                case 2:
                    //Funker
                    System.out.println("Skriv inn filmnummeret til filmen du vil slette");
                    System.out.println("Filmnummeret kan finnest med å søke etter tittel/produsent:");
                    int filmnr = ibruk.nextInt();
                    if (filmarkiv.slettFilm(filmnr)) {
                        System.out.println("Filmen har blitt slettet");
                    } else {
                        System.out.println("Filmen finnes ikke i arkivet");
                    }
                    pause();
                    break;
                case 3:
                    //Funker
                    System.out.println("Skriv inn tittelen du vil søke etter");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, ibruk.nextLine());
                    System.out.println("--------------------------------------------------");
                    pause();
                    break;
                case 4:
                    //Funker
                    System.out.println("Hvilken produsent letter du etter? ");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, ibruk.nextLine());
                    System.out.println("--------------------------------------------------");
                    pause();
                    break;
                case 5:
                    //Funker
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    System.out.println("--------------------------------------------------");
                    pause();
                    break;
                case 6:
                    System.out.println("Skriv inn filmnummeret til fimen du leter etter");
                    tekstgr.skrivUtFilm(filmarkiv.finnFilm(ibruk.nextInt()));
                    System.out.println("--------------------------------------------------");
                    pause();
                    break;
                case 8:
                    //Funker
                    stop = true;
                    break;
                default:
                    System.out.println("skriv en lovlig verdi");
                    System.out.println("--------------------------------------------------");
            }
        }
    }
    private void leggTilStartFilmer(FilmarkivADT filmarkiv){
        filmarkiv.leggTilFilm(new Film(10,2012,"test","test","test", Sjanger.ACTION));
        filmarkiv.leggTilFilm(new Film(12,2011,"hei","hei","hei",Sjanger.SCIFI));
        filmarkiv.leggTilFilm(new Film(105,5690,"hadde","hadde","hadde",Sjanger.HISTORY));
        filmarkiv.leggTilFilm(new Film(106,5690,"hadde","hadde","hadde",Sjanger.HISTORY));
    }

    private void pause() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Trykk ein hvilken som helst tast på hustelefonen for å gå videre");
        scanner.nextLine();
    }
}
