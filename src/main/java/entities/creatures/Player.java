package entities.creatures;

import gfx.Assets;
import handler.Handler;
import launcher.Game;

import java.awt.*;

public class Player extends Creature{


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;

    }

    @Override
    public void render(Graphics g) {
        // TODO: Update for animations
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
