package itam.q_puzzle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.helper.DatabaseHelper;
import itam.q_puzzle.helper.Waktu;
import itam.q_puzzle.model.Level;
import itam.q_puzzle.model.Settings;
import itam.q_puzzle.model.Surat;

/**
 * Created by M. ROMADLONI on 30-06-2016.
 */
public class SetPemainActivity extends AppCompatActivity {

    Context context;
    DatabaseHelper dH;

    Settings settingsNew, settingsPuzzle, settingsSurat, settingsLevel, settingsNextPuzzle, settingsNextSurat, settingsNextLevel;
    Settings settingsNilai, settingsWaktu, settingsSalah, settingsBantuan, settingsBonus, settingsTotalNilai, settingsTotalWaktu;
    Settings settingsNamaPemain;
    Surat surat;
    Level level;
    Waktu waktuClass;

    int isNew;

    TextView tvNamaPemain, tvPuzzle, tvLevel, tvNilaiWaktu;
    EditText etNamaPemain;
    Button btMulaiBaru, btMelanjutkan, btKembali, btBatal, btMulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pemain);

        context = SetPemainActivity.this;
        dH = new DatabaseHelper(context);

        tvNamaPemain = (TextView) findViewById(R.id.tV_spnamapemain);
        tvPuzzle = (TextView) findViewById(R.id.tV_sppuzzle);
        tvLevel = (TextView) findViewById(R.id.tV_splevel);
        tvNilaiWaktu = (TextView) findViewById(R.id.tV_spnilaiwaktu);
        etNamaPemain = (EditText) findViewById(R.id.eT_spnamapemain);
        btMulaiBaru = (Button) findViewById(R.id.bt_spmulaibaru);
        btMelanjutkan = (Button) findViewById(R.id.bt_spmelanjutkan);
        btKembali = (Button) findViewById(R.id.bt_spkembali);
        btBatal = (Button) findViewById(R.id.bt_spbatal);
        btMulai = (Button) findViewById(R.id.bt_spmulai);

        etNamaPemain.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(10)});
        etNamaPemain.setVisibility(View.GONE);
        btMulai.setEnabled(false);
        btMulai.setVisibility(View.GONE);
        btBatal.setVisibility(View.GONE);

        settingsNew = dH.getSettings("new");
        isNew = settingsNew.getValInt();

        if(isNew==1) {

            btMelanjutkan.setEnabled(false);
            tvNamaPemain.setVisibility(View.GONE);
            tvPuzzle.setVisibility(View.GONE);
            tvLevel.setVisibility(View.GONE);
            tvNilaiWaktu.setVisibility(View.GONE);
        }
        else {

            waktuClass = new Waktu();

            settingsNamaPemain = dH.getSettings("namapemain");
            settingsNextPuzzle = dH.getSettings("nextpuzzle");
            settingsNextSurat = dH.getSettings("nextsurat");
            settingsNextLevel = dH.getSettings("nextlevel");
            settingsTotalNilai = dH.getSettings("totalnilai");
            settingsTotalWaktu = dH.getSettings("totalwaktu");

            surat = dH.getSurat(settingsNextSurat.getValInt());
            level = dH.getLevel(settingsNextLevel.getValInt());

            tvNamaPemain.setText(settingsNamaPemain.getValString());
            tvPuzzle.setText("PUZZLE "+settingsNextPuzzle.getValInt()+" : "+surat.getNama());
            tvLevel.setText(""+level.getNama());
            tvNilaiWaktu.setText(settingsTotalNilai.getValInt()+" | "+waktuClass.getWaktuJam(settingsTotalWaktu.getValInt()));
        }

        btMulaiBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btMulaiBaru.setVisibility(View.GONE);
                btMelanjutkan.setVisibility(View.GONE);
                tvNamaPemain.setVisibility(View.GONE);
                tvPuzzle.setVisibility(View.GONE);
                tvLevel.setVisibility(View.GONE);
                tvNilaiWaktu.setVisibility(View.GONE);
                btKembali.setVisibility(View.GONE);
                etNamaPemain.setVisibility(View.VISIBLE);
                btBatal.setVisibility(View.VISIBLE);
                btMulai.setVisibility(View.VISIBLE);
            }
        });

        btMelanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, LoadingScreenActivity.class);
                startActivity(intent);

                finish();
            }
        });



        btKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        btMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsNamaPemain = new Settings("namapemain", etNamaPemain.getText().toString());
                settingsNew = new Settings("new", 1);
                settingsPuzzle = new Settings("puzzle", 1);
                settingsSurat = new Settings("surat", 114);
                settingsLevel = new Settings("level", 1);
                settingsNilai = new Settings("nilai", 0);
                settingsWaktu = new Settings("waktu", 0);
                settingsSalah = new Settings("salah", 0);
                settingsBantuan = new Settings("bantuan", 0);
                settingsBonus = new Settings("bonus", 0);
                settingsTotalNilai = new Settings("totalnilai", 0);
                settingsTotalWaktu = new Settings("totalwaktu", 0);
                settingsNextLevel = new Settings("nextlevel", 1);
                settingsNextPuzzle = new Settings("nextpuzzle", 1);
                settingsNextSurat = new Settings("nextsurat", 114);

                dH.updateSettings(settingsNamaPemain);
                dH.updateSettings(settingsNew);
                dH.updateSettings(settingsLevel);
                dH.updateSettings(settingsPuzzle);
                dH.updateSettings(settingsSurat);
                dH.updateSettings(settingsNilai);
                dH.updateSettings(settingsWaktu);
                dH.updateSettings(settingsSalah);
                dH.updateSettings(settingsBantuan);
                dH.updateSettings(settingsBonus);
                dH.updateSettings(settingsTotalNilai);
                dH.updateSettings(settingsTotalWaktu);
                dH.updateSettings(settingsNextLevel);
                dH.updateSettings(settingsNextPuzzle);
                dH.updateSettings(settingsNextSurat);

                Intent intent = new Intent(context, LoadingScreenActivity.class);
                startActivity(intent);

                finish();
            }
        });

        btBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etNamaPemain.setVisibility(View.GONE);
                btBatal.setVisibility(View.GONE);
                btMulai.setVisibility(View.GONE);
                btMulaiBaru.setVisibility(View.VISIBLE);
                btMelanjutkan.setVisibility(View.VISIBLE);
                tvNamaPemain.setVisibility(View.VISIBLE);
                tvPuzzle.setVisibility(View.VISIBLE);
                tvLevel.setVisibility(View.VISIBLE);
                tvNilaiWaktu.setVisibility(View.VISIBLE);
                btKembali.setVisibility(View.VISIBLE);
            }
        });

        etNamaPemain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(String.valueOf(s).equals("")) {

                    btMulai.setEnabled(false);
                }
                else {
                    btMulai.setEnabled(true);
                }
            }
        });
    }
}
