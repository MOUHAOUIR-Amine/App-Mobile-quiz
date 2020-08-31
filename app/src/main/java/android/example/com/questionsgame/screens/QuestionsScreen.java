package android.example.com.questionsgame.screens;

import android.example.com.questionsgame.MainActivity;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.sprites.OptionSprite;
import android.example.com.questionsgame.sprites.PlaySprite;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;

import static java.lang.Thread.sleep;

public class QuestionsScreen extends Screen {

    private final String TAG = "QuestionsScreen : ";

    private Sprite questionBar, background, spriteCoin, spriteDigit;
    private PlaySprite playSprite;
    private OptionSprite optionA;
    private OptionSprite optionB;
    private OptionSprite optionC;

    private MainActivity mainActivity;

    public QuestionsScreen(Game game) {
        super(game);

        mainActivity = (MainActivity) game;

        questionBar = new Sprite(StandardAsset.questionBarImage, (int)(game.getGraphics().getWidth()/10), (int)(game.getGraphics().getHeight()/10), (int)(game.getGraphics().getHeight()/12), (int)(game.getGraphics().getWidth()*3.3/4));

        background = new Sprite(StandardAsset.bg, 0, 0, game.getGraphics().getHeight(), game.getGraphics().getWidth());

        spriteCoin = new Sprite(StandardAsset.coinImage, (int)game.getGraphics().getWidth()/100, (int)(game.getGraphics().getHeight()/200), (int)(game.getGraphics().getHeight()/16), (int)(game.getGraphics().getWidth()/10));
        spriteDigit = new Sprite(StandardAsset.digitImage, (int)game.getGraphics().getWidth()/9, (int)(game.getGraphics().getHeight()/200), (int)(game.getGraphics().getHeight()/16), (int)(game.getGraphics().getWidth()/15));

        playSprite = new PlaySprite(StandardAsset.playIcon, StandardAsset.questionSound, (int)(game.getGraphics().getWidth()/2.4), (int)(game.getGraphics().getHeight()/4.8), (int)(game.getGraphics().getHeight()/10), (int)(game.getGraphics().getWidth()/5));
        optionA = new OptionSprite(StandardAsset.optionAImage, (int)(game.getGraphics().getWidth()/10), (int)(game.getGraphics().getHeight()/2.74), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionA.setType(1);
        optionB = new OptionSprite(StandardAsset.optionBImage, (int)(game.getGraphics().getWidth()/1.54), (int)(game.getGraphics().getHeight()/2.74), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionB.setType(2);
        optionC = new OptionSprite(StandardAsset.optionCImage, (int)(game.getGraphics().getWidth()/2.4), (int)(game.getGraphics().getHeight()/1.476), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionC.setType(3);

        addSprite(background);
        addSprite(spriteCoin);
        addSprite(spriteDigit);
        addSprite(questionBar);
        addSprite(playSprite);
        addSprite(optionA);
        addSprite(optionB);
        addSprite(optionC);

        StandardAsset.questionSound.play();
        //StandardAsset.loseSound.play();
        Log.d(TAG, "Constructor Called");

    }

    @Override
    public void render(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void backButton() {

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        Log.i(TAG, "getInitScreen: Assets are Loaded");
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();
        //Log.i(TAG, "handleTouchDown: S class is: "+s.getClass());
        if (s != null) {
            if (s.getClass() == PlaySprite.class) {
                StandardAsset.questionSound.stop();
                StandardAsset.loseSound.stop();
                mainActivity.updateSounds();
                StandardAsset.questionSound.play();
            }

            if (s.getClass() == OptionSprite.class) {
                OptionSprite sss = (OptionSprite) s;
                switch (sss.getType()) {
                    case 1:
                        buttonA();
                        break;
                    case 2:
                        buttonB();
                        break;
                    case 3:
                        buttonC();
                        break;
                }
                //Score.game_database_handler.updateGame(Score.id_game, Score.game);
            }
        }
    }

    //Onclick StandardAsset.listener for first button
    public void buttonA() {
        //compare the option with the ans if yes then make button color green
        if (StandardAsset.currentQuestion.getOptA().equals(StandardAsset.currentQuestion.getAnswer())) {

            Score.stopTimmer();

            Score.time_questions[Score.rankCurrentQuestion] = Score.countTimmer ;

            Log.d(TAG, "Time of question:" + String.valueOf(Score.rankCurrentQuestion)+" is: "+String.valueOf(Score.time_questions[Score.rankCurrentQuestion]));

            //Score.game.setSuccessful_attempts(Score.game.getSuccessful_attempts() + 1);
            Score.successful_attempts++;
            Log.d(TAG, "OPTA");
            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            if (Score.record < 9) StandardAsset.winSound.play(1);
            mainActivity.correctDialog();
            if(Score.record < 10) updateSprites();
        }

        //User ans is wrong then just navigate him to the PlayAgain activity
        else {
            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            StandardAsset.loseSound.play();
            //Score.game.setFailed_attempts(Score.game.getFailed_attempts()+1);
            Score.failed_attempts++;
        }
    }

    //Onclick StandardAsset.listener for first button
    public void buttonB() {
        mainActivity.updateSounds();
        if (StandardAsset.currentQuestion.getOptB().equals(StandardAsset.currentQuestion.getAnswer())) {

            Score.stopTimmer();

            Score.time_questions[Score.rankCurrentQuestion] = Score.countTimmer ;

            Log.d(TAG, "Time of question:" + String.valueOf(Score.rankCurrentQuestion)+" is: "+String.valueOf(Score.time_questions[Score.rankCurrentQuestion]));

            //Score.game.setSuccessful_attempts(Score.game.getSuccessful_attempts() + 1);
            Score.successful_attempts++;
            Log.d(TAG, "OPTB");
            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            if (Score.record < 9) StandardAsset.winSound.play(1);
            mainActivity.correctDialog();
            //mainActivity.updateQueAndOptions();
            if(Score.record < 10) updateSprites();

        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            StandardAsset.loseSound.play();
            //Score.game.setFailed_attempts(Score.game.getFailed_attempts()+1);
            Score.failed_attempts++;
        }
    }

    //Onclick StandardAsset.listener for first button
    public void buttonC() {
        //compare the option with the ans if yes then make button color green
        if (StandardAsset.currentQuestion.getOptC().equals(StandardAsset.currentQuestion.getAnswer())) {

            Score.stopTimmer();

            Score.time_questions[Score.rankCurrentQuestion] = Score.countTimmer ;

            Log.d(TAG, "Time of question:" + String.valueOf(Score.rankCurrentQuestion)+" is: "+String.valueOf(Score.time_questions[Score.rankCurrentQuestion]));

            //Score.game.setSuccessful_attempts(Score.game.getSuccessful_attempts() + 1);
            Score.successful_attempts++;
            Log.d(TAG, "OPTC");
            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            if (Score.record < 9) StandardAsset.winSound.play(1);
            mainActivity.correctDialog();
            if(Score.record < 10) updateSprites();

        }
        //User ans is wrong then just navigate him to the PlayAgain activity
        else {

            StandardAsset.loseSound.stop();
            StandardAsset.questionSound.stop();
            mainActivity.updateSounds();
            StandardAsset.loseSound.play();
            //Score.game.setFailed_attempts(Score.game.getFailed_attempts()+1);
            Score.failed_attempts++;
        }
    }

    public void updateSprites(){
        removeSprite(spriteDigit);
        removeSprite(optionA);
        removeSprite(optionB);
        removeSprite(optionC);
        spriteDigit = new Sprite(StandardAsset.digitImage, (int)game.getGraphics().getWidth()/9, (int)(game.getGraphics().getHeight()/200), (int)(game.getGraphics().getHeight()/16), (int)(game.getGraphics().getWidth()/15));

        addSprite(spriteDigit);

        optionA = new OptionSprite(StandardAsset.optionAImage, (int)(game.getGraphics().getWidth()/10), (int)(game.getGraphics().getHeight()/2.74), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionA.setType(1);
        optionB = new OptionSprite(StandardAsset.optionBImage, (int)(game.getGraphics().getWidth()/1.54), (int)(game.getGraphics().getHeight()/2.74), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionB.setType(2);
        optionC = new OptionSprite(StandardAsset.optionCImage, (int)(game.getGraphics().getWidth()/2.4), (int)(game.getGraphics().getHeight()/1.476), (int)(game.getGraphics().getHeight()/6), (int)(game.getGraphics().getWidth()/4));
        optionC.setType(3);

        addSprite(optionA);
        addSprite(optionB);
        addSprite(optionC);

    }

}
