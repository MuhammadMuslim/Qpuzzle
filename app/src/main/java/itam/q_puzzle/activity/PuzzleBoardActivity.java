package itam.q_puzzle.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linearlistview.LinearListView;

import java.util.ArrayList;
import java.util.List;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.DBhelper.DatabaseHelper;
import itam.q_puzzle.function.Acak;
import itam.q_puzzle.function.indeks;
import itam.q_puzzle.method_engine.Backpropagation;
import itam.q_puzzle.model.BlokKosong;
import itam.q_puzzle.model.Kata;
import itam.q_puzzle.model.Level;
import itam.q_puzzle.model.Settings;
import itam.q_puzzle.model.Surat;

//import indeks;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class PuzzleBoardActivity extends AppCompatActivity {

    TextView timerTextView;
    long startTime = 2000;
    int jumlahSoal, curSoal;
    ImageView selectedImageViewSoal;
    ImageView selectedImageViewJawaban;
    int hasSelectedIVSoal = 0;
    boolean isTrue = false;
    String namaGambarSelected;
    int curLevel, curSurat, curPuzzle, curPosAyat;
    int posJawaban;
    int nilai = 0;
    int bonus = 0;
    int totalNilai = 0;
    int totalWaktu = 0;
    int waktu = 0;
    int isSalah = 0;
    int useBantuan = 0;
    indeks Leveling;
    Backpropagation backpropagation;
    double paramWaktu, paramKesalahan, paramBantuan;
    int nextLevel, nextSurat, nextPuzzle;
    String nilaiNotif;
    TextView nilaiTextView;
    Context context ;
    DatabaseHelper databaseHelper;
    LinearListView linearListAyat;
    LinearListView linearListJawaban;
    Level level = new Level();
    Surat surat = new Surat();
    Settings settingsPuzzle, settingsSurat, settingsLevel, settingsNextPuzzle, settingsNextSurat, settingsNextLevel;
    Settings settingsNilai, settingsWaktu, settingsSalah, settingsBantuan, settingsBonus, settingsTotalNilai, settingsTotalWaktu;
    BlokKosong blokKosong = new BlokKosong();
    Acak acak = new Acak();
    ArrayList<Integer> numBlokKosong;
    List<Kata> listJawaban = new ArrayList<Kata>();
    ImageButton buttonBantuan, buttonsetting;
    ImageView imageSurat;
    CharSequence textToast;
    int durToast = Toast.LENGTH_SHORT;
    Toast toast, tempToast;
    boolean firstToast;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            waktu = seconds;
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%02d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    private BaseAdapter adapterAyat = new BaseAdapter() {

        //    iki digawe ngatur kata
        LinearListView linearListKata;
        List<Kata> listKata;

        private BaseAdapter adapterKata = new BaseAdapter() {

            @Override
            public View getView(final int positionKata, View convertView, ViewGroup parent) {
                if (convertView == null) {

                    convertView = getLayoutInflater().inflate(R.layout.item_list_kata, parent, false);
                    final ImageView imageView = (ImageView) convertView;
                    String namaGambar = "";

                    if(positionKata==0) {
                        namaGambar = "ptkanan";
                    }
                    else if(positionKata==(listKata.size()+1)) {
                        namaGambar = "pn"+curPosAyat;
                    }
                    else if(positionKata==(listKata.size()+2)) {
                        namaGambar = "ptkiri";
                    }
                    else {
                        namaGambar = "p" + listKata.get(positionKata-1).getSrc();
                        convertView.setTag(listKata.get(positionKata-1));

                        if(numBlokKosong.contains(listKata.get(positionKata-1).getNomor())==true) {

                            ((ImageView) convertView).setColorFilter(Color.rgb(204,204,204));
//                            namaGambar = namaGambar + "xx";

                            imageView.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {
                                    if (event.getAction() == MotionEvent.ACTION_UP) {
                                        if(hasSelectedIVSoal==1) {
                                            if(isTrue==true) {
                                                isTrue = false;
                                            }
                                            else {
                                                selectedImageViewSoal.setColorFilter(Color.rgb(204,204,204));
                                            }
                                        }
                                        isTrue = false;
                                        selectedImageViewSoal = imageView;
                                        imageView.setColorFilter(Color.rgb(142,142,142));
                                        hasSelectedIVSoal = 1;
                                        namaGambarSelected = ((Kata)v.getTag()).getSrc();
//                                      Toast.makeText(context, "Click >> " + ((Kata)v.getTag()).getSrc(), Toast.LENGTH_SHORT).show();
                                    }
                                    return false;
                                }
                            });
                        }

                        Log.d("getNomor", listKata.get(positionKata-1).getNomor()+"");
                    }

                    Log.d("namaGambar", namaGambar);

                    ((ImageView) convertView).setImageDrawable(getDrawableByName(namaGambar));

                    if (positionKata == 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        layoutParams.setMarginStart(0);
                        convertView.setLayoutParams(layoutParams);
                    }
                }

                return convertView;
            }

            @Override
            public long getItemId(int positionKata) {
                return positionKata;
            }

            @Override
            public Object getItem(int positionKata) {
                return positionKata;
            }

            @Override
            public int getCount() {
                return (listKata.size()+3);
            }
        };
        //    iki digawe ngatur kata

        @Override
        public View getView(final int positionAyat, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_list_ayat, parent, false);
                curPosAyat = positionAyat+1;
                listKata = databaseHelper.getAllKataByNomorSuratAyat(surat.getNomor(), curPosAyat);//Hardcode
                convertView.setTag(listKata);
                linearListKata = ((LinearListView) convertView);
                linearListKata.setAdapter(adapterKata);
            }
            return convertView;
        }

        @Override
        public long getItemId(int positionAyat) {
            return positionAyat;
        }

        @Override
        public Object getItem(int positionAyat) {
            return positionAyat;
        }

        @Override
        public int getCount() {
            return surat.getAyat();
        }
    };

    private BaseAdapter adapterJawaban = new BaseAdapter() {
        @Override
        public int getCount() {
            return listJawaban.size();
        }

        @Override
        public Object getItem(int positionJawaban) {
            return null;
        }

        @Override
        public long getItemId(int positionJawaban) {
            return 0;
        }

        @Override
        public View getView(final int positionJawaban, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_list_jawaban, parent, false);
                convertView.setTag(listJawaban.get(positionJawaban));
                final ImageView imageView = (ImageView) convertView;

                final String namagambarSrc = listJawaban.get(positionJawaban).getSrc();
                String namaGambar = "p" + namagambarSrc;

                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_UP) {

                            if (hasSelectedIVSoal == 1) {

                                selectedImageViewJawaban = imageView;

                                if (namagambarSrc.equals(namaGambarSelected)) {

//                                Toast.makeText(context, "Click >> " + namagambarSrc + " = " + namaGambarSelected, Toast.LENGTH_SHORT).show();

                                    selectedImageViewSoal.setColorFilter(0);
//                                    selectedImageViewSoal.setImageDrawable(getDrawableByName("p" + namaGambarSelected));
                                    selectedImageViewSoal.setClickable(false);

                                    nilai += 100;
                                    nilaiNotif = "Yeah.. Benar.. [ + 100 ]";
                                    curSoal -= 1;
                                    hasSelectedIVSoal = 0;
                                    isTrue = true;

                                    listJawaban.remove(positionJawaban);
                                    linearListJawaban.setAdapter(adapterJawaban);
                                } else {

                                    if (nilai != 0) {
                                        nilai -= 10;
                                        nilaiNotif = "Ups.. Salah.. [ - 10 ]";
                                        isSalah += 1;
                                    }
                                    else {
                                        nilaiNotif = "Ups.. Salah..";
                                    }
                                }

                                textToast = nilaiNotif;
                                if(!firstToast) {
                                    tempToast.cancel();
                                }
                                toast = Toast.makeText(context, textToast, durToast);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                                tempToast = toast;
                                firstToast = false;
                                toast.show();
//                                Toast.makeText(context, nilaiNotif, Toast.LENGTH_SHORT).show();
                                nilaiTextView.setText("" + nilai);

                                if (curSoal == 0) {
                                    isGameFinished();
                                }
                            }
                        }
                        return false;
                    }
                });

                Log.d("namaGambar", namaGambar);
                Log.d("getNomor", listJawaban.get(positionJawaban).getNomor()+"");
                ((ImageView) convertView).setImageDrawable(getDrawableByName(namaGambar));

                if (positionJawaban == 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMarginStart(0);
                    convertView.setLayoutParams(layoutParams);
                }
            }

            return convertView;
        }
    };

    public void CallMethod(){
        Backpropagation bp = new Backpropagation();
        bp.UpdateWeights();
        bp.start();
        bp.set_delay(60);
        bp.FeedForward();
        bp.get_layers();
        bp.load(namaGambarSelected);
        bp.ActualOutput.clone();
        bp.get_error();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_board);

        context = PuzzleBoardActivity.this;
        firstToast = true;

        timerTextView = (TextView) findViewById(R.id.tV_pzwaktu);
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

        nilaiTextView = (TextView) findViewById(R.id.tV_pznilai);
        imageSurat = (ImageView) findViewById(R.id.iV_pzjudul);

        databaseHelper = new DatabaseHelper(context);

        settingsPuzzle = databaseHelper.getSettings("puzzle");
        settingsSurat = databaseHelper.getSettings("surat");
        settingsLevel = databaseHelper.getSettings("level");
        settingsNextPuzzle = databaseHelper.getSettings("nextpuzzle");
        settingsNextSurat = databaseHelper.getSettings("nextsurat");
        settingsNextLevel = databaseHelper.getSettings("nextlevel");
        settingsTotalNilai = databaseHelper.getSettings("totalnilai");
        settingsTotalWaktu = databaseHelper.getSettings("totalwaktu");
        curPuzzle = settingsPuzzle.getValInt();
        curSurat = settingsSurat.getValInt();
        curLevel = settingsLevel.getValInt();
        nextPuzzle = settingsNextPuzzle.getValInt();
        nextSurat = settingsNextSurat.getValInt();
        nextLevel = settingsNextLevel.getValInt();
        totalNilai = settingsTotalNilai.getValInt();
        totalWaktu = settingsTotalWaktu.getValInt();
        surat = databaseHelper.getSurat(curSurat);//Hardcode
        blokKosong = databaseHelper.getBlokKosong(curSurat, curLevel);
        level = databaseHelper.getLevel(curLevel);
        jumlahSoal = blokKosong.getBlank();
        curSoal = jumlahSoal;
        numBlokKosong = acak.getAcakBlok(surat.getKata(), blokKosong.getBlank(), level.getMaxRow());

        imageSurat.setImageDrawable(getDrawableByName("pzjd"+curSurat));



        Log.d("Num Kata: ", ""+surat.getKata());
        Log.d("Num Blank: ", ""+blokKosong.getBlank());
        Log.d("Num Max Row: ", ""+level.getMaxRow());
        Log.d("Num Blok Kosong: ", ""+numBlokKosong.size());

        for(int a : acak.getArrayAcak()) {
            Log.d("arraylist acak: ", String.valueOf(a));
        }

        List<Kata> listJawabanTemp;
        for(int b : numBlokKosong) {
            listJawabanTemp = databaseHelper.getKataByNomorSuratNomor(settingsSurat.getValInt(), b);
            listJawaban.add(listJawabanTemp.get(0));
            Log.d("arraylist blok: ", String.valueOf(b));
        }

        linearListAyat = (LinearListView) findViewById(R.id.linearListAyat);
        linearListAyat.setAdapter(adapterAyat);

        linearListJawaban = (LinearListView) findViewById(R.id.linearListJawaban);
        linearListJawaban.setAdapter(adapterJawaban);

        buttonsetting = (ImageButton) findViewById(R.id.iB_pzmenu);
        buttonsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PuzzleBoardActivity.this, SetPemainActivity.class);
                startActivity(i);
            }
        });

        buttonBantuan = (ImageButton) findViewById(R.id.iB_pzbantuan);
        buttonBantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hasSelectedIVSoal==1) {
                    selectedImageViewSoal.setColorFilter(0);
//                    selectedImageViewSoal.setImageDrawable(getDrawableByName("p" + namaGambarSelected));
                    selectedImageViewSoal.setClickable(false);

                    curSoal -= 1;
                    useBantuan += 1;
                    hasSelectedIVSoal = 0;

                    textToast = "Bantuan digunakan..";
                    if(!firstToast) {
                        tempToast.cancel();
                    }
                    toast = Toast.makeText(context, textToast, durToast);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    tempToast = toast;
                    firstToast = false;
                    toast.show();
                    //Toast.makeText(context, "Bantuan digunakan..", Toast.LENGTH_SHORT).show();

                    listJawaban.remove(getIdListJawaban(listJawaban, namaGambarSelected));
                    linearListJawaban.setAdapter(adapterJawaban);

                    if (curSoal == 0) {
                        isGameFinished();
                    }
                }
            }
        });
    }

    private int getIdListJawaban(List<Kata> listJawaban, String namaGambarSelected) {

        int id = 0;

        for(int a=0; a<listJawaban.size(); a++) {

            if(listJawaban.get(a).getSrc().equals(namaGambarSelected)) {

                id = a;
                break;
            }
        }

        return id;
    }

    private Drawable getDrawableByName(String name) {
        Log.d("getDrawableByName", name);
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }

    private void isGameFinished() {

        timerHandler.removeCallbacks(timerRunnable);

        tempToast.cancel();
        textToast = "Puzzle selesai.. Selamat..!!";
        toast = Toast.makeText(context, textToast, durToast);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        tempToast = toast;
        firstToast = false;
        toast.show();

        if(curLevel==3) {

            if(curPuzzle!=15) {
                paramWaktu = (double) waktu / jumlahSoal;
                paramKesalahan = (double) isSalah / (jumlahSoal + isSalah);
                paramBantuan = (double) useBantuan / jumlahSoal;

                Log.d("paramWaktu: ", paramWaktu + " = " + waktu + "/" + jumlahSoal);
                Log.d("paramKesalahan: ", paramKesalahan + " = " + isSalah + "/(" + jumlahSoal + "+" + isSalah + ")");
                Log.d("paramBantuan: ", paramBantuan + " = " + useBantuan + "/" + jumlahSoal);

                Leveling = new indeks();
                nextLevel = Leveling.getLevel(paramWaktu, paramKesalahan, paramBantuan);
                nextPuzzle = curPuzzle + 1;
                nextSurat = curSurat - 1;

                nextPuzzle = curPuzzle + 1;
                nextSurat = curSurat - 1;

                for (int a = 1; a < nextLevel; a++) {

                    bonus += (databaseHelper.getBlokKosong(nextSurat, a).getBlank() * 100);
                }
            }
        }
        else {

            nextLevel = curLevel+1;
        }

        totalNilai = totalNilai+nilai+bonus;
        totalWaktu = totalWaktu+waktu;

        settingsNilai = new Settings("nilai", nilai);
        settingsWaktu = new Settings("waktu", waktu);
        settingsSalah = new Settings("salah", isSalah);
        settingsBantuan = new Settings("bantuan", useBantuan);
        settingsBonus = new Settings("bonus", bonus);
        settingsTotalNilai = new Settings("totalnilai", totalNilai);
        settingsTotalWaktu = new Settings("totalwaktu", totalWaktu);

        databaseHelper.updateSettings(settingsNilai);
        databaseHelper.updateSettings(settingsWaktu);
        databaseHelper.updateSettings(settingsSalah);
        databaseHelper.updateSettings(settingsBantuan);
        databaseHelper.updateSettings(settingsBonus);
        databaseHelper.updateSettings(settingsTotalNilai);
        databaseHelper.updateSettings(settingsTotalWaktu);

        if(curPuzzle!=15||curLevel!=3) {
            settingsNextLevel = new Settings("nextlevel", nextLevel);
            settingsNextPuzzle = new Settings("nextpuzzle", nextPuzzle);
            settingsNextSurat = new Settings("nextsurat", nextSurat);

            databaseHelper.updateSettings(settingsNextLevel);
            databaseHelper.updateSettings(settingsNextPuzzle);
            databaseHelper.updateSettings(settingsNextSurat);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                tempToast.cancel();

                Intent intent = new Intent(context, NilaiPermainanActivity.class);
                startActivity(intent);

                finish();
            }
        }, 2000);
    }


}
