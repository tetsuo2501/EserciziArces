import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

/**
 * Created by Amministratore on 09/06/2015.
 */
public class BrowserTestuale {
    private JPanel panel1;
    private JTextField input;
    private JButton vaiButton;
    private JTextPane textPane;

    public BrowserTestuale() {

        vaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naviga();
            }
        });

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                naviga();
            }


        });
    }

    private void naviga(){
        try{
            URL url = new URL(input.getText());
            textPane.setPage(url);
        }
        catch (MalformedURLException e){
            System.err.println("Malformed URL Exception");
            textPane.setText("Attenzione URL Malformato");
        }
        catch (IOException e) {
            System.out.println("Errore di IO");
            textPane.setText("Errore di IO");
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BrowserTestuale");
        frame.setContentPane(new BrowserTestuale().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
