package id.mromadloni.q_puzzle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Setting_Help extends AppCompatActivity {

    private TextView mTextMessage, ket1,ket2,ket3,ket4;
    private ImageView mimageView,mimageView2,mimageView3,mimageView4;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    mimageView = (ImageView) findViewById(R.id.mimageView);
                    mimageView.setImageResource(R.drawable.mubtmulai);
                    mimageView2 = (ImageView) findViewById(R.id.mimageView2);
                    mimageView2.setImageResource(R.drawable.mubtpengaturan);
                    mimageView3 = (ImageView) findViewById(R.id.mimageView3);
                    mimageView3.setImageResource(R.drawable.mubtpapannilai);
                    mimageView4 = (ImageView) findViewById(R.id.mimageView4);
                    mimageView4.setImageResource(R.drawable.mubtkeluar);
                    ket1.setText(R.string.ket1menu);
                    ket2.setText(R.string.ket2menu);
                    ket3.setText(R.string.ket3menu);
                    ket4.setText(R.string.ket4menu);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    mimageView = (ImageView) findViewById(R.id.mimageView);
                    mimageView.setImageResource(R.drawable.mnbr);
                    mimageView2 = (ImageView) findViewById(R.id.mimageView2);
                    mimageView2.setImageResource(R.drawable.lnjt);
                    mimageView3 = (ImageView) findViewById(R.id.mimageView3);
                    mimageView3.setImageResource(R.drawable.mubtpengaturan);
                    mimageView4 = (ImageView) findViewById(R.id.mimageView4);
                    mimageView4.setImageResource(R.drawable.pzbantuan);
                    ket1.setText(R.string.ket1main);
                    ket2.setText(R.string.ket2main);
                    ket3.setText(R.string.ket3main);
                    ket4.setText(R.string.ket4main);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    mimageView = (ImageView) findViewById(R.id.mimageView);
                    mimageView.setImageResource(R.drawable.nplevelselanjutnya1);
                    mimageView2 = (ImageView) findViewById(R.id.mimageView2);
                    mimageView2.setImageResource(R.drawable.nplevelselanjutnya2);
                    mimageView3 = (ImageView) findViewById(R.id.mimageView3);
                    mimageView3.setImageResource(R.drawable.nplevelselanjutnya3);
                    mimageView4 = (ImageView) findViewById(R.id.mimageView4);
                    mimageView4.setImageResource(R.drawable.npbonus);
                    ket1.setText(R.string.ket1ting);
                    ket2.setText(R.string.ket2ting);
                    ket3.setText(R.string.ket3ting);
                    ket4.setText(R.string.ket4ting);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting__help);

        ket1 = (TextView) findViewById(R.id.ket1);
        ket2 = (TextView) findViewById(R.id.ket2);
        ket3 = (TextView) findViewById(R.id.ket3);
        ket4 = (TextView) findViewById(R.id.ket4);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
