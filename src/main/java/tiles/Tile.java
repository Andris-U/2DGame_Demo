package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    // STATIC STUFF
    public static Tile[] tiles = new Tile[256];
    public static Tile blackTile = new BlackTile(0);
    public static Tile grassTile = new GrassTile(1);
    public static Tile woodFloorTile = new WoodFloorTile(2);

    //CLASS
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        // Sets index slot in tiles[] to this new object, based on the id we gave it
        tiles[id] = this;
    }

    public void tick(){}

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    // By default we cannot walk on tiles, unless we explicitly say so in their own classes.
    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
