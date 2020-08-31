package android.example.com.questionsgame;

import android.content.Intent;
import android.example.com.questionsgame.assets.Score;
import android.example.com.questionsgame.utils.Globals;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoixLangue extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button a,b,c;
        setContentView(R.layout.activity_choix_langue);
        a=(Button)findViewById(R.id.arabe);
        b=(Button)findViewById(R.id.français);
        c=(Button)findViewById(R.id.english);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(ChoixLangue.this,NiveauArabicActivity.class);
                startActivity(aa);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bb = new Intent(ChoixLangue.this,NiveauFrançaisActivity.class);
                startActivity(bb);
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cc = new Intent(ChoixLangue.this, NiveauEnglishActivity.class);
                startActivity(cc);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent cc = new Intent(ChoixLangue.this, HomeScreen.class);
        startActivity(cc);
        finish();
    }
}
