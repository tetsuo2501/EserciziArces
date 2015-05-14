/**
 * Created by Amministratore on 14/05/2015.
 */

import java.util.*;


public class Campo {

    private ArrayList<Prenotazione>  prenotazioni = new ArrayList<Prenotazione>();

    /**controlla se i dati inseriti sono giusti e se il campo è disponibile
     * dopodichè salva la prenotazione e restituisce true se il campo è stato prenotato*/
    public boolean addPren(int inizio, int fine,String nomeCliente){
        if(isPrenotato(inizio,fine))
            return false;
        return prenotazioni.add(new Prenotazione(nomeCliente, inizio, fine));
    }

    public boolean addPren( Prenotazione p){
        if(isPrenotato(p))
            return false;
        return prenotazioni.add(p);
    }

    /**controlla se il campo è stato prenotato dal cliente che vuole cancellare la prenotazione
     *  dopodichè la cancella e restituisce true se la prenotazione è stata cancellata*/
    public boolean removePren (int inizio, int fine, String unNomeCliente){
        return prenotazioni.removeIf(new Prenotazione(unNomeCliente, inizio, fine));
    }

    public String toString(){
        String res = "";
        for( Prenotazione i: prenotazioni){
            res += i;
        }
        return res;
    }

    /** per trovare la percentuale dell'utilizzo del campo. */
    public double utilizzo(){
        int res=0;
        for( Prenotazione i: prenotazioni){
            res += i.getFinePrenotazione() - i.getInizioPrenotazione();
        }
        return 100 / 24 * res;
    }

    private boolean isPrenotato(int oraInizio, int oraFine){
        for( Prenotazione i: prenotazioni){
            if( i.isPrenotato(oraInizio, oraFine))
                return true;
        }
        return false;
    }

    private boolean isPrenotato( Prenotazione p){
        return isPrenotato(p.getInizioPrenotazione(),p.getFinePrenotazione());
    }

    public static void main( String arg[]){
        Campo campo = new Campo();
        Prenotazione prenotazione[] = {
                new Prenotazione("Rossi", 10, 12),
                new Prenotazione("Bianchi", 11, 13),
                new Prenotazione("Caio", 16,17),
                new Prenotazione("Sempronio", 20, 22)
        };

        for( Prenotazione i: prenotazione){
            if(campo.addPren(i))
                System.out.println("Prenotazione riuscita: " + i);
            else System.out.println("Pren NON RIUSCITA: +i");
        }
    }
}
