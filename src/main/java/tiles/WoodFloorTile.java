package tiles;

import gfx.Assets;

import java.awt.image.BufferedImage;

public class WoodFloorTile extends Tile {

    public WoodFloorTile(int id) {
        super(Assets.woodFloorTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
