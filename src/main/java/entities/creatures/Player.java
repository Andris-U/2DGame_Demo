package entities.creatures;

import gfx.Animation;
import gfx.Assets;
import handler.Handler;
import launcher.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    // Animation
    private Animation animDown, animLeft, animRight, animUp;


    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        // Collision box... err, rectangle.
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;

        // Animations
        animDown = new Animation(200, Assets.player_down);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
        animUp = new Animation(200, Assets.player_up);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animLeft.tick();
        animRight.tick();
        animUp.tick();

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
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, null);

        // This is just the hitbox below.
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }else{
            return animDown.getFrames()[1];
        }
    }
}
