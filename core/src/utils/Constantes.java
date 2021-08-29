package utils;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public abstract class Constantes {
    public static final float SPACE_BUTTOM = Gdx.graphics.getHeight() * 0.01f;
    public static final float SPACE_TOP = Gdx.graphics.getHeight() * 0.05f;
    //center screen buttom and top
    public static final float CENTER_X = Gdx.graphics.getWidth()*0.5f;

    public static final float RADIO_BALL = Gdx.graphics.getWidth()* 32 / Gdx.graphics.getHeight() ;


    public static final float WIDTH = Gdx.graphics.getWidth();
    public static final float HEIGHT = Gdx.graphics.getHeight() - Constantes.SPACE_TOP;

    public static final float LADRILLO_WIDTH = (Gdx.graphics.getWidth() - Constantes.SPACE_LADRILLO * 9) * 0.10f;
    public static final float LADRILLO_HEIGHT = Gdx.graphics.getHeight() * 0.04f;

    public static final float SPACE_LADRILLO = 5;

    public static final float PLAYER_WIDTH = Gdx.graphics.getWidth() * 0.2f;
    public static final float PLAYER_HEIGHT  =Gdx.graphics.getHeight() * 0.03f;
    public static final ArrayList<String> nameLadrillo = new ArrayList<String>(){{
        add("game/ladrillo-violet.png");add("game/ladrillo-red.png");add("game/ladrillo-plomo.png");
    }};
    public static final String skin = "neonui/neon-ui.json";
    public static final String SRC_NIVEL = "nivel/";

    public static final float LIFE_HEIGHT = Constantes.SPACE_TOP * 0.7f;
    public static final float LIFE_WIDTH = Constantes.WIDTH * 0.05f;


    //tipos de ladrillos q habran

    public static final int LADRILLO_LIFE = 1; // life
    public static final int LADRILLO_METAL = 2; // metal
    public static final int LADRILLO_NORMAL = 0; // normal
    public static final ArrayList<Integer> TYPO_LADRILLO= new ArrayList<Integer>(){
        {
            add(Constantes.LADRILLO_NORMAL);
            add(Constantes.LADRILLO_LIFE);
            add(Constantes.LADRILLO_METAL);
        }
    };



}
