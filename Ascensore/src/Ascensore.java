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
