package actores;

import actores.Life;
import com.badlogic.gdx.graphics.g2d.Batch;
import utils.Constantes;
import utils.Objeto;

import java.util.ArrayList;

public class ListLife extends Objeto {
    ArrayList<Life> life;
    public ListLife(int cantidad){
        life  = new ArrayList<>();
        for (int i = 0; i < cantidad ; i++) {
            life.add(new Life( nextPositionLife(i), Constantes.HEIGHT ));
        }
    }

    public int size(){
        return life.size();
    }

    public float nextPositionLife(int i){
        return Constantes.WIDTH * 0.10f + Constantes.LIFE_WIDTH * i;
    }

    public void addLife(){
        life.add(new Life( nextPositionLife(life.size()), Constantes.HEIGHT ));
    }

    public void deletelife(){
        life.remove(life.size()-1);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = 0; i < life.size(); i++) {
            life.get(i).draw(batch,parentAlpha);
        }
        super.draw(batch, parentAlpha);
    }

    @Override
    public void dispose() {
        for (int i = 0; i<life.size();i++){
            life.get(i).dispose();
        }
        super.dispose();
    }
}
