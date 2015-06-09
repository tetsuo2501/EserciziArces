import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

/**
 * Created by Amministratore on 09/06/2015.
 */
public class DatagramChat {
    public static final int CLIENT_PORT = 999;
    private JPanel panel1;
    private JTextField textField1;
    private JTextArea textArea;
    private InetAddress indirizzoServer;
    private DatagramSocket socket;


    private void inviaMessaggio(){
        String testo = textField1.getText();
        textArea.append(testo);
        //Memorizza la stringa all'interno del buffer
        send(testo);
    }

    private void send(String testo){
        //Moificare indirizzo server
            DatagramPacket pacchetto = new DatagramPacket(testo.getBytes(), testo.length(), indirizzoServer, Server.SERVER_PORT);
        try {
            socket.send(pacchetto);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addMessageReceivedListener( MessageReceivedEvent el){
        //messaggio ricevuto
        textArea.append(el.returnMessaggio().toString());
    }

    public DatagramChat() {

        String neighbor = javax.swing.JOptionPane.showInputDialog("Inserire indirizzo partecipante");
        try{
            socket = new DatagramSocket(CLIENT_PORT);
            indirizzoServer = Inet4Address.getByName(neighbor);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SocketException e) {
            e.printStackTrace();
        }

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inviaMessaggio();
                textField1.setText("");
            }
        });
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("DatagramChat");
        frame.setContentPane(new DatagramChat().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
