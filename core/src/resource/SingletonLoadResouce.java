package resource;

import com.badlogic.gdx.assets.AssetManager;

public class SingletonLoadResouce {
    private LoadResource loadResource;
    private static SingletonLoadResouce singletonLoadResouce;

    private SingletonLoadResouce(){
        loadResource = new LoadResource();
        System.out.println("instancia de load resource");
    }

    public static SingletonLoadResouce getSingletonLoadResouce(){
        if(singletonLoadResouce == null){
            singletonLoadResouce = new SingletonLoadResouce();
        }else{
            System.out.println("ya se creo la instancia");
        }
        return singletonLoadResouce;
    }

    public AssetManager getAssetManager(){
        return loadResource.getManager();
    }

    public void cargar(){
        loadResource.cargar();
    }

    public void dispose(){
        loadResource.dispose();
    }

}
