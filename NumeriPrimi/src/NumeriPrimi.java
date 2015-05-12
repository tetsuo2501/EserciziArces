/**
 * Created by Amministratore on 12/05/2015.
 */

import java.util.Scanner;

public class NumeriPrimi {
    private static boolean isPrimo(int numero){
        if( numero < 3)
            return true;
        for(int i = (int) Math.sqrt(numero+1); i > 1; i--){
            if( numero%i == 0)
                return false;

        }
        return true;
    }

    public static void main( String arg[]){
        System.out.println("Inserisci il numero");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 1 ; i < n ; i++){
            if( isPrimo(i) )
                System.out.print(i + "\t");
        }
    }
}
