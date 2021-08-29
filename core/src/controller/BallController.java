package controller;

import actores.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import org.w3c.dom.css.Rect;
import utils.Constantes;
import utils.LeerFichero;
import utils.Objeto;
import utils.SoundGame;
import view.GameScreen;


public class BallController extends Thread {
    Ball ball;
    Ladrillos paredes;
    Player player;
    SoundGame sound ;
    GameScreen gameScreen;
    private int ladrillosQnoMueren;

    public BallController(Ball ball, Ladrillos ladrillos, Player player, SoundGame sound,GameScreen gameScreen){
        this.ball = ball;
        this.paredes = ladrillos;
        this.player = player;
        this.sound = sound;
        this.gameScreen = gameScreen;

    }
    public int i = 0;
    @Override
    public void run() {
        Timer.Task increase = new Timer.Task() {
            @Override
            public void run() {
                try {
                    if(player.isAlive() && ball.isMoving()){
                        interceptar();
                        checkColiciones();
                        termino();
                        interceptarPlayerLife(i);
                        if(i >= gameScreen.getEfectos().size()) i=0;
                    }
                }catch (Exception e){

                }
            }
        };
        Timer increaseTimer = new Timer();
        increaseTimer.scheduleTask(increase,1/1000,Gdx.graphics.getDeltaTime());
    }

    public void termino(){
        if(ladrillosQnoMueren == paredes.getSizeLadrillos()){
            ball.detener();
            player.posInicio();
            ball.speedUp();
            gameScreen.nextLevel();
            gameScreen.setNivel(LeerFichero.muestraContenido(gameScreen.getLevel()));
            if(gameScreen.getNivel() == null) player.setAlive(false);
            paredes.cargarDatosLista(gameScreen.getNivel());
            this.ladrillosQnoMueren = paredes.getLadrillosNoMueren();
        }
    }


    public void interceptarPlayerLife(int index){
        if(!gameScreen.getEfectos().isEmpty()){
                if(player.imageRec.overlaps(gameScreen.getEfectos().get(index).imageRec)){
                    gameScreen.getEfectos().deleteEfecto(i);
                    player.gainLife();
                    gameScreen.lifes().addLife();
                }
        }
        i++;
    }

    public void interceptar(){
        Rectangle a = new Rectangle();
        if(Intersector.intersectRectangles(player.imageRec,ball.imageRec,a)){
            ball.changeTopButton();
            ball.setY(ball.getY()+a.height);
        }
        die();
    }
    private void checkColiciones() {
        for (int i = 0; i < paredes.wall.size; i++) {
                if(Intersector.intersectRectangles(ball.imageRec,paredes.getLadrillos(i).imageRec,new Rectangle())) {
                    Ladrillo ladrillo = paredes.getLadrillos(i);
                    addAnimacion(ladrillo.getTipo(), ladrillo.getX(), ladrillo.getY(), i);
                    ball.changeTopButton();
                    i = paredes.wall.size + 1;
                }
        }
    }

    public void addAnimacion(int tipo,float x,float y, int posDelete){
        switch (tipo){
            case Constantes.LADRILLO_NORMAL:
                sound.soundExplotion();
                gameScreen.getEfectos().add(new Explosion(x,y));
                paredes.deleteLadrillo(posDelete);
                break;
            case Constantes.LADRILLO_LIFE:
                sound.soundExplotion();
                gameScreen.getEfectos().add(new Explosion(x,y));
                gameScreen.getEfectos().add(new Life(x,y,true));
                paredes.deleteLadrillo(posDelete);
                break;
            case Constantes.LADRILLO_METAL:
                sound.playMetal();
                break;
        }
    }


    public void die(){
        if(player.isAlive() && ball.imageRec.getY() < Constantes.SPACE_BUTTOM){
            sound.stopMusic();
            ball.detener();
            player.posInicio();
            player.loseLife();
            if(player.getLive() == 0){
                player.die();
            }
            sound.soundDie();
            paredes.cargarDatosLista(gameScreen.getNivel());
        }
    }
}