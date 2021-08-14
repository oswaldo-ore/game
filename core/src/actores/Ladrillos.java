package actores;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import utils.Constantes;
import utils.Objeto;


public class Ladrillos {
    public Array<Objeto> ladrillos = new Array<>();
    public Ladrillos(){
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

    public void addLadrillo(float x,float y){
        ladrillos.add(new Ladrillo("game/ladrillo-red.png",x,y));
    }

    public Objeto getLadrillos(int index){
        return (Objeto) ladrillos.get(index);
    }

    public void deleteLadrillo(int index){
        ladrillos.removeIndex(index);
    }

    public void insertarSprite(int index,Objeto explosion){
        ladrillos.insert(index,explosion);
    }

    public void draw(SpriteBatch batch){
        for (int i = 0 ;i < ladrillos.size;i++){
            ladrillos.get(i).draw(batch,2);
        }
    }

    public void dispose(){
        for (int i= 0;i<ladrillos.size;i++){
            ladrillos.get(i).dispose();
        }
    }
}
