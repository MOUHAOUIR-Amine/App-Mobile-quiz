package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.assets.StandardAsset;
import android.example.com.questionsgame.utils.Globals;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NiveauFrançaisActivity extends AppCompatActivity {

    Button a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StandardAsset.currentLanguage = 2;

        setContentView(R.layout.activity_niveau_francais);
        a=(Button)findViewById(R.id.premnivfr);
        b=(Button)findViewById(R.id.deuxnivfr);
        c=(Button)findViewById(R.id.troinivfr);
        d=(Button)findViewById(R.id.quatnivfr);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 1;
                //Score.game.setLevel_id("FrançaisQui");
                //Score.gameStat.setLevel_id("0");
                Globals g = Globals.getInstance();
                g.setData(1);
                Intent aa = new Intent(NiveauFrançaisActivity.this,InitializerActivity.class);
                startActivity(aa);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 2;
                //Score.game.setLevel_id("FrançaisOù");
                Globals g = Globals.getInstance();
                g.setData(2);
                Intent bb = new Intent(NiveauFrançaisActivity.this,InitializerActivity.class);
                startActivity(bb);
                finish();

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 3;
                //Score.game.setLevel_id("FrançaisQuoi");
                //Score.gameStat.setLevel_id("2");
                Globals g = Globals.getInstance();
                g.setData(3);
                Intent cc = new Intent(NiveauFrançaisActivity.this,InitializerActivity.class);
                startActivity(cc);
                finish();

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.level_id = 4;
                //Score.game.setLevel_id("FrançaisQui,Où,Quoi");
                //Score.gameStat.setLevel_id("3");
                Globals g = Globals.getInstance();
                g.setData(4);
                Intent dd = new Intent(NiveauFrançaisActivity.this,InitializerActivity.class);
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
