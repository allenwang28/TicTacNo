package com.old.gameobjects;

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

    public void setPosition(com.old.ttnhelpers.OrderedPair<Float, Float> position) {
        this.posX = position.getKey();
        this.posY = position.getValue();
    }

    public com.old.ttnhelpers.OrderedPair<Float, Float> getPosition() {
        return new com.old.ttnhelpers.OrderedPair(posX, posY);
    }

    public com.old.ttnhelpers.OrderedPair<Float, Float> getSize() {
        return new com.old.ttnhelpers.OrderedPair(xSize, ySize);
    }

    public Possession getPossession() {
        return this.possession;
    }

    public void setPossession(Possession p) {
        this.possession = p;
    }

    public boolean isInRange(float X, float Y) {
        /*
        float rightX = posX + xSize / 2;
        float leftX = posX - xSize / 2;
        float topY = posY + ySize / 2;
        float bottomY = posY - ySize / 2;
        */
        float leftX = posX;
        float rightX = posX + xSize;
        float bottomY = posY;
        float topY = posY + ySize;
        boolean isInXRange = (X <= rightX) && (X >= leftX);
        boolean isInYRange = (Y <= topY) && (Y >= bottomY);
        return isInXRange && isInYRange;
    }

    public boolean hasNoPossession() {
        return possession == Possession.None;
    }
}
