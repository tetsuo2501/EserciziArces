/**
 * Created by leonardo on 24/04/15.
 */
public class Prenotazione {
    private int numeroPersone;
    private int numeroPiano;

    Prenotazione(int persone, int piano){
        numeroPersone = persone;
        numeroPiano = piano;
    }
    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public void setNumeroPiano(int numeroPiano) {
        this.numeroPiano = numeroPiano;
    }
}
