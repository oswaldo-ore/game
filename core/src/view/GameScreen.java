package view;

import actores.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyGame;
import controller.BallController;
import controller.PlayerController;
import utils.BaseScreen;
import utils.LeerFichero;
import utils.SingletonSound;
import utils.SoundGame;

import java.util.ArrayList;

public class GameScreen extends BaseScreen {
    private SpriteBatch batch;

    private PlayerController playerController;
    private BallController ballController;
    private SoundGame sound ;
    private TopScreen optionTop;

    private Player player;
    private Stage stage;
    private Ball ball;
    private Ladrillos ladrillos;
    private ListLife lifes;
    private ListEfectos efectos;

    ArrayList<String> nivel;
    private int level = 1;

    public ListEfectos getEfectos(){
        return efectos;
    }

    public Stage getStage(){
        return stage;
    }

    public Player player(){
        return player;
    }

    public ListLife lifes(){
        return lifes;
    }

    public ArrayList<String> getNivel (){
        return nivel;
    }
    public void setNivel(ArrayList<String> paredesNivel){
        nivel = paredesNivel;
    }
    public void nextLevel(){
        level+=1;
    }
    public int getLevel(){
        return level;
    }




    public GameScreen(MyGame game) {
        super(game);
        stage =  new Stage();
        sound = SingletonSound.getSingletonSound().getSoundGame();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        stage.clear();
        super.hide();
    }

    @Override
    public void show() {
        nivel = LeerFichero.muestraContenido(level);
        batch = new SpriteBatch();
        player =  new Player("game/player.png");
        ball = new Ball("game/ball-green.png");
        player.iniciar(3);
        ladrillos = new Ladrillos(nivel);
        lifes = new ListLife(player.getLive());
        efectos = new ListEfectos();

        stage.addActor(player);
        stage.addActor(ladrillos);
        stage.addActor(ball);
        stage.addActor(lifes);
        stage.addActor(efectos);

        optionTop = new TopScreen( this);

        playerController =  new PlayerController(player,ball,sound);
        ballController = new BallController(ball,ladrillos,player,sound,this);
        ballController.start();
        Gdx.input.setInputProcessor(playerController);
        sound.playMusic();
        super.show();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameOver();
        batch.begin();
        stage.act();
        stage.draw();
        optionTop.render(delta);
        batch.end();
        super.render(delta);
    }

    private void gameOver() {
        if(!player.isAlive()){
            game.setScreen(game.gameOverScreen);
        }
    }

    @Override
    public void dispose() {
        player.dispose();
        stage.dispose();
        ladrillos.dispose();
        ball.dispose();
        optionTop.dispose();
        ballController.interrupt();
        efectos.dispose();
        super.dispose();
    }
}
