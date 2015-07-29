package com.old.fat;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TicTacNo extends ApplicationAdapter {
	private SpriteBatch batch;
    private Sprite square;
	private Texture img;

    private OrthographicCamera cam;

    private final int squaresOnHeight = 4;
    private final int squaresOnWidth = 4;
    private float squareWidth;
    private float squareHeight;
    private final float xDisplacement = 150;
    private final float yDisplacement = 500;


	@Override
	public void create () {
        final float w = Gdx.graphics.getWidth();
        final float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(800, 400 * (h / w));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();
        batch = new SpriteBatch();
        img = new Texture("box.png");
        squareWidth = cam.viewportWidth / squaresOnWidth;
        squareHeight = cam.viewportHeight / squaresOnHeight;
        square = new Sprite(new Texture("box.png"));
        square.setSize(squareWidth, squareHeight);
    }

	@Override
	public void render () {
		//Clear Screen
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        for(int y = 0; y < squaresOnHeight; ++y) {
            for(int x = 0; x < squaresOnWidth; ++x) {
                float xPos = ((x*squareWidth) + xDisplacement);
                float yPos = ((y*squareHeight + yDisplacement));
                square.setPosition((x * squareWidth) + xDisplacement, y * squareHeight + yDisplacement);
                square.draw(batch);
            }
        } batch.end();
	}
}