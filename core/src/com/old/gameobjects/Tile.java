package com.old.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.old.ttnhelpers.AssetLoader;

/**
 * Created by allenwang on 7/25/15.
 */
public class Tile {
    private Possession possession = Possession.None;
    private float xSize;
    private float ySize;
    private float posX;
    private float posY;

    public Tile(float xSize, float ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void setX(float X) {
        this.posX = X;
    }

    public void setY(float Y) {
        this.posY = Y;
    }

    public float getX() {
        return (float)this.posX;
    }

    public float getY() {
        return (float)this.posY;
    }

    public float getXSize() {
        return (float)this.xSize;
    }

    public float getYSize() {
        return (float)this.ySize;
    }

    public Possession getPossession() {
        return this.possession;
    }

    public void setPossession(Possession p) {
        this.possession = p;
    }
}
