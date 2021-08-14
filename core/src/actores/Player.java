package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import utils.Constantes;
import utils.Objeto;

public class Player extends Objeto {
    public float SPEEDX = 3;
    public float MoveX = 0;
    public boolean mover = false;

    public Player (String srcImage){

        image = new Texture(Gdx.files.internal(srcImage));
        setBounds(Constantes.CENTER_X - Constantes.PLAYER_WIDTH/2,
                Constantes.SPACE_BUTTOM,Constantes.PLAYER_WIDTH,Constantes.PLAYER_HEIGHT);
        imageRec = new Rectangle();
        imageRec.setPosition(getX(),getY());
        imageRec.setSize(getWidth(),getHeight());
    }

    @Override
    public void act(float delta) {
        mover();
    }

    private void mover(){
        if(mover){
            if(MoveX > getRight() && MoveX < Constantes.WIDTH){
                moverDerecha();
                if(getX()+ getWidth()/2 > MoveX) mover = false;
            }
            if(MoveX < getX() && MoveX > 0){
                moverIzquierda();
                if(getX()<0 || MoveX < 0) mover = false;
            }
        }

    }

    public void moverIzquierda(){

        setX(getX() - SPEEDX );
        imageRec.setX(getX());
    }

    public void moverDerecha(){
        setX(getX() + SPEEDX);
        imageRec.setX(getX());
    }

    public void move(float x){
        mover = true;
        MoveX = x;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,getX(),getY(),getWidth(),getHeight());
        super.draw(batch, parentAlpha);
    }
}
