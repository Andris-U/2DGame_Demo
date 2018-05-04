package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage player, boy, woodFloorTile, grassTile, blackTile;

    public static void init(){
        SpriteSheet characterKids = new SpriteSheet(ImageLoader.loadImage("/textures/kids.png"));
        SpriteSheet woodFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/woodFloor.png"));
        SpriteSheet groundTiles = new SpriteSheet(ImageLoader.loadImage("/textures/tileSetGround.jpg"));

        player = characterKids.crop(0,0 ,width, height);
        woodFloorTile = groundTiles.crop(width*3, height*3, width, height);
        grassTile = groundTiles.crop(0, height, width, height);
        blackTile = groundTiles.crop(0,0,width,height);

    }

}
