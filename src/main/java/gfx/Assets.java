package gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage woodFloorTile, grassTile, blackTile;
    public static BufferedImage[] player_down, player_left, player_right, player_up;

    public static void init(){
        SpriteSheet characterKids = new SpriteSheet(ImageLoader.loadImage("/textures/kids.png"));
        SpriteSheet woodFloorTiles = new SpriteSheet(ImageLoader.loadImage("/textures/woodFloor.png"));
        SpriteSheet groundTiles = new SpriteSheet(ImageLoader.loadImage("/textures/tileSetGround.jpg"));

        player_down = new BufferedImage[3];
        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_up = new BufferedImage[3];

        player_down[0] = characterKids.crop(0, height * 4, width, height);
        player_down[1] = characterKids.crop(width, height * 4, width, height);
        player_down[2] = characterKids.crop(width * 2, height * 4, width, height);
        player_left[0] = characterKids.crop(0,height * 5, width, height);
        player_left[1] = characterKids.crop(width,height * 5, width, height);
        player_left[2] = characterKids.crop(width * 2,height * 5, width, height);
        player_right[0] = characterKids.crop(0,height * 6, width, height);
        player_right[1] = characterKids.crop(width,height * 6, width, height);
        player_right[2] = characterKids.crop(width * 2,height * 6, width, height);
        player_up[0] = characterKids.crop(0,height * 7, width, height);
        player_up[1] = characterKids.crop(width,height * 7, width, height);
        player_up[2] = characterKids.crop(width * 2,height * 7, width, height);


        woodFloorTile = groundTiles.crop(width*3, height*3, width, height);
        grassTile = groundTiles.crop(0, height, width, height);
        blackTile = groundTiles.crop(0,0,width,height);

    }

}
