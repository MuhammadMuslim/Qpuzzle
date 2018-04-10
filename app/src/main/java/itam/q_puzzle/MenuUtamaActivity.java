package itam.q_puzzle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import id.mromadloni.q_puzzle.R;

public class MenuUtamaActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        context = MenuUtamaActivity.this;

        ImageButton IBMulai = (ImageButton) findViewById(R.id.iBt_mulai);
        IBMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SetPemainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton IBPapanNilai = (ImageButton) findViewById(R.id.iBt_papannilai);
        IBPapanNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PapanNilaiActivity.class);
                startActivity(intent);
            }
        });
    }
}
