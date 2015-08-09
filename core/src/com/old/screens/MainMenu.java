package com.old.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.old.fat.TicTacNoGame;
import com.old.gameworld.GameRenderer;

/**
 * Created by Brandon Torio on 8/3/2015.
 */
public class MainMenu implements Screen {


    SpriteBatch batch;  //https://github.com/libgdx/libgdx/wiki/Spritebatch%2C-Textureregions%2C-and-Sprites

    //placeholder texture for now
    private Texture placeholder;

    TicTacNoGame g;

    //constructors
    public MainMenu(){
        create();
    }

    public MainMenu(TicTacNoGame g) {
        create();
        this.g=g;
    }

    public void create(){
        batch = new SpriteBatch();
    }

    public void render (float delta) {

        //draw the placeholder
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(placeholder, 0, 0);
        batch.end();

        if(Gdx.input.justTouched()) {
            Gdx.app.log("mainMenu", "touched");
            g.setScreen(new GameScreen(g));
        }
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void dispose () {

    }

    @Override
    public void show() {
        //example random texture
        placeholder = new Texture(Gdx.files.internal("Autobot alpha.png"));


    }

    @Override
    public void hide() {


    }

    @Override
    public void pause() {


    }

    @Override
    public void resume() {


    }

}
