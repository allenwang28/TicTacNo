package com.old.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.old.gameworld.GameRenderer;

/**
 * Created by Brandon Torio on 8/3/2015.
 */
public class MainMenu implements Screen {
    Skin skin;
    Stage stage;
    SpriteBatch batch;
    private Texture autobot;
    Game g;

    GameScreen gamescreen;

    private SpriteBatch spriteBatch;

    private GameRenderer renderer;
    //private GameWorld gameWorld;

    public MainMenu(){
        create();

    }

    public MainMenu(Game g) {
        create();
        this.g=g;
    }

    public void create(){
        batch = new SpriteBatch();
        stage = new Stage();
        //polls for input from touch screen, accelerometer, etc
        Gdx.input.setInputProcessor(stage);


        //I don't fully understand what everything under this does yet:

        skin = new Skin();
        // Generate a 1x1 white texture and store it in the skin named "white".
        Pixmap pixmap = new Pixmap(100, 100, Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin.add("white", new Texture(pixmap));

        // Store the default libgdx font under the name "default".
        BitmapFont bfont=new BitmapFont();
       // bfont.scale(1);
        skin.add("default",bfont);


        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);

        final TextButton textButton=new TextButton("PLAY",textButtonStyle);
        textButton.setPosition(200, 200);
        stage.addActor(textButton);
        stage.addActor(textButton);
        stage.addActor(textButton);


        //if you click the screen go into a game (has errors)

        textButton.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                textButton.setText("Starting new game");
                g.setScreen( new GameScreen());

            }
        });

    }

    public void render (float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(autobot, 0, 0);
        spriteBatch.end();

        gamescreen = new GameScreen();

        if(Gdx.input.justTouched()) {
            Gdx.app.log("mainMenu", "touched");
            g.setScreen(gamescreen);
        }
    }

    @Override
    public void resize (int width, int height) {
        spriteBatch = new SpriteBatch();
        stage.setViewport(new StretchViewport(width, height));
    }

    @Override
    public void dispose () {
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void show() {
        //example random texture
        autobot = new Texture(Gdx.files.internal("Autobot alpha.png"));


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
