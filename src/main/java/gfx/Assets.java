package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage player, boy, woodFloor;

    public static void init(){
        SpriteSheet characterKids = new SpriteSheet(ImageLoader.loadImage("/textures/kids.png"));
        SpriteSheet woodFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/woodFloor.png"));

        player = characterKids.crop(0,0 ,width, height);
        woodFloor = woodFloorTiles.crop(width*2, 0, 32,32);

    }

}
