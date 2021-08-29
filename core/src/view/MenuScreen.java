package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MyGame;
import resource.SingletonLoadResouce;
import utils.BaseScreen;
import utils.SingletonSound;

public class MenuScreen extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private TextButton play;
    public MenuScreen(final MyGame game) {
        super(game);
        stage = new Stage(new FillViewport(400,600));
        skin = new Skin(Gdx.files.internal("neonui/neon-ui.json"));
        play = new TextButton("play",skin);
        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                SingletonSound.getSingletonSound().playSelect();
                game.setScreen(game.gameScreen);
            }
        });
        stage.addActor(play);
    }



    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        super.show();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        super.dispose();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        super.hide();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        super.render(delta);
    }
}
