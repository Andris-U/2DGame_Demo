package tiles;

import gfx.Assets;

import java.awt.image.BufferedImage;

public class BlackTile extends Tile {

    public BlackTile(int id) {
        super(Assets.blackTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
