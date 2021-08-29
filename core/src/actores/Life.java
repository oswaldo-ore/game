package actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import resource.SingletonLoadResouce;
import utils.Constantes;
import utils.Objeto;

public class Life extends Objeto {
    private Boolean efecto;
    private float caida = 3f;

    SingletonLoadResouce resouce =SingletonLoadResouce.getSingletonLoadResouce();
    public Life(float x,float y){
        image = resouce.getAssetManager().get("game/life.png");
        setBounds(x,y,image.getWidth(),image.getHeight());
        imageRec = new Rectangle();
        imageRec.setPosition(x,y);
        imageRec.setSize(image.getWidth(),image.getHeight());
        efecto = false;
    }
    public Life(float x,float y,Boolean efecto){
        image = resouce.getAssetManager().get("game/life.png");
        setBounds(x,y,Constantes.LIFE_WIDTH,Constantes.LIFE_HEIGHT);
        imageRec = new Rectangle();
        imageRec.setPosition(x,y);
        imageRec.setSize(Constantes.LIFE_WIDTH,Constantes.LIFE_HEIGHT);
        this.efecto = efecto;
        setFinalizo(false);
    }

    @Override
    public void act(float delta) {
        if(efecto){
            setY(getY()+caida);
            imageRec.setY(getY());
        }
        if(getY() < -10){
            efecto=false;
            setFinalizo(true);
        }
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,getX(),getY(), Constantes.LIFE_WIDTH, Constantes.LIFE_HEIGHT);
        super.draw(batch, parentAlpha);
    }
}
