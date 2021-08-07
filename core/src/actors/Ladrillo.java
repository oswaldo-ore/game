package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ladrillo extends ActorAbstract {

    public Ladrillo(String srcImage, float x, float y){
        this.image = new Texture(Gdx.files.internal(srcImage));
        setSize(image.getWidth(), image.getHeight());
        setPosition(x,y);
        this.rectangle = new Rectangle();
        this.rectangle.setPosition(getX(),getY());
        this.rectangle.setSize(getWidth(),getHeight());
    }

    public void dispose(){
        this.image.dispose();
    }

    public Rectangle getRecLadrillo(){
        return this.rectangle;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(this.image,this.rectangle.x,this.rectangle.y);
        super.draw(batch, parentAlpha);
    }
}
