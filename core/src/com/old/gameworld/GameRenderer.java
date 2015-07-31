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
        batcher.disableBlending();

        Tile tiles[][] = board.getBoard();
        for(int y = 0; y < board.numTilesY; ++y) {
            for(int x = 0; x < board.numTilesX; ++x) {
                Tile tile = tiles[x][y];
                Sprite s = this.getSprite(tile);
                float xPos = tile.getPosition().getKey();
                float yPos = tile.getPosition().getValue();
                s.setPosition(xPos, yPos);
                s.draw(batcher);
            }
        }

        AssetLoader.shadow.draw(batcher, "Tic Tac No", cam.viewportWidth / 2 - 135, cam.viewportHeight - 20);
        AssetLoader.font.draw(batcher, "Tic Tac No", cam.viewportWidth / 2 - 135, cam.viewportHeight - 20);

        String player1Score = String.valueOf(myWorld.getPlayer1().getScore());
        String player2Score = String.valueOf(myWorld.getPlayer2().getScore());
        String player1Wins = String.valueOf(myWorld.getPlayer1().getWins());
        String player2Wins = String.valueOf(myWorld.getPlayer2().getWins());
        int xDisplacement = 200;
        int yDisplacement = 450;
        AssetLoader.shadow.draw(batcher, "Player 1: " + player1Score, cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement);
        AssetLoader.font.draw(batcher, "Player 1: " + player1Score, cam.viewportWidth / 2 - 200, cam.viewportHeight - yDisplacement);
        AssetLoader.shadow.draw(batcher, "Score: " + player1Score + " Wins: " + player1Wins, cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 50);
        AssetLoader.font.draw(batcher, "Score: " + player1Score + " Wins: " + player1Wins, cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 50);
        AssetLoader.shadow.draw(batcher, "Player 2: ", cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 100);
        AssetLoader.font.draw(batcher, "Player 2: ", cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 100);
        AssetLoader.shadow.draw(batcher, "Score: " + player2Score + " Wins: " + player2Wins, cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 150);
        AssetLoader.font.draw(batcher, "Score: " + player2Score + " Wins: " + player2Wins, cam.viewportWidth / 2 - xDisplacement, cam.viewportHeight - yDisplacement - 150);
        batcher.end();
    }

    public OrthographicCamera getCamera() { return this.cam; }

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
