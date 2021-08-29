package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.MyGame;

public abstract class BaseScreen implements Screen {
    protected MyGame game;

    public BaseScreen(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        // This method is invoked when a screen has to be rendered in a frame.
        // delta is the amount of seconds (order of 0.01 or so) between this and last frame.
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
