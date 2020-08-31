package android.example.com.questionsgame;

import android.app.Dialog;
import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.database.TriviaQuizHelper;
import android.example.com.questionsgame.screens.QuestionsScreen;
import android.example.com.questionsgame.utils.Globals;
import android.example.com.questionsgame.utils.TriviaQuestion;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;


import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AndroidGame {

    private static final String TAG = "MainActivity";

    private static QuestionsScreen questionsScreen;

    @Override
    public Screen getInitScreen() {

        StandardAsset.questionBarImage = getGraphics().newImage(R.drawable.buttontemplate, Graphics.ImageFormat.ARGB8888, getResources());
        StandardAsset.coinImage = getGraphics().newImage(R.drawable.coin, Graphics.ImageFormat.ARGB8888, getResources());
        StandardAsset.playIcon = getGraphics().newImage(R.drawable.sound, Graphics.ImageFormat.ARGB8888, getResources());
        StandardAsset.bg = getGraphics().newImage(R.drawable.baack, Graphics.ImageFormat.ARGB8888, getResources());

        Log.i(TAG, "getInitScreen: Assets are Loaded");

        updateQueAndOptions();
        Score.rankCurrentQuestion = 0 ;
        questionsScreen = new QuestionsScreen(this);
        StandardAsset.mainActivity = this;
        Score.startTimer();
        Score.initializeTimeQuestionsArray();
        return questionsScreen;
    }

    public void updateQueAndOptions() {

            if(StandardAsset.currentLanguage == 1 ){
                StandardAsset.winSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("suivant", "raw", getPackageName()));
                StandardAsset.loseSound = getAudio().createMusic(R.raw.retry);
                StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("won", "raw", getPackageName()));
                StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.won);
            }
            else if(StandardAsset.currentLanguage == 2 ){
                StandardAsset.winSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("suivantfr", "raw", getPackageName()));
                StandardAsset.loseSound = getAudio().createMusic(R.raw.retryfr);
                StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("wonfr", "raw", getPackageName()));
                StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.wonfr);
            }
            else if(StandardAsset.currentLanguage == 3 ){
                StandardAsset.winSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("suivanten", "raw", getPackageName()));
                StandardAsset.loseSound = getAudio().createMusic(R.raw.retryen);
                StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("wonen", "raw", getPackageName()));
                StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.wonen);
            }


        if (Score.record == 0) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit0, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 1) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit1, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 2) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit2, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 3) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit3, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 4) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit4, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 5) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit5, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 6) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit6, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 7) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit7, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 8) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit8, Graphics.ImageFormat.ARGB8888, getResources());
        } else if (Score.record == 9) {
            StandardAsset.digitImage = getGraphics().newImage(R.drawable.digit9, Graphics.ImageFormat.ARGB8888, getResources());
        }

        //Log.i(TAG, "qid = "+ StandardAsset.qid);

        StandardAsset.currentQuestion = (StandardAsset.list).get(StandardAsset.qid);



        String a = StandardAsset.currentQuestion.getOptA();
        String b = StandardAsset.currentQuestion.getOptB();
        String c = StandardAsset.currentQuestion.getOptC();


        int idImageA = getResources().getIdentifier(a, "drawable", getPackageName());
        int idImageB = getResources().getIdentifier(b, "drawable", getPackageName());
        int idImageC = getResources().getIdentifier(c, "drawable", getPackageName());

        StandardAsset.optionAImage = getGraphics().newImage(idImageA, Graphics.ImageFormat.ARGB8888, getResources());
        StandardAsset.optionBImage = getGraphics().newImage(idImageB, Graphics.ImageFormat.ARGB8888, getResources());
        StandardAsset.optionCImage = getGraphics().newImage(idImageC, Graphics.ImageFormat.ARGB8888, getResources());


        if(StandardAsset.currentLanguage == 1 ) StandardAsset.questionSound = getAudio().createMusic(getResources().getIdentifier(StandardAsset.currentQuestion.getAnswer(), "raw", getPackageName()));
        if(StandardAsset.currentLanguage == 2 ) StandardAsset.questionSound = getAudio().createMusic(getResources().getIdentifier(StandardAsset.currentQuestion.getAnswer()+"fr", "raw", getPackageName()));
        if(StandardAsset.currentLanguage == 3 ) StandardAsset.questionSound = getAudio().createMusic(getResources().getIdentifier(StandardAsset.currentQuestion.getAnswer()+"en", "raw", getPackageName()));

    }

    public void updateSounds() {

        if(StandardAsset.currentLanguage == 1 ){
            StandardAsset.loseSound = getAudio().createMusic(R.raw.retry);
            StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("won", "raw", getPackageName()));
            StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.won);
        }
        else if(StandardAsset.currentLanguage == 2 ){
            StandardAsset.loseSound = getAudio().createMusic(R.raw.retryfr);
            StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("wonfr", "raw", getPackageName()));
            StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.wonfr);
        }
        else if(StandardAsset.currentLanguage == 3 ){
            StandardAsset.loseSound = getAudio().createMusic(R.raw.retryen);
            StandardAsset.finalWinSound = (AndroidSound) getAudio().createSound(getResources().getIdentifier("wonen", "raw", getPackageName()));
            StandardAsset.finalWinSoundMusic = getAudio().createMusic(R.raw.wonen);
        }
    }

    public void onWin() {

        StandardAsset.questionSound.play();

    }


    //This dialog is show to the user after he ans correct
    public void correctDialog() {
        Score.record++;
        StandardAsset.qid++;
        if (Score.record < 10) {
            updateQueAndOptions();

            Score.rankCurrentQuestion++ ;

            new Thread() {
                public void run() {  // We use a different thread because if we don't we will get an error de sorte: concurrent Access
                    MainActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            //Do your UI operations like dialog opening or Toast here
                            final Dialog dialogCorrect = new Dialog(MainActivity.this);
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            if(StandardAsset.currentLanguage == 1) dialogCorrect.setContentView(R.layout.dialog_correct);
                            else if(StandardAsset.currentLanguage == 2) dialogCorrect.setContentView(R.layout.dialog_correctfr);
                            else if(StandardAsset.currentLanguage == 3) dialogCorrect.setContentView(R.layout.dialog_correcten);

                            dialogCorrect.setCancelable(false);
                            dialogCorrect.show();
                            TextView correctText = (TextView) dialogCorrect.findViewById(R.id.correctText);
                            Button buttonNext = null;
                            if(StandardAsset.currentLanguage == 1) buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNext);
                            else if(StandardAsset.currentLanguage == 2) buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNextfr);
                            else if(StandardAsset.currentLanguage == 3) buttonNext = (Button) dialogCorrect.findViewById(R.id.dialogNexten);

                            buttonNext.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialogCorrect.dismiss();
                                    StandardAsset.questionSound.play();
                                    Score.startTimer();
                                }
                            });
                        }
                    });
                }
            }.start();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            gameWon();
        }
    }

    //This method will navigate from current activity to GameWon
    public void gameWon() {
        StandardAsset.finalWinSoundMusic.play();
        Intent intent = new Intent(this, GameWon.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        StandardAsset.questionSound.stop();
        StandardAsset.loseSound.stop();
        Intent intent = new Intent(this, ChoixLangue.class);
        startActivity(intent);
    }

    public QuestionsScreen getQuestionsScreen() {
        return questionsScreen;
    }

    public void exitGame(){
        finish();
    }
}
