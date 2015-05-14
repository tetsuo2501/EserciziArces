import java.util.function.Predicate;

/**
 * Created by Amministratore on 14/05/2015.
 */



public class Prenotazione implements Predicate<Prenotazione>{
    private String nomeCliente;
    private int inizioPrenotazione;
    private int finePrenotazione;

    public Prenotazione(String nomeCliente, int inzioPrenotazione, int finePrenotazione) {
        this.nomeCliente = nomeCliente;
        this.inizioPrenotazione = inzioPrenotazione;
        this.finePrenotazione = finePrenotazione;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getInizioPrenotazione() {
        return inizioPrenotazione;
    }

    public int getFinePrenotazione() {
        return finePrenotazione;
    }

    public boolean isPrenotato(int inizio, int fine){
        return ((inizio >= inizioPrenotazione && inizio <= finePrenotazione) || (fine >= finePrenotazione && fine <= finePrenotazione) ?true:false );
    }

    public boolean isPrenotato( Prenotazione i){
        return isPrenotato(i.inizioPrenotazione, i.finePrenotazione);
    }

    public boolean test( Prenotazione p){
        if( p.inizioPrenotazione == inizioPrenotazione &&
                p.finePrenotazione == finePrenotazione &&
                p.nomeCliente.equalsIgnoreCase(p.nomeCliente) )
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", inizioPrenotazione=" + inizioPrenotazione +
                ", finePrenotazione=" + finePrenotazione +
                '}';
    }
}
