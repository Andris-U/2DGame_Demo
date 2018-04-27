package states;

import gfx.Assets;

import java.awt.*;

public class GameState extends State {

    public GameState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.woodFloor, 0, 0, null);
    }
}
