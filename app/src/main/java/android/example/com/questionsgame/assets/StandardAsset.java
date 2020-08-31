package android.example.com.questionsgame.assets;

import android.example.com.questionsgame.MainActivity;
import android.example.com.questionsgame.sprites.PlaySprite;
import android.example.com.questionsgame.utils.TriviaQuestion;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Base.Music;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.util.List;

public class StandardAsset {
    public static Image questionBarImage;
    public static Image playIcon;
    public static Image optionAImage;
    public static Image optionBImage;
    public static Image optionCImage;
    public static Image bg;
    public static Image coinImage;
    public static Image digitImage;

    public static Music questionSound;

    public static AndroidSound winSound;

    public static AndroidSound finalWinSound ;
    public static Music finalWinSoundMusic ;
    public static MainActivity mainActivity = null;

    public static Music loseSound;

    public static TriviaQuestion currentQuestion;
    public static int qid = 0;
    public static List<TriviaQuestion> list;

    public static boolean exited = false;

    public static int currentLanguage ;

}
