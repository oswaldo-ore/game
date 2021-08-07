package com.mygdx.game;

import actors.ActorAbstract;
import actors.Ball;
import actors.Ladrillo;
import actors.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import org.w3c.dom.Text;

import java.util.Iterator;

/*public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Float x;
	Float variable;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("caraenojada.png" );
		x = 0.0f;
		variable = 5f;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1,1,0, 0);
		batch.begin();
		batch.draw(img, x, 0,100,100);
		batch.end();

		x+=variable;
		if(x + 100 > 800){
			variable *=-1;
		}
		if(x < 0){
			variable*=-1;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}*/

/*public class MyGame extends ApplicationAdapter{
	private Texture gotaImagen;
	private Texture valdeImagen;
	private Sound gotaSonido;
	private Music lluviaSonido;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Rectangle bucket;


	private Array<Rectangle> gotasLluvia;
	private long tiempoGotaAntes;

	@Override
	public void create() {
		gotaImagen = new Texture("drop.png");
		valdeImagen = new Texture("bucket.png");
		gotaSonido = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		lluviaSonido = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		lluviaSonido.setLooping(true);
		lluviaSonido.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);

		batch = new SpriteBatch();

		bucket = new Rectangle();
		bucket.x = 800/2 -64/2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;

		gotasLluvia = new Array<Rectangle>();
		gotaLLuvia();

		super.create();
	}

	private void gotaLLuvia(){
		Rectangle gotaLluvia = new Rectangle();
		gotaLluvia.x = MathUtils.random(0,800-64);
		gotaLluvia.y = 480;
		gotaLluvia.width = 64;
		gotaLluvia.height = 64;
		gotasLluvia.add(gotaLluvia);
		tiempoGotaAntes = TimeUtils.nanoTime();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0,0,0.2f,1);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(valdeImagen,bucket.x,bucket.y);
		for (Rectangle gota: gotasLluvia){
			batch.draw(gotaImagen,gota.x,gota.y);
		}
		batch.end();
		super.render();
		if(Gdx.input.isTouched())
		{
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(),Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x -64 /2;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x-=200*Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200*Gdx.graphics.getDeltaTime();

		if(bucket.x < 0) bucket.x = 0;
		if(bucket.x > 800-64) bucket.x = 800-64;

		if(TimeUtils.nanoTime() - tiempoGotaAntes > 1000000000) gotaLLuvia();

		for (Iterator<Rectangle> iter = gotasLluvia.iterator(); iter.hasNext();){
			Rectangle raindrop = iter.next();
			raindrop.y-= 200 * Gdx.graphics.getDeltaTime();
			if(raindrop.y + 64 < 0) iter.remove();
			if(raindrop.overlaps(bucket)){
				gotaSonido.play();
				iter.remove();
			}
		}
	}

	@Override
	public void dispose() {
		gotaSonido.dispose();
		valdeImagen.dispose();
		lluviaSonido.dispose();
		gotaImagen.dispose();
		batch.dispose();
		super.dispose();
	}
}*/

public class MyGame extends Game
{
	public SpriteBatch batch;
	public Stage stage;
	public Ball ball;
	public Ladrillo pared;
	public Ladrillo pared2;
	public Player player;


	@Override
	public void create() {
		batch = new SpriteBatch();
		stage = new Stage();
		ball = new Ball("game/ball-green.png");
		pared = new Ladrillo("game/ladrillo.png", 100,110);
		pared2 = new Ladrillo("game/ladrillo.png",230,100);
		Ladrillo pared3 = new Ladrillo("game/ladrillo.png",300,200);
		Ladrillo pared4 = new Ladrillo("game/ladrillo.png",500,100);
		Ladrillo pared5 = new Ladrillo("game/ladrillo.png",400,150);
		//player = new Player("game/game_base.png");
		stage.act();
		stage.setDebugAll(true);
		stage.addActor(ball);
		stage.addActor(pared);
		//stage.addActor(player);
		stage.addActor(pared2);
		stage.addActor(pared3);
		stage.addActor(pared4);
		stage.addActor(pared5);
		//this.setScreen(new MainMenuScreen(this));
	}



	@Override
	public void render() {
		ScreenUtils.clear(.5f,.5f,.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		stage.act();
		verificarColiciones();
		stage.draw();
		super.render();
	}

	public void verificarColiciones(){
		for (int i = 1; i< stage.getActors().size;i++){
			ActorAbstract actorsito =  (ActorAbstract) stage.getActors().get(i);
			if(ball.getcircle().overlaps(actorsito.rectangle)) {
				ball.changeDirection(pared.getRecLadrillo());
				stage.getActors().removeIndex(i);
				break;
			}
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
		pared.dispose();
		ball.dispose();
		player.dispose();
		super.dispose();
	}
}

