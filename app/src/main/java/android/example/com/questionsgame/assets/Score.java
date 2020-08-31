package android.example.com.questionsgame.assets;

import android.app.Dialog;
import android.example.com.questionsgame.MainActivity;
import android.example.com.questionsgame.R;
import android.example.com.questionsgame.database.GameAsset;
import android.example.com.questionsgame.database.Game_Database_Handler;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.sql.Time;

public class Score {
    public static int record = 0;

    public static Game_Database_Handler game_database_handler;

    public static Long id_game;

    public static int time_questions [] = new int[10];

    public static int level_id;

    public static int rankCurrentQuestion;

    public static int successful_attempts=0;

    public static int failed_attempts=0;

    private static boolean timmerIsStopperd = false;

    public static int countTimmer = 0;

    public static void initializeTimeQuestionsArray(){
        for(int i = 0; i<time_questions.length; i++){
            time_questions[i] = 0;
        }
    }

    public static void startTimer(){
        stopTimmer();
        countTimmer = 0;
        timmerIsStopperd = false;

        new Thread() {
            public void run() {  // We use a different thread because if we don't we will get an error de sorte: concurrent Access
                while(!timmerIsStopperd){
                    try {
                        Thread.sleep(1000);
                        countTimmer ++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return;
    }

    public static void stopTimmer(){
        timmerIsStopperd = true;
    }

}
