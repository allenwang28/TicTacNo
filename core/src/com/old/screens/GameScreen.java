package com.old.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.old.gameworld.GameRenderer;
import com.old.gameworld.GameWorld;
import com.old.ttnhelpers.InputHandler;

/**
 * Created by allenwang on 7/26/15.
 */
public class GameScreen implements Screen {
    private GameRenderer renderer;
    private GameWorld gameWorld;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float tileSize = 150;
        float xDisplacement = 2 * tileSize;
        float yDisplacement = 3 * (screenHeight / 8);

        gameWorld = new GameWorld(150, 80, 100, 125);
        renderer = new GameRenderer(gameWorld, screenHeight, screenWidth);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getBoard()));
    }

    @Override
    public void render(float delta) {
        gameWorld.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
