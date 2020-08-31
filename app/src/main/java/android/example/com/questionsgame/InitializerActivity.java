package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.database.TriviaQuizHelper;
import android.example.com.questionsgame.utils.Globals;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;

public class InitializerActivity extends AppCompatActivity {
    private TriviaQuizHelper triviaQuizHelper;
    private static final String TAG = "InitializerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeQuestionsList();
        super.onCreate(savedInstanceState);

        if (StandardAsset.mainActivity == null || StandardAsset.exited) {
            StandardAsset.exited = false;
            StandardAsset.mainActivity = null;
            Score.rankCurrentQuestion = 0;
            Score.initializeTimeQuestionsArray();
            Intent intent = new Intent(InitializerActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            StandardAsset.mainActivity.updateQueAndOptions();
            StandardAsset.mainActivity.updateSounds();
            (StandardAsset.mainActivity.getQuestionsScreen()).updateSprites();
            StandardAsset.questionSound.play();
            Score.rankCurrentQuestion = 0;
            Score.initializeTimeQuestionsArray();
            Score.startTimer();

        }
        finish();
    }

    public void initializeQuestionsList() {
        //Our database helper class
        triviaQuizHelper = new TriviaQuizHelper(this);
        //Make db writable
        triviaQuizHelper.getWritableDatabase();

        StandardAsset.qid = 0;

        //It will check if the ques,options are already added in table or not
        //If they are not added then the getAllOfTheQuestions() will return a list of size zero
        //if (triviaQuizHelper.getAllOfTheQuestions().size() == 0) {
        //If not added then add the ques,options in table
        //    triviaQuizHelper.allQuestion();
        //}

        //This will return us a list of data type TriviaQuestion faaaaaaaaaaaahd
        Globals g = Globals.getInstance();

        //Temporarlly we are hardcoding the globals's data !!!
        //g.setData(2);

        int niveau = g.getData();

        if (niveau == 1) {
            StandardAsset.list = triviaQuizHelper.getFirstOfTheQuestions();
        } else if (niveau == 2) {
            StandardAsset.list = triviaQuizHelper.getSecondOfTheQuestions();
        } else if (niveau == 3) {
            StandardAsset.list = triviaQuizHelper.getThirdOfTheQuestions();
        } else if (niveau == 4) {
            StandardAsset.list = triviaQuizHelper.getAllOfTheQuestions();
        } else if (niveau == 5) {
            StandardAsset.list = triviaQuizHelper.getFirstArabicOfTheQuestions();
        } else if (niveau == 6) {
            StandardAsset.list = triviaQuizHelper.getSecondArabicOfTheQuestions();
        } else if (niveau == 7) {
            StandardAsset.list = triviaQuizHelper.getThirdArabicOfTheQuestions();
        } else if (niveau == 8) {
            StandardAsset.list = triviaQuizHelper.getAllArabicOfTheQuestions();
        } else if (niveau == 9) {
            StandardAsset.list = triviaQuizHelper.getFirstEnglishOfTheQuestions();
        } else if (niveau == 10) {
            StandardAsset.list = triviaQuizHelper.getSecondEnglishOfTheQuestions();
        } else if (niveau == 11) {
            StandardAsset.list = triviaQuizHelper.getThirdEnglishOfTheQuestions();
        } else if (niveau == 12) {
            StandardAsset.list = triviaQuizHelper.getAllEnglishOfTheQuestions();
        }

        Collections.shuffle(StandardAsset.list);

    }
}
