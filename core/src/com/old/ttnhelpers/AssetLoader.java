package com.old.ttnhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by allenwang on 7/26/15.
 */
public class AssetLoader {
    public static Sprite tileNone, tileX, tileO;

    public static BitmapFont font, shadow;

    public static void load() {
        tileNone = new Sprite(new Texture("box.png"));
        tileX = new Sprite(new Texture("X.png"));
        tileO = new Sprite(new Texture("O.png"));
        tileNone.setSize(150, 80);
        tileX.setSize(150, 80);
        tileO.setSize(150, 80);
        font = new BitmapFont(Gdx.files.internal("text.fnt"), false);
        font.getData().setScale(.75f, .75f);
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"), false);
        shadow.getData().setScale(.75f, .75f);
    }

    public static void dispose() {
        font.dispose();
        shadow.dispose();
    }
}
