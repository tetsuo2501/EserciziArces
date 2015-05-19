import java.util.function.Predicate;

/**
 * Created by Amministratore on 19/05/2015.
 */
public class Studente implements Predicate<Studente>{

    private String studente;
    private Tesi tesi;

    Studente(String studente, Tesi tesi){
        this.studente = studente;
        this.tesi = tesi;
    }
    Studente(String studente){
        this(studente, null);
    }

    public String getStudente() {
        return studente;
    }

    public Tesi getTesi() {
        return tesi;
    }

    public void setTesi(Tesi tesi) {
        this.tesi = tesi;
    }

    @Override
    public boolean test(Studente s) {
        return studente.equalsIgnoreCase(s.studente);
    }
}
