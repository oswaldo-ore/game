package utils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import resource.SingletonLoadResouce;

public class SoundGame {
    private Sound soundExplotion;
    private Sound soundDie;
    private Music music;
    private Sound select;
    private Sound metal;

    private float volume = 0.2f;

    public SoundGame(){
        SingletonLoadResouce resouce = SingletonLoadResouce.getSingletonLoadResouce();
        soundDie = resouce.getAssetManager().get("sound/sound_die.mp3");
        soundExplotion = resouce.getAssetManager().get("sound/sound_explotion.wav");
        music = resouce.getAssetManager().get("sound/music.mp3");
        select = resouce.getAssetManager().get("sound/select.mp3");
        metal = resouce.getAssetManager().get("sound/metal.wav");
        music.setVolume(volume);
    }
    public void playMetal(){
        metal.play(1f);
    }

    public void soundAddSelect(Sound select){
        this.select = select;
    }

    public void playSelect(){
        this.select.play();
    }

    public void setSoundDie(Sound die){
        soundDie = die;
    }

    public void playMusic(){
        music.play();
        music.setLooping(true);
    }

    public void soundDie(){
        soundDie.play();
    }

    public void soundExplotion(){
        soundExplotion.play();
    }

    public void stopMusic(){
        music.stop();
    }

    public void dispose(){
        soundDie.dispose();
        soundExplotion.dispose();
        select.dispose();
        music.dispose();
        metal.dispose();
    }
}
