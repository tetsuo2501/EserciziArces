import java.util.EventObject;
import java.util.EventListener;

/**
 * Created by Amministratore on 09/06/2015.
 */
public class MessageReceivedEvent extends EventObject {
    Messaggio m;

    MessageReceivedEvent(Messaggio source) {
        super((Object) source);
        m = source;
    }

    @Override
    public String toString() {
        return m.toString();
    }

    public Messaggio returnMessaggio(){
        return m;
    }
}


interface MessageReceivedListener extends EventListener {
    public void messageReceivedOccurred(MessageReceivedEvent evt);
}