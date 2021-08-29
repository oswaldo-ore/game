package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import resource.SingletonLoadResouce;
import utils.Constantes;
import utils.Objeto;

public class Explosion extends Objeto {
    private Animation animation;
    private float time;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;



    public Explosion(float x,float y){
        SingletonLoadResouce resource= SingletonLoadResouce.getSingletonLoadResouce();
        imagen = resource.getAssetManager().get("game/sprite_explosion.png");
        TextureRegion[][] tmp = TextureRegion.split(imagen, imagen.getWidth()/5, imagen.getHeight()/5);
        regionMovimiento = new TextureRegion[25];
        int k=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                regionMovimiento[k] = tmp[i][j];
                k+=1;
            }
        }
        animation = new Animation(1/20f,regionMovimiento);
        time=0f;
        setPosition(x-Constantes.LADRILLO_WIDTH/2,y-Constantes.LADRILLO_HEIGHT/2);
        setFinalizo(false);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time+= Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(time,false);
        if(animation.isAnimationFinished(time)){
            setFinalizo(true);
        }
        batch.draw(frameActual,getX(),getY(), Constantes.LADRILLO_WIDTH * 2,Constantes.LADRILLO_HEIGHT*2);
        super.draw(batch, parentAlpha);
    }

    public void dispose(){
        imagen.dispose();
    }
}
