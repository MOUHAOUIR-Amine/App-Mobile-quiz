package android.example.com.questionsgame;

import android.app.Activity;
import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.utils.Globals;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

public class GameWon extends Activity {
    private static final String TAG = "GameWon";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(StandardAsset.currentLanguage == 1) setContentView(R.layout.game_won);
        else if(StandardAsset.currentLanguage == 2) setContentView(R.layout.game_wonfr);
        else if(StandardAsset.currentLanguage == 3) setContentView(R.layout.game_wonen);
        Score.record = 0;
        StandardAsset.qid = 0;
        Collections.shuffle(StandardAsset.list);

        Arrays.sort(Score.time_questions);

        int min_time_questions = Score.time_questions[0];

        double avg_time_questions = 0;
        for(int i= 0; i< Score.time_questions.length; i++ ){
            avg_time_questions = avg_time_questions + Score.time_questions[i];
        }
        avg_time_questions = avg_time_questions / 10 ;

        //Score.game.setMin_time_succeed_sec(min_time_questions);
        //Score.game.setAvg_time_succeed_sec(avg_time_questions);

        //Score.game.setUpdated_At(Calendar.getInstance().getTime());

        //FoxyAuth.storeGameStat(this,Score.game.makeGameStat()); // Ecriture dans la base de données, puisque dans la table où on stock dans la BDD, chaque ligne correspond à un level_id précis, donc on doit stocker à la fin de chaque level

        //showOnLogTimeQuestions();

        Log.i(TAG, "minTime is:" + String.valueOf(min_time_questions));
        Log.i(TAG, "avgTime is:" + String.valueOf(avg_time_questions));

        Score.rankCurrentQuestion = 0;
        Score.initializeTimeQuestionsArray();

        //Score.game.initializeGameAsset();
    }

    public void PlayAgain(View view) {
        StandardAsset.mainActivity.updateQueAndOptions();
        (StandardAsset.mainActivity.getQuestionsScreen()).updateSprites();
        StandardAsset.mainActivity.updateSounds();
        StandardAsset.questionSound.play();
        Score.startTimer();
        finish();
    }

    public void backToMenu(View view) {

        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameWon.this, HomeScreen.class);
        startActivity(intent);
        finish();
    }

    public void showOnLogTimeQuestions(){
        for(int i = 0; i<Score.time_questions.length; i++){
            Log.i(TAG, "Time for quesrion: " + String.valueOf(i) +"is: " + String.valueOf(Score.time_questions[i]));
        }
    }
}
