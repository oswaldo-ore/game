package controller;

import actores.Ball;
import actores.Player;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import utils.Constantes;
import utils.SoundGame;

public class PlayerController extends InputAdapter {
    Player player;
    Ball ball;
    SoundGame sound;

    public PlayerController(Player player, Ball ball, SoundGame sound){
        this.player  = player;
        this.ball = ball;
        this.sound = sound;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (player.isAlive()) {
            player.move(screenX);
        }

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Keys.C:
                if(player.isAlive()){
                    ball.iniciar();
                    sound.playMusic();
                    player.initMoving();
                }
                break;
            case Keys.D:
            case Keys.RIGHT:
                if(player.isMoving() && ball.isMoving() ){
                    if(player.getX()+player.getWidth()+ 25 > Constantes.WIDTH){
                        player.move(Constantes.WIDTH);
                    }else{
                        player.move(player.getX()+player.getWidth()+25);
                    }
                }
                System.out.println("right");
                break;
            case Keys.A:
            case Keys.LEFT:
                if(player.isMoving() && ball.isMoving()){
                    if(player.getX()-25 < 0){
                        player.move(0);
                    }else{
                        player.move(player.getX()-25);
                    }
                }

                System.out.println("left");
                break;
            default:
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }
}
