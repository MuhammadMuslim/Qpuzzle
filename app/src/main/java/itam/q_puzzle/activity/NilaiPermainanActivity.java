package itam.q_puzzle.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.DBhelper.DatabaseHelper;
import itam.q_puzzle.function.Waktu;
import itam.q_puzzle.model.Nilai;
import itam.q_puzzle.model.Settings;

/**
 * Created by M. ROMADLONI on 22-06-2016.
 */
public class NilaiPermainanActivity extends AppCompatActivity {

    Settings settingsNew, settingsPuzzle, settingsSurat, settingsLevel, settingsNextPuzzle, settingsNextSurat, settingsNextLevel;
    Settings settingsNilai, settingsWaktu, settingsSalah, settingsBantuan, settingsBonus, settingsTotalNilai, settingsTotalWaktu;
    Settings settingsNamaPemain;
    Context context;
    DatabaseHelper databaseHelper;
    int curLevel, curSurat, curPuzzle, nextLevel, nextSurat, nextPuzzle;
    int nilai, waktu, salah, bantuan, bonus, totalNilai, totalWaktu;
    ImageView imageSurat, imageLevel, imageNext, imageNextPuzzle, imageNextLevel;
    TextView textNilaiTotal, textNilai, textWaktu, textSalah, textBantuan, textBonus, textTotalNilai, textTotalWaktu;
    ImageButton buttonNext;
    Waktu waktuClass;
    Nilai nilaiClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai_permainan);

        context = NilaiPermainanActivity.this;
        databaseHelper = new DatabaseHelper(context);
        waktuClass = new Waktu();

        settingsNamaPemain = databaseHelper.getSettings("namapemain");
        settingsPuzzle = databaseHelper.getSettings("puzzle");
        settingsSurat = databaseHelper.getSettings("surat");
        settingsLevel = databaseHelper.getSettings("level");
        settingsNextPuzzle = databaseHelper.getSettings("nextpuzzle");
        settingsNextSurat = databaseHelper.getSettings("nextsurat");
        settingsNextLevel = databaseHelper.getSettings("nextlevel");
        settingsNilai = databaseHelper.getSettings("nilai");
        settingsWaktu = databaseHelper.getSettings("waktu");
        settingsSalah = databaseHelper.getSettings("salah");
        settingsBantuan = databaseHelper.getSettings("bantuan");
        settingsBonus = databaseHelper.getSettings("bonus");
        settingsTotalNilai = databaseHelper.getSettings("totalnilai");
        settingsTotalWaktu = databaseHelper.getSettings("totalwaktu");
        curPuzzle = settingsPuzzle.getValInt();
        curSurat = settingsSurat.getValInt();
        curLevel = settingsLevel.getValInt();
        if(curPuzzle!=10||curLevel!=3) {
            nextPuzzle = settingsNextPuzzle.getValInt();
            nextSurat = settingsNextSurat.getValInt();
            nextLevel = settingsNextLevel.getValInt();
        }
        nilai = settingsNilai.getValInt();
        waktu = settingsWaktu.getValInt();
        salah = settingsSalah.getValInt();
        bantuan = settingsBantuan.getValInt();
        bonus = settingsBonus.getValInt();
        totalNilai = settingsTotalNilai.getValInt();
        totalWaktu = settingsTotalWaktu.getValInt();

        imageSurat = (ImageView) findViewById(R.id.iV_npsurat);
        imageLevel = (ImageView) findViewById(R.id.iV_nplevel);
        imageNext = (ImageView) findViewById(R.id.iV_npselanjutnya);
        imageNextPuzzle = (ImageView) findViewById(R.id.iV_nppuzzleselanjutnya);
        imageNextLevel = (ImageView) findViewById(R.id.iV_nplevelselanjutnya);
        textNilaiTotal = (TextView) findViewById(R.id.tV_npnilaitotal);
        textNilai = (TextView) findViewById(R.id.tV_npnilai);
        textWaktu = (TextView) findViewById(R.id.tV_npwaktu);
        textSalah = (TextView) findViewById(R.id.tV_npsalah);
        textBantuan = (TextView) findViewById(R.id.tV_npbantuan);
        textBonus = (TextView) findViewById(R.id.tV_npbonus);
        textTotalNilai = (TextView) findViewById(R.id.tV_nptotalnilai);
        textTotalWaktu = (TextView) findViewById(R.id.tV_nptotalwaktu);

        imageSurat.setImageDrawable(getDrawableByName("npsurat"+curSurat));
        imageLevel.setImageDrawable(getDrawableByName("nplevel"+curLevel));
        if(curPuzzle!=10||curLevel!=3) {
            imageNextPuzzle.setImageDrawable(getDrawableByName("nppuzzleselanjutnya" + nextPuzzle));
            imageNextLevel.setImageDrawable(getDrawableByName("nplevelselanjutnya" + nextLevel));
        }
        else {
            imageNext.setVisibility(View.INVISIBLE);
            imageNextPuzzle.setVisibility(View.INVISIBLE);
            imageNextLevel.setVisibility(View.INVISIBLE);
        }
        textNilaiTotal.setText(""+(nilai+bonus));
        textNilai.setText(""+nilai);
        textWaktu.setText(waktuClass.getWaktuMenit(waktu));
        textSalah.setText(""+salah);
        textBantuan.setText(""+bantuan);
        textBonus.setText(""+bonus);
        textTotalNilai.setText(""+totalNilai);
        textTotalWaktu.setText(waktuClass.getWaktuJam(totalWaktu));

        if(curPuzzle!=10||curLevel!=3) {

            settingsNew = new Settings("new", 0);
            settingsPuzzle = new Settings("puzzle", nextPuzzle);
            settingsSurat = new Settings("surat", nextSurat);
            settingsLevel = new Settings("level", nextLevel);
            databaseHelper.updateSettings(settingsNew);
            databaseHelper.updateSettings(settingsPuzzle);
            databaseHelper.updateSettings(settingsSurat);
            databaseHelper.updateSettings(settingsLevel);
        }
        else {
            nilaiClass = new Nilai(settingsNamaPemain.getValString(), totalNilai, totalWaktu);
            long nilaiClass_id = databaseHelper.createNilai(nilaiClass);
            Log.d("Nilai Count", "Nilai Count: " + databaseHelper.getAllNilai().size());
            settingsNew = new Settings("new", 1);
            databaseHelper.updateSettings(settingsNew);
        }

        buttonNext = (ImageButton) findViewById(R.id.iB_npselanjutnya);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(curPuzzle!=10||curLevel!=3) {

                    Intent intent = new Intent(context, LoadingScreenActivity.class);
                    startActivity(intent);
                }
                else {

                    Intent intent = new Intent(context, PapanNilaiActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        });
    }


    private Drawable getDrawableByName(String name) {
        Log.d("getDrawableByName", name);
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }
}