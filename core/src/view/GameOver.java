package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MyGame;
import utils.BaseScreen;
import utils.Constantes;

public class GameOver extends BaseScreen {
    Skin skin;
    Stage stage;
    Label gameOver;
    private TextButton menu;

    public GameOver(final MyGame game) {
        super(game);
        stage = new Stage();
        skin = new Skin(Gdx.files.internal(Constantes.skin));

        gameOver = new Label("Game Over",skin);
        gameOver.setFontScale(2);
        gameOver.setPosition(Constantes.WIDTH/3f,Constantes.HEIGHT/1.5f);


        menu = new TextButton("Menu",skin);
        menu.setSize(Constantes.WIDTH*0.2f, Constantes.HEIGHT * 0.1f);
        menu.setPosition(Constantes.WIDTH/2f - menu.getWidth()/2, Constantes.HEIGHT/ 2 );
        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.menuScreen);
            }
        });
        stage.addActor(menu);
        stage.addActor(gameOver);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        super.render(delta);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        super.show();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        super.hide();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        super.dispose();
    }
}
