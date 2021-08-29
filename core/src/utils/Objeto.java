package utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Objeto extends Actor {
    public Texture image;
    public Rectangle imageRec;
    private Boolean finalizo;

    public Boolean getFinalizo() {
        return finalizo;
    }

    public void setFinalizo(Boolean finalizo) {
        this.finalizo = finalizo;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void dispose(){
        image.dispose();
    }
}
