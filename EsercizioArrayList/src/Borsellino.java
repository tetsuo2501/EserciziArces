/**
 * Created by Amministratore on 12/05/2015.
 */

import java.util.*;

public class Borsellino {
    public static enum Moneta{
        CENT1 (0.01,"Un centesimo"),
        CENT2 (0.02, "Due centesimi"),
        CENT5 (0.05, "Cinque centesimi"),
        CENT10 (0.1, "Dieci centeimi"),
        CENT20 (0.2, "Venti centesimi"),
        CENT50 (0.5, "Cinquanta Centesimi"),
        EURO1 (1, "Un euro"),
        EURO2 (2, "Due euro");
        private final double valore;
        private final String nome;

        Moneta(double valore, String nome){
            this.valore = valore;
            this.nome = nome;
        }
        public String toString(){
            return nome;
        }
    }

    ArrayList<Moneta> borsellino;
    Borsellino(){
        borsellino = new ArrayList<Moneta>();
    }
    public boolean aggiungiMoneta(Moneta moneta){
        return borsellino.add(moneta);
    }

    public String toString(){
        String res;
        for(Moneta m: borsellino)
            res += m +"\t";
        return res;
    }
}
