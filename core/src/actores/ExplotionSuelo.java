package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import resource.SingletonLoadResouce;
import utils.Constantes;
import utils.Objeto;

public class ExplotionSuelo extends Objeto {
    private Animation animation;
    private float time;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;
    private SingletonLoadResouce resource;



    public ExplotionSuelo(float x,float y){
        resource = SingletonLoadResouce.getSingletonLoadResouce();
        imagen = resource.getAssetManager().get("game/explotionsuelo.png");
        TextureRegion[][] tmp = TextureRegion.split(imagen, imagen.getWidth()/3, imagen.getHeight()/3);
        regionMovimiento = new TextureRegion[9];
        int k=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                regionMovimiento[k] = tmp[i][j];
                k+=1;
            }
        }
        animation = new Animation(1/5f,regionMovimiento);
        time=0f;
        setPosition(x,y);
        setFinalizo(false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time+= Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(time,true);
        batch.draw(frameActual,getX(),getY(), frameActual.getRegionWidth(),frameActual.getRegionHeight());
        super.draw(batch, parentAlpha);
    }

    public void dispose(){
        imagen.dispose();
    }
}
