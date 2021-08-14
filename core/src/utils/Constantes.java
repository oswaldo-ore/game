package utils;

import com.badlogic.gdx.Gdx;

public abstract class Constantes {
    public static final float SPACE_BUTTOM = Gdx.graphics.getHeight() * 0.01f;
    //center screen buttom and top
    public static final float CENTER_X = Gdx.graphics.getWidth()*0.5f;

    public static final float RADIO_BALL = Gdx.graphics.getWidth()* 32 / Gdx.graphics.getHeight() ;

    public static final float WIDTH = Gdx.graphics.getWidth();
    public static final float HEIGHT = Gdx.graphics.getHeight();

    public static final float LADRILLO_WIDTH = (Gdx.graphics.getWidth() - Constantes.SPACE_LADRILLO * 9) * 0.10f;
    public static final float LADRILLO_HEIGHT = Gdx.graphics.getHeight() * 0.04f ;

    public static final float SPACE_LADRILLO = 2;

    public static final float PLAYER_WIDTH = Gdx.graphics.getWidth() * 0.2f;
    public static final float PLAYER_HEIGHT  =Gdx.graphics.getHeight() * 0.03f;


}
