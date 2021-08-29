package controller;

import actores.*;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import utils.Constantes;
import utils.Objeto;
import utils.SoundGame;

public class BallLadrillosController {
    Ball ball;
    Ladrillos paredes;
    Player player;
    SoundGame sound ;

    public BallLadrillosController(Ball ball, Ladrillos ladrillos, Player player, SoundGame sound){
        this.ball = ball;
        this.paredes = ladrillos;
        this.player = player;
        this.sound = sound;

    }


    public void update(float delta){
        interceptar();
        checkColiciones();
    }

    private void checkColiciones() {
        for (int i = 0; i < paredes.wall.size; i++) {
                if(Intersector.intersectRectangles(ball.imageRec,paredes.getLadrillos(i).imageRec,new Rectangle())) {
                    sound.soundExplotion();
                    ball.changeTopButton();
                    Objeto ladrillo = paredes.getLadrillos(i);
                    paredes.deleteLadrillo(i);
                    i = paredes.wall.size + 1;
                }
        }
    }

    public void interceptar(){
        Rectangle aa = new Rectangle();
        if(Intersector.intersectRectangles(ball.imageRec,player.imageRec,aa)){

            if(aa.width <= ball.getWidth()/2 && aa.getHeight() <= 5.0f
                    || aa.getHeight() < ball.getHeight() / 2 && aa.getWidth()<=5
            ){
                ball.extremo();
            }
            if(aa.height<= 7 && aa.width >= ball.getWidth()/ 2 ) {
                ball.changeTopButton();
            }
            if(aa.height >= ball.getHeight() && aa.width <= 7) {
                ball.changeLeftRigth();
            }
        }
        die();
    }

    public void die(){
        if(player.isAlive() && ball.getY() < Constantes.SPACE_BUTTOM){
            sound.stopMusic();
            player.die();
            ball.detener();
            sound.soundDie();
            paredes.cargarDatos();
        }
    }


    public void dispose(){
        paredes.dispose();
    }
}
