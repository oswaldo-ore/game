package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {
    public static void muestraContenido(String archivo ) throws IOException {
        String cadena;
        ArrayList<Boolean> lista= new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null){
            System.out.println(cadena);
            for (int i = 0; i < cadena.length();i++ ){
                if(cadena.charAt(i) != ' '){
                    lista.add(true);
                }else{
                    lista.add(false);
                }
            }
        }
        b.close();
    }

}
