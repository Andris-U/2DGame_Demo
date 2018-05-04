package states;

import entities.creatures.Player;
import gfx.Assets;
import launcher.Game;
import tiles.Tile;
import worlds.World;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100, 100);
        world = new World(game, "out/production/classes/worlds/room.txt");
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
