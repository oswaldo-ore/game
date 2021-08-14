package utils;

public class SingletonSound {

    private SoundGame soundGame;
    private static SingletonSound singletonSound;

    public SingletonSound(){
        soundGame = new SoundGame();
        System.out.println("creado el soundGame");
    }

    public static SingletonSound getSingletonSound(){
        if(singletonSound == null){
            singletonSound = new SingletonSound();
            System.out.println("creando un singleton sound");
        }else{
            System.out.println("ya exite el singleton sound");
        }
        return singletonSound;
    }

    public SoundGame getSoundGame() {
        return soundGame;
    }

    public void soundDie(){
        soundGame.soundDie();
    }

    public void soundExplotion(){
        soundGame.soundExplotion();
    }

    public void playMusic(){
        soundGame.playMusic();
    }

    public void stopMusic(){
        soundGame.stopMusic();
    }

    public void dispose(){
        soundGame.dispose();
    }
}
