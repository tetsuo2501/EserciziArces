/**
 * Created by Amministratore on 28/04/2015.
 */
public class GenDemo {
    public static void main( String a[]){
        Gen<Integer> g = new Gen<Integer>(10);
        System.out.println(g);
        Gen<String> o = new Gen<String>("Ciao");
        System.out.println(o);
    }
}
