package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import utils.Constantes;
import utils.Objeto;

public class Ladrillo extends Objeto {

    public Ladrillo(String srcImage,float x,float y){
        image = new Texture(Gdx.files.internal(srcImage));
        setBounds(x,y, Constantes.LADRILLO_WIDTH,Constantes.LADRILLO_HEIGHT);
        imageRec = new Rectangle();
        imageRec.setPosition(getX(),getY());
        imageRec.setSize(getWidth(),getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,getX(),getY(),getWidth(),getHeight());
        super.draw(batch, parentAlpha);
    }

}
