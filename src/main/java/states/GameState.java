package states;

import entities.creatures.Player;
import gfx.Assets;
import handler.Handler;
import launcher.Game;
import tiles.Tile;
import worlds.World;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "out/production/classes/worlds/room.txt");
        handler.setWorld(world);
        player = new Player(handler,100, 70);

    }

    @Override
    public void tick() {
        // Update world before player.
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        // Order is iportant so player is drawn on top.
        world.render(g);
        player.render(g);
    }
}
