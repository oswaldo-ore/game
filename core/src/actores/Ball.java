package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import utils.Constantes;
import utils.Objeto;

public class Ball extends Objeto {
    private float speedX = 5f;
    private float speedY = 5f;
    public Ball(String srcImage){
        image = new Texture(Gdx.files.internal(srcImage));
        setBounds( Constantes.CENTER_X - Constantes.RADIO_BALL / 2,Constantes.SPACE_BUTTOM + Constantes.PLAYER_HEIGHT,
                Constantes.RADIO_BALL,Constantes.RADIO_BALL);
        imageRec = new Rectangle();
        imageRec.setPosition(getX(),getY());
        imageRec.setSize(getWidth(),getHeight());
    }



    public Ball(String srcImage,float x,float y){
        image = new Texture(Gdx.files.internal(srcImage));
        setBounds( x,y,Constantes.RADIO_BALL
                ,Constantes.RADIO_BALL);
        imageRec = new Rectangle();
        setPosition(getX(),getY());
        setSize(getWidth(),getHeight());
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
        setPosition(getX()+speedX,getY()+speedY);
        imageRec.setPosition(getX(),getY());
        rebotePared();
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

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,getX(),getY(),getWidth(),getHeight());
        super.draw(batch, parentAlpha);
    }

}
