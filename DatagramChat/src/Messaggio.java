import java.net.InetAddress;

/**
 * Created by Amministratore on 09/06/2015.
 */
public class Messaggio {

    private String messaggio;
    private InetAddress from;

    public String toString() {
        return from + ": " + messaggio;
    }

    Messaggio(InetAddress f,String m){
            messaggio = m;
            from = f;
    }

}
