package view;

import actores.ListLife;
import actores.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import utils.Constantes;



public class TopScreen {
    Label cadNivel ;
    Label cadVida ;
    int vidaAnt;
    int nivel;
    private Skin skin;
    GameScreen game;

    public TopScreen( GameScreen gameScreen){
        game = gameScreen;
        this.vidaAnt = gameScreen.player().getLive();
        skin = new Skin(Gdx.files.internal(Constantes.skin));
        cadVida = new Label("Vida: " , skin);
        cadVida.setPosition(0,Constantes.HEIGHT);
        cadNivel = new Label("Nivel  " + game.getLevel(),skin);
        cadNivel.setPosition(Constantes.WIDTH * 0.8f,Constantes.HEIGHT);
        gameScreen.getStage().addActor(cadVida);
        gameScreen.getStage().addActor(cadNivel);
    }

    public void render(float delta ) {
        cadNivel.setText("nivel " + game.getLevel());
        if(game.lifes().size() > game.player().getLive()){
            game.lifes().deletelife();
            vidaAnt = game.player().getLive();
        }
    }

    public void dispose() {
        skin.dispose();
    }
}

