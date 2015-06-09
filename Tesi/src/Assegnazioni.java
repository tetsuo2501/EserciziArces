import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Amministratore on 19/05/2015.
 */
public class Assegnazioni {
    private ArrayList<Tesi> tesi = new ArrayList<Tesi>();
    private ArrayList<Studente> laureandi = new ArrayList<Studente>();

    Assegnazioni(){

    }
    public void aggiungiTesi(String titolo){
        tesi.add(new Tesi(titolo));
    }

    public void aggiungiStudente(String studente, String titolo) {
        Tesi tesi ;
        try {
            tesi = this.tesi.stream().filter(new Tesi(titolo)).findFirst().get();
        }
        catch (NoSuchElementException e){
            tesi = new Tesi(titolo);
        }

       laureandi.add(new Studente(studente,tesi));
    }

    public void laureato(String nomeStudente){
        try {
            Studente laureato = this.laureandi.stream().filter(new Studente(nomeStudente)).findFirst().get();
            tesi.removeIf(laureato.getTesi());
            laureandi.removeIf(laureato);
        }
        catch (NoSuchElementException e){

        }
    }

    public void liberaTesi(String titoloTesi){
        tesi.removeIf(new Tesi(titoloTesi));
    }

    public int disponibili(){
        return this.tesi.size() -
                (new Long(laureandi.stream().filter( (Studente s)-> s.getTesi() ==null).count())).intValue();
    }
}
