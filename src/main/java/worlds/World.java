package worlds;

import launcher.Game;
import tiles.Tile;
import utils.Utils;

import java.awt.*;

public class World {

    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] worldTiles;

    public World(Game game, String path){

        this.game = game;
        //Constructor calls loadWorld() right away
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x, y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){

        // Gets tile from the tiles array in the Tile class base on its index
        Tile t = Tile.tiles[worldTiles[x][y]];
        if(t==null)
            return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        worldTiles = new int[width][height];
        for (int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
            }
        }
    }

}
