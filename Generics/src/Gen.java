/**
 * Created by Amministratore on 28/04/2015.
 */
public class Gen<T> {
    T obj;

    Gen(T o){
        obj = o;
    }

    public T getObj() {
        return obj;
    }

    public String toString(){
        return obj.getClass().getName();
    }
}
