import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class URLDemo extends JDialog {
    private JPanel contentPane;

    private JTextArea textArea;
    private JTextField indirizzoRemoto;
    private JButton ok;


    public URLDemo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                onOK();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        indirizzoRemoto.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK(){
// add your code here

        execute();



    }



    private void execute(){
        try {
            URL hp = new URL(indirizzoRemoto.getText());
            String res = "Protocol:\t" + hp.getProtocol() +
                    "\nPort:\t" + hp.getPort() +
                    "\nHost:\t" + hp.getHost() +
                    "\nFile:\t" + hp.getFile() +
                    "\nExt:\t" + hp.toExternalForm()+"\n";
            textArea.append(res);
        }
        catch( MalformedURLException e ){
            textArea.append("ATTENZIONE URL MALFORMATO\n");
        }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws MalformedURLException{
        URLDemo dialog = new URLDemo();
        dialog.pack();




        dialog.setVisible(true);
        System.exit(0);
    }
}
