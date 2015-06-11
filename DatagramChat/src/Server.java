import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Amministratore on 09/06/2015.
 */
public class Server extends Thread  {
    public static final int SERVER_PORT = 80;
    public static final int BUFFER_SIZE = 1024;
    DatagramSocket socket;
    DatagramPacket receive;
    private byte[] buffer = new byte[1024];
    private DatagramChat listener;

    public Server(DatagramChat l) {
        listener = l;
        receive = new DatagramPacket(buffer,BUFFER_SIZE);
        try {
            socket = new DatagramSocket(SERVER_PORT);
        }
        catch (SocketException e){

        }
    }

    @Override
    public void run()  {
        System.out.println("Thread running!");
        while(true){
            try {
                socket.receive(receive);
                listener.addMessageReceivedListener(

                        new MessageReceivedEvent(
                                new Messaggio(
                                        receive.getAddress(),
                                        new String(buffer,"UTF-8").substring(0,receive.getLength()) )
                        ));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
