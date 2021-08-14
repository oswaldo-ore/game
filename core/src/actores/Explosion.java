package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import utils.Objeto;

public class Explosion extends Objeto {
    private Animation animation;
    private float time;
    private TextureRegion[] regionMovimiento;
    private Texture imagen;
    private TextureRegion frameActual;
    private float imageWidth,imageHeigth;



    public Explosion(float x,float y){

        imagen = new Texture(Gdx.files.internal("game/sprite_explosion.png"));
        TextureRegion[][] tmp = TextureRegion.split(imagen, imagen.getWidth()/5, imagen.getHeight()/5);
        regionMovimiento = new TextureRegion[25];
        int k=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                regionMovimiento[k] = tmp[i][j];
                k+=1;
            }
        }
        animation = new Animation(1/10f,regionMovimiento);
        time=0f;
        imageWidth = (imagen.getWidth()/5)/2;
        imageHeigth = (imagen.getHeight()/5)/2;
        setPosition(x-imageWidth,y-imageHeigth);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time+= Gdx.graphics.getDeltaTime();
        frameActual = (TextureRegion) animation.getKeyFrame(time,false);
        batch.draw(frameActual,getX(),getY() );
        super.draw(batch, parentAlpha);
    }

    public void dispose(){
        imagen.dispose();
    }
}
