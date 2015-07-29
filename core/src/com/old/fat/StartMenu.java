package com.old.fat;

//imports might be able to be cleaned later
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Screen;
import com.old.screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.old.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.old.ttnhelpers.AssetLoader;


/**
 * Created by Brandon Torio on 7/28/2015.
 * The start menu that you will see at the beginning (possibly after the splash)
 *
 */
public class StartMenu implements Screen
{

    TicTacNo game;
    OrthographicCamera camera;


    public StartMenu(TicTacNo game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        //render the words
        game.batch.begin();
        game.font.draw(game.batch, "Start Screen Test", 100, 150);
        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {
    }


    @Override
    public void show() {

    }


    @Override
    public void hide() {
        // called when current screen changes from this to a different screen
    }

    @Override
    public void pause() {
    }


    @Override
    public void resume() {
    }


    @Override
    public void dispose() {
        // never called automatically
    }

}
