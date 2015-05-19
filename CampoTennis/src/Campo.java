/**
 * Created by Amministratore on 14/05/2015.
 */

import java.util.*;

import com.googlecode.lanterna.gui.component.TextArea;
import com.googlecode.lanterna.terminal.swing.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.gui.layout.*;
import com.googlecode.lanterna.gui.component.*;

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
        SwingTerminal terminal = new SwingTerminal(new TerminalSize(90,20));

        final Screen screen = new Screen(terminal,80,20);
        GUIScreen gui = new GUIScreen(screen);
        DefaultBackgroundRenderer background = new DefaultBackgroundRenderer();
        gui.setBackgroundRenderer(background);
        final Window window = new Window("");
        TextArea  txtArea = new TextArea();

        Button button = new Button("Chiudi", new Action() {
            @Override
            public void doAction() {
                window.close();
            }
        });

        LayoutParameter layout = new LayoutParameter("layout");
        window.addComponent(txtArea, layout);
        window.addComponent(button,layout);
        screen.startScreen();




        screen.refresh();
        ////////////////////////
        Campo campo = new Campo();
        Prenotazione prenotazione[] = {
                new Prenotazione("Rossi", 10, 12),
                new Prenotazione("Bianchi", 11, 13),
                new Prenotazione("Caio", 16,17),
                new Prenotazione("Sempronio", 20, 22)
        };

        for( Prenotazione i: prenotazione){
            if(campo.addPren(i))
                txtArea.appendLine("Prenotazione riuscita: " + i);
            else txtArea.appendLine("Pren NON RIUSCITA:" + i);
            screen.refresh();
        }

        txtArea.appendLine("Rimuovo prenotazione: " + campo.removePren(16, 17, "Caio"));
        txtArea.appendLine("Utilizzo campo: " + campo.utilizzo() + "%");
        screen.refresh();
        ////////////////////////////
        gui.runInEventThread(new Action() {
            @Override
            public void doAction() {
                screen.refresh();

            }
        });
        gui.showWindow(window);

        screen.stopScreen();

    }
}
