package utils;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

class SoundGame {
    private Sound soundExplotion;
    private Sound soundDie;
    private Music music;

    private float volume = 0.5f;

    public SoundGame(){
        soundDie = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/sound_die.mp3", Files.FileType.Internal));
        soundExplotion = Gdx.audio.newSound(Gdx.files.getFileHandle("sound/sound_explotion.wav", Files.FileType.Internal));

        music = Gdx.audio.newMusic(Gdx.files.getFileHandle("sound/music.mp3", Files.FileType.Internal));

        music.setVolume(volume);

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
        music.dispose();
    }
}
