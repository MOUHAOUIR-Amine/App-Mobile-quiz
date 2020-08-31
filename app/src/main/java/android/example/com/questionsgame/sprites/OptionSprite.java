package android.example.com.questionsgame.sprites;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class OptionSprite extends Sprite {

    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */

    private int Type;
    public OptionSprite(Image image, int x, int y, int height, int width) {
        super(image, x, y, height, width);
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
