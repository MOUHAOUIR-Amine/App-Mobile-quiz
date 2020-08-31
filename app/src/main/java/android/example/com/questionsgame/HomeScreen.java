package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.StandardAsset;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class HomeScreen extends AppCompatActivity {

    ImageView playGame,quit,param;
    TextView tQ;
    MediaPlayer mp = new MediaPlayer();
    private static final String TAG = "HomeScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        playGame =(ImageView) findViewById(R.id.playGame);
        tQ = (TextView)findViewById(R.id.tQ);

        param =(ImageView) findViewById(R.id.setting) ;

        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)   {
                Intent intent = new Intent(HomeScreen.this,NiveauArabicActivity.class);
                mp = MediaPlayer.create(getApplicationContext(), R.raw.bonjour);
                mp.start();
                startActivity(intent);
                finish();
            }
        });
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)   {
                Intent intent = new Intent(HomeScreen.this,ChoixLangue.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(StandardAsset.mainActivity != null) StandardAsset.mainActivity.exitGame();
        StandardAsset.exited = true;
        finish();
    }
}
