package controller;

import actores.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class PlayerController extends InputAdapter {
    Player player;

    public PlayerController(Player player){
        this.player  = player;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX + " y " + screenY);
        player.move(screenX);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
