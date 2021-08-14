package controller;

import actores.Ball;
import actores.Explosion;
import actores.Ladrillo;
import actores.Ladrillos;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import utils.Objeto;
import utils.SingletonSound;

public class BallLadrillosController {
    Ball ball;
    Ladrillos paredes;
    SingletonSound sound = new SingletonSound();

    public BallLadrillosController(Ball ball){
        this.ball = ball;
        paredes = new Ladrillos();
    }

    public void update(SpriteBatch batch, float delta){
        checkColiciones(delta);
        paredes.draw(batch);
    }

    private void checkColiciones(float delta) {
        for (int i = 0; i < paredes.ladrillos.size; i++) {
            if(paredes.getLadrillos(i).imageRec != null ){
                if(Intersector.intersectRectangles(ball.imageRec,paredes.getLadrillos(i).imageRec,new Rectangle())){
                    sound.soundExplotion();
                    ball.changeTopButton();
                    Objeto ladrillo = paredes.getLadrillos(i);
                    Explosion explosion = new Explosion(ladrillo.getX(),ladrillo.getY());
                    paredes.deleteLadrillo(i);
                    paredes.insertarSprite(i,explosion);
                    i = paredes.ladrillos.size + 1;
                }
            }
        }
    }

    public void dispose(){
        paredes.dispose();
    }




}
