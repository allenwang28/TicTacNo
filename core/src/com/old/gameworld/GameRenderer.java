package com.old.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.old.gameobjects.Board;
import com.old.gameobjects.Possession;
import com.old.gameobjects.Tile;
import com.old.ttnhelpers.AssetLoader;


/**
 * Created by allenwang on 7/26/15.
 */
public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batcher;

    private int gameHeight;
    private int gameWidth;

    public GameRenderer(GameWorld world, float gameHeight, float gameWidth) {
        myWorld = world;
        cam = new OrthographicCamera(800, 400*(gameHeight/gameWidth));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();
        batcher = new SpriteBatch();
        // Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);


    }

    public void render() {
        Board board = myWorld.getBoard();

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        // Disable transparency
        // Good for performance when drawing images not requiring transparency.
        //batcher.disableBlending();
        /*
        float width = 200;
        float height = (float)164.44;
        AssetLoader.tileNone.setSize(width, height);
        int x = 150;
        int y = 500;
        AssetLoader.tileNone.setPosition(x, y);
        AssetLoader.tileNone.draw(batcher);
        */

        Tile tiles[][] = board.getBoard();
        for(int y = 0; y < board.numTilesY; ++y) {
            for(int x = 0; x < board.numTilesX; ++x) {
                Tile tile = tiles[x][y];
                Sprite s = this.getSprite(tile);
                float xPos = tile.getX();
                float yPos = tile.getY();
                s.setPosition(xPos, yPos);
                s.draw(batcher);
            }
        }

        batcher.end();
    }

    private Sprite getSprite(Tile tile) {
        switch(tile.getPossession()) {
            case Player1:
                return AssetLoader.tileX;
            case Player2:
                return AssetLoader.tileO;
            case None:
            default:
                return AssetLoader.tileNone;
        }
    }
}
