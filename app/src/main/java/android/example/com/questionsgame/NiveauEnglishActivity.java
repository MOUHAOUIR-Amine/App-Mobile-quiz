package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.utils.Globals;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NiveauEnglishActivity extends AppCompatActivity {

    Button a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StandardAsset.currentLanguage = 3;

        setContentView(R.layout.activity_niveau_english);
        a=(Button)findViewById(R.id.premniven);
        b=(Button)findViewById(R.id.deuxniven);
        c=(Button)findViewById(R.id.troiniven);
        d=(Button)findViewById(R.id.quatniven);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 9;
                //Score.game.setLevel_id("EnglishQui");
                //Score.gameStat.setLevel_id("0");
                Globals g = Globals.getInstance();
                g.setData(9);
                Intent aa = new Intent(NiveauEnglishActivity.this,InitializerActivity.class);
                startActivity(aa);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 10;
                //Score.game.setLevel_id("EnglishOù");
                //Score.gameStat.setLevel_id("1");
                Globals g = Globals.getInstance();
                g.setData(10);
                Intent bb = new Intent(NiveauEnglishActivity.this,InitializerActivity.class);
                startActivity(bb);
                finish();

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 11;
                //Score.game.setLevel_id("EnglishQuoi");
                //Score.gameStat.setLevel_id("2");
                Globals g = Globals.getInstance();
                g.setData(11);
                Intent cc = new Intent(NiveauEnglishActivity.this,InitializerActivity.class);
                startActivity(cc);
                finish();

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 12;
                //Score.game.setLevel_id("EnglishQui,Où,Quoi");
                //Score.gameStat.setLevel_id("3");
                Globals g = Globals.getInstance();
                g.setData(12);
                Intent dd = new Intent(NiveauEnglishActivity.this,InitializerActivity.class);
                startActivity(dd);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }
}
