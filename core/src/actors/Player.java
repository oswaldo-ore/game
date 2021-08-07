package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import org.w3c.dom.Text;

public class Player extends ActorAbstract {
    public Player(String srcImage){
        image = new Texture(Gdx.files.internal(srcImage));
        setSize(Gdx.graphics.getWidth()*0.1f,Gdx.graphics.getHeight()*0.05f);
        setPosition(Gdx.graphics.getWidth()/2 - getWidth()/2 ,0);
        rectangle = new Rectangle();
        rectangle.setPosition(getX(),getY());
        rectangle.setSize(getWidth(),getHeight());
    }

    public void dispose(){
        image.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(image,rectangle.x,rectangle.y);
        super.draw(batch, parentAlpha);
    }
}
