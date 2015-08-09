package com.old.fat;

import com.old.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.old.screens.MainMenu;
import com.old.ttnhelpers.AssetLoader;

/**
 * Created by allenwang on 7/26/15.
 */
public class TicTacNoGame extends Game {


    @Override
    public void create() {
        AssetLoader.load();
        //set the screen as the main menu, pass in game
        setScreen(new MainMenu(this));
        screen.show();
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
