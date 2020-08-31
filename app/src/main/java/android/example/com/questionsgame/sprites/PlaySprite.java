package android.example.com.questionsgame.sprites;

import android.example.com.questionsgame.assets.StandardAsset;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Base.Music;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidMusic;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

public class PlaySprite extends Sprite {

    private Music mAndroidMusic;

    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */

    public PlaySprite(Image image, Music mAndroidMusic, int x, int y, int height, int width) {
        super(image, x, y, height, width);
        this.mAndroidMusic= mAndroidMusic;
        //this.mAndroidMusic.play();
    }

    public void play(){

        //this.mAndroidMusic.play();
        //mAndroidMusic.pause();
        //mAndroidMusic.seekBegin();
        //mAndroidMusic.play();
    }
}
