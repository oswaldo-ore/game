package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MyGame;
import utils.BaseScreen;
import utils.LeerFichero;

import java.util.ArrayList;

public class LoadingScreen extends BaseScreen {
    private Label loading;
    private Skin skin;
    private Stage stage;

    public LoadingScreen(MyGame game) {
        super(game);
        stage = new Stage(new FillViewport(400,600));
        skin = new Skin(Gdx.files.internal("neonui/neon-ui.json"));
        loading = new Label("Loading...",skin);
        loading.setPosition(320-loading.getWidth()/2,180 - loading.getHeight()/2);
        stage.addActor(loading);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(game.getManager().update()){
            game.finishLoading();
        }else{
            int progress = (int)(game.getManager().getProgress() * 100);
            loading.setText("Loading.... " + progress + "%");
        }
        stage.act();
        stage.draw();
        super.render(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        super.dispose();
    }
}
