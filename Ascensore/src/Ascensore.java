/**
 * Created by leonardo on 24/04/15.
 */
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

    public int muovi(){
        if(iteratoreRun >= prenotazioneCorrente)
            return 1;
        Prenotazione p = listaPrenotazioni[iteratoreRun++];
        //Aggiorno le variabili di ascensore
        pianoCorrente = p.getNumeroPiano();
        personePresenti -= p.getNumeroPersone();
        return 0;
    }
    public void reset(){
        pianoCorrente = 0;
        personePresenti = 0;
        for(Prenotazione i: listaPrenotazioni)
            i = null;
        iteratoreRun =0;
        prenotazioneCorrente = 0;
    }
    public String toString(){
        return new String("Stato ascensore: "+personePresenti+" persone presenti, "+
                " al piano " + pianoCorrente +", " + (prenotazioneCorrente - iteratoreRun) +" Prenotazioni");

    }

    public static void main( String arg[]){
        Ascensore ascensore = new Ascensore(10, 3, 5);

        Prenotazione prenotazioni[] = {
                new Prenotazione(3,3),
                new Prenotazione(12,4),
                new Prenotazione(5,2)
        };
        for( Prenotazione i: prenotazioni)
            if( ascensore.entra(i) !=0) break;

        System.out.println("--- Inizio Simulazione");
        do{
            System.out.println(ascensore);
        }
        while (ascensore.muovi() == 0);
        System.out.println("--- Fine Simulazione");
    }
}
