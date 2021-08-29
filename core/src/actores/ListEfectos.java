package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import utils.Objeto;

import java.util.ArrayList;

public class ListEfectos extends Objeto {
    ArrayList<Objeto> efectos;
    public ListEfectos(){
        efectos = new ArrayList<>();
    }

    public void add(Objeto objeto){
        efectos.add(objeto);
    }

    public void deleteEfecto(int index){
        efectos.remove(index);
    }

    public Boolean isEmpty(){
        return efectos.size()<=0;
    }

    public void clear(){
        efectos.clear();
    }



    public Objeto get(int i){
        return efectos.get(i);
    }

    @Override
    public void act(float delta) {
        for (int i = 0; i < efectos.size(); i++) {
            efectos.get(i).act(delta);
        }
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = 0; i < efectos.size(); i++) {
            if(!efectos.get(i).getFinalizo()){
                efectos.get(i).draw(batch,parentAlpha);
            }else{
                deleteEfecto(i);
            }
        }
        super.draw(batch, parentAlpha);
    }

    public int size(){
        return efectos.size();
    }

    @Override
    public void dispose() {
        for (int i = 0; i < efectos.size(); i++) {
            efectos.get(i).dispose();
        }
        super.dispose();
    }
}
