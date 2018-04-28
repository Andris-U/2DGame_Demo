package entities;

import java.awt.*;

public abstract class Entity {

    // We choose floats here to achieve smooth movement. Weird, I know, since the measure
    // things in pixels, but it will help in the calculations making movement more
    // accurate and less clunky.
    protected float x, y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
