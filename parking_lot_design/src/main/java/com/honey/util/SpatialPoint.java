package com.honey.util;

public class SpatialPoint {
    private float x;
    private float y;

    public SpatialPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + " , " + y + "]";
    }
}

