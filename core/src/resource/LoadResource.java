package resource;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class LoadResource {
    private AssetManager manager;

    public LoadResource(){
        manager = new AssetManager();
    }

    public void cargar(){
        manager.load("game/ball-green.png", Texture.class);
        manager.load("game/life.png", Texture.class);
        manager.load("game/explotionsuelo.png", Texture.class);
        manager.load("game/ladrillo-red.png", Texture.class);
        manager.load("game/ladrillo-green.png", Texture.class);
        manager.load("game/ladrillo-plomo.png", Texture.class);
        manager.load("game/ladrillo-violet.png", Texture.class);
        manager.load("game/player.png", Texture.class);
        manager.load("game/sprite_explosion.png", Texture.class);

        manager.load("sound/music.mp3", Music.class);
        manager.load("sound/sound_die.mp3", Sound.class);
        manager.load("sound/sound_explotion.wav", Sound.class);
        manager.load("sound/select.mp3",Sound.class);
        manager.load("sound/metal.wav",Sound.class);
    }

    public void dispose(){
        manager.dispose();
    }

    public AssetManager getManager() {
        return manager;
    }
}
