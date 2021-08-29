package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import resource.SingletonLoadResouce;
import utils.Constantes;
import utils.Objeto;

public class Ball extends Objeto {
    private float speedX;
    private float speedY;
    private boolean moving = false;

    public Ball(String srcImage){
        SingletonLoadResouce resouce = SingletonLoadResouce.getSingletonLoadResouce();
        image = resouce.getAssetManager().get(srcImage);
        posInicio();
        restartSpeed();
        imageRec = new Rectangle();
        imageRec.setPosition(getX(),getY());
        imageRec.setSize(getWidth(),getHeight());
    }

    private void restartSpeed(){
        speedX = 2.5f;
        speedY = 2.5f;
    }

    public void speedUp(){
        speedX+= 0.5f;
        speedY+= 0.5f;
    }


    public Ball(String srcImage,float x,float y){
        image = new Texture(Gdx.files.internal(srcImage));
        setBounds( x,y,Constantes.RADIO_BALL
                ,Constantes.RADIO_BALL);
        imageRec = new Rectangle();
        setPosition(getX(),getY());
        setSize(getWidth(),getHeight());
    }

    private void posInicio(){
        setBounds( Constantes.CENTER_X - Constantes.RADIO_BALL / 2,Constantes.SPACE_BUTTOM + Constantes.PLAYER_HEIGHT,
                Constantes.RADIO_BALL,Constantes.RADIO_BALL);
    }

    public void iniciar(){
        moving = true;
    }
    public void detener(){
        moving = false;
        restartSpeed();
        posInicio();
    }
    public void changeTopButton(){
        speedY*=-1;
    }

    public void changeLeftRigth(){
        speedX*=-1;
    }

    public void extremo(){
        speedX*=-1;
        speedY*=-1;
    }

    @Override
    public void act(float delta) {
        if(moving){
            setPosition(getX()+ speedX ,getY()+ speedY);
            imageRec.setPosition(getX(),getY());
            rebotePared();
        }
        super.act(delta);
    }

    private void rebotePared(){
        if(getRight() >= Constantes.WIDTH || getX() <= 0 ){
            speedX*=-1;
        }
        if(getTop() >= Constantes.HEIGHT){
            speedY*=-1;
        }
    }

    public boolean isMoving() {
        return moving;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,getX(),getY(),getWidth(),getHeight());
        super.draw(batch, parentAlpha);
    }

}
