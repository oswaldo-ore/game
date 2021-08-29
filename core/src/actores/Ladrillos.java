package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import utils.Constantes;
import utils.Objeto;

import java.util.ArrayList;
import java.util.Random;


public class Ladrillos extends Objeto {
    public Array<Ladrillo> wall = new Array<>();
    private int ladrillosQueNoMueren;

    public Ladrillos(){
        cargarDatos();
    }

    public Ladrillos(ArrayList<String> listaDeLadrillos){
        cargarDatosLista(listaDeLadrillos);
    }

    public void cargarDatosLista(ArrayList<String> listaDeLadrillos) {
        wall.clear();
        ladrillosQueNoMueren=0;
        float top = Constantes.HEIGHT - Constantes.LADRILLO_HEIGHT ;float left = 0;
        System.out.println(listaDeLadrillos.toString());
        for (int i = 0; i < listaDeLadrillos.size(); i++) {
            String cad = listaDeLadrillos.get(i);
            for (int j = 0; j < cad.length(); j++) {
                String subString = cad.substring(j,j+1);
                if(!subString.trim().isEmpty() && subString.charAt(0) != 'v')
                    addLadrillo(left,top,Integer.parseInt(subString));
                left += Constantes.LADRILLO_WIDTH + Constantes.SPACE_LADRILLO;
            }
            top -= Constantes.LADRILLO_HEIGHT + 5;
            left = 0;
        }
    }
    public int getLadrillosNoMueren(){
        return ladrillosQueNoMueren;
    }
    public int getSizeLadrillos(){
        return wall.size;
    }

    public void cargarDatos(){
        wall.clear();
        float top = Constantes.HEIGHT - Constantes.LADRILLO_HEIGHT ;float left = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                addLadrillo(left, top);
                left += Constantes.LADRILLO_WIDTH + Constantes.SPACE_LADRILLO;
            }
            top -= Constantes.LADRILLO_HEIGHT + 5;
            left = 0;
        }
    }
    private void ladrillosQueNoMueren(int tipo){
        if(tipo == Constantes.LADRILLO_METAL){
            ladrillosQueNoMueren+=1;
        }
    }

    public void addLadrillo(float x,float y, int tipo){
        ladrillosQueNoMueren(tipo);
        wall.add(new Ladrillo(Constantes.nameLadrillo.get(tipo),x,y,tipo));
    }




    public void addLadrillo(float x, float y){
        int number = new Random().nextInt(Constantes.TYPO_LADRILLO.size());
        wall.add(new Ladrillo(Constantes.nameLadrillo.get(number),x,y,Constantes.TYPO_LADRILLO.get(number)));
    }

    public Ladrillo getLadrillos(int index){
        return wall.get(index);
    }

    public void deleteLadrillo(int index){
        wall.removeIndex(index);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = 0 ;i < wall.size;i++){
            wall.get(i).draw(batch,parentAlpha);
        }
        super.draw(batch, parentAlpha);
    }

    public void dispose(){
        for (int i= 0;i<wall.size;i++){
            wall.get(i).dispose();
        }
    }
}
