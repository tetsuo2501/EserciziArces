/**
 * Created by leonardo on 24/04/15.
 */

import java.util.*;
import java.util.regex.*;

public class Ascensore {

    private Prenotazione listaPrenotazioni[];
    private int prenotazioneCorrente;
    private int ultimoPiano;
    private int maxPersone;
    private int personePresenti;
    private int iteratoreRun;
    private int pianoCorrente;

    Ascensore(int maxCapacita, int maxPrenotazioni, int maxPiano){
        listaPrenotazioni = new Prenotazione[maxPrenotazioni];
        prenotazioneCorrente = 0;
        ultimoPiano = maxPiano;
        maxPersone = maxCapacita;
        personePresenti = 0;
        iteratoreRun = 0;
        pianoCorrente = 0;
    }

    /**Inserisce la prenotazione all'interno dell'ascensore
     *
     * @param p La prenotazione da inserire
     * @return Ritorna 0 se va tutto bene, 1 se la lista della Prenotazioni &egrave; piena, 2 se il piano inserito non &egrave; valido, 3 il numero di persone &egrave; maggiore di quelle che entrano nell'ascensore
     */
    public int entra( Prenotazione p ){

        if( prenotazioneCorrente >= listaPrenotazioni.length ){
            return 1;
        }
        if( p.getNumeroPiano() > ultimoPiano){
            return 2;
        }
        if( personePresenti + p.getNumeroPersone() > maxPersone){
            return 3;
        }
        //Aggiungo la prenotazione
        listaPrenotazioni[prenotazioneCorrente++] = p;
        personePresenti += p.getNumeroPersone();
        return 0;
    }

    /**
     * Muove l'ascensore
     * @return 0 se tutto ok, 1 se ha finito le prenotazioni
     */
    public int muovi(){
        if(iteratoreRun >= prenotazioneCorrente)
            return 1;
        Prenotazione p = listaPrenotazioni[iteratoreRun++];
        //Aggiorno le variabili di ascensore
        pianoCorrente = p.getNumeroPiano();
        personePresenti -= p.getNumeroPersone();
        return 0;
    }

    /**
     * Azzera le informazioni dell'ascensore
     */
    public void reset(){
        pianoCorrente = 0;
        personePresenti = 0;
        for(Prenotazione i: listaPrenotazioni)
            i = null;
        iteratoreRun =0;
        prenotazioneCorrente = 0;
    }

    /**
     *
     * @return Stringa contenteti le informazioni sullo stato dell'ascensore
     */
    public String toString(){
        return new String("Stato ascensore: "+personePresenti+" persone presenti, "+
                " al piano " + pianoCorrente +", " + (prenotazioneCorrente - iteratoreRun) +" Prenotazioni");

    }

    public static void main( String arg[]) {
        Ascensore ascensore = new Ascensore(10, 4, 5);


        System.out.println("Digita entra <numero persone> <numero piano> per inserire una prenotazione, reset per azzerare lo stato,\n" +
                "muovi per avviare la simulazione, reset per azzerare i parametri, oppure esci per uscire dal programma\n" +
                "Ad esempio: entra 5 7 --->Entrano 5 persone che vanno al settimo piano ");
        while (true){
            try {
                Scanner input = new Scanner(System.in);
                MatchResult result;
                //Effettua il parsing della stringa immessa
                input.findInLine("(entra (\\d+) (\\d+)|muovi|esci|reset)");
                result = input.match();
                //Se la parola inizia con entra..
                if(result.group(1).startsWith("entra")){
                    int persone = Integer.parseInt(result.group(2));
                    int piano = Integer.parseInt(result.group(3));

                    //Inserisce le persone in lista
                    switch (ascensore.entra(new Prenotazione(persone, piano))){
                        case 0:
                            break;
                        case 1:
                            System.out.println("Lista prenotazione piena");
                            break;
                        case 2:
                            System.out.println("Piano non valido");
                            break;
                        case 3:
                            System.out.println("Ascensore pieno, ci sono "+(ascensore.maxPersone-ascensore.personePresenti)+" posti liberi");
                            break;

                    }
                }
                // Se ha scritto muovi chiama il metodo muovi
                else if(result.group(1).equals("muovi")){
                    System.out.println("Inizio Simulazione:");
                    do {
                        System.out.println(ascensore);
                    } while(ascensore.muovi() == 0 );
                    System.out.println("----");
                } else if(result.group(1).equals("reset")) //Se ha scritto reset...
                    ascensore.reset();
                else if( result.group(1).equals("esci")) //Se ha scritto esci...
                    System.exit(0);
                else System.err.println("E' successo qualcosa di imprevisto "+result.group(1));
            }
            //Catch il possibile errore di parsing in caso si scrive qualcosa di scorretto
            catch (IllegalStateException e){
                System.err.println("Attenzione è stato inserito un comando non valido.");
            }

        }




    }
}
