import java.util.function.Predicate;

/**
 * Created by Amministratore on 19/05/2015.
 */
public class Tesi implements Predicate<Tesi>{
    private String titolo;

    Tesi(String titolo){
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public boolean test(Tesi s) {
        return titolo.equalsIgnoreCase(s.titolo);
    }
}
