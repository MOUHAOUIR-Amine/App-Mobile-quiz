package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.utils.Globals;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NiveauArabicActivity extends AppCompatActivity {

    Button a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StandardAsset.currentLanguage = 1;

        setContentView(R.layout.activity_niveau_arabic);
        a=(Button)findViewById(R.id.premniv);
        b=(Button)findViewById(R.id.deuxniv);
        c=(Button)findViewById(R.id.troiniv);
        d=(Button)findViewById(R.id.quatniv);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 5;
                //Score.game.setLevel_id("ArabicQui");
                Globals g = Globals.getInstance();
                g.setData(5);
                Intent aa = new Intent(NiveauArabicActivity.this,InitializerActivity.class);
                startActivity(aa);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 6;
                //Score.game.setLevel_id("ArabicOù");
                //Score.gameStat.setLevel_id("1");
                Globals g = Globals.getInstance();
                g.setData(6);
                Intent bb = new Intent(NiveauArabicActivity.this,InitializerActivity.class);
                startActivity(bb);
                finish();

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 7;
                //Score.game.setLevel_id("ArabicQuoi");
                Globals g = Globals.getInstance();
                g.setData(7);
                Intent cc = new Intent(NiveauArabicActivity.this,InitializerActivity.class);
                startActivity(cc);
                finish();

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 8;
                //Score.game.setLevel_id("ArabicQui,Où,Quoi");
                Globals g = Globals.getInstance();
                g.setData(8);
                Intent dd = new Intent(NiveauArabicActivity.this,InitializerActivity.class);
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
