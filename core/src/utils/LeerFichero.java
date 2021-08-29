package utils;

import actores.Ladrillo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFichero {
    public static ArrayList<String> muestraContenido(int nivel) {
        String src = Constantes.SRC_NIVEL + nivel + ".txt";
        ArrayList<String> ladrillos_nivel_string =  new ArrayList<>();
        FileHandle archivo = Gdx.files.internal(src);
        String[] br = archivo.readString().split("\r\n");
        for (int i = 0; i < br.length; i++) {
            ladrillos_nivel_string.add(br[i]);
        }
        return ladrillos_nivel_string;
    }

}
