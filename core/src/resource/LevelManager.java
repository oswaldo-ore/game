package resource;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.files.FileHandle;


public class LevelManager {
    public int currentLevel;

    public LevelManager()
    {
        currentLevel = 1;
    }

    public void loadCurrentLevel(){
        FileHandle file = Gdx.files.internal("nivel/niveles.txt");
    }
}
