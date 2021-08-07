package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Ball extends ActorAbstract {


    public Ball(String srcImage){
        image = new Texture(Gdx.files.internal(srcImage));
        setSize(image.getWidth()/2, image.getHeight()/2);
        setPosition(0,0);
        rectangle = new Rectangle();
        rectangle.setPosition(getX(),getY());
        rectangle.setSize(getWidth(),getHeight());
    }

    public Rectangle  getcircle(){
        return rectangle;
    }
    float deltax = 3f;
    float deltay = 3f;
    public void chocar(){
        if(getX() + getWidth() > Gdx.graphics.getWidth() || getX()  < 0){
            deltax*=-1;
        }
        if (getY() + getHeight() > Gdx.graphics.getHeight() || getY() < 0) {
            deltay *= -1;
        }
    }

    public void changeDirection(Rectangle pared){
        System.out.println("pared X " + pared.getX()+ " pared y " + pared.getY());
        System.out.println("pared wid" + pared.getWidth()+ " pared hei " + pared.getHeight());
        System.out.println("ball X " + getX()+ " ball y " + getY());
        System.out.println("ball wid" + rectangle.getWidth()+ " ball hei " + rectangle.getHeight());


            if(verificarTopButton(pared)) {
                deltay *= -1;
            }

    }

    public boolean verificarLaterales(Rectangle pared){
        if( getX() + getWidth() < pared.getX() || getX()<= pared.getX()+getWidth()  ){
            return true;
        }else{
            return false;
        }
    }

    private boolean verificarTopButton(Rectangle pared){
        if(getY() + getHeight() >= pared.getY() - deltay || getY() <= pared.getY()+ pared.getHeight() - deltay){
            return true;
        }else{
            return false;
        }
    }
    @Override

    public void act(float delta) {
        actualizarPosition();
        chocar();
        super.act(delta);
    }

    private void actualizarPosition(){
        setX(getX()+deltax);
        setY(getY()+deltay);
        rectangle.setPosition(getX(),getY());
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(image,rectangle.x,rectangle.y,getWidth(),getHeight());
        super.draw(batch, parentAlpha);
    }

    public void dispose(){
        image.dispose();
    }
}
