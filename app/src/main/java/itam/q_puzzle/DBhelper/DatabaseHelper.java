package itam.q_puzzle.DBhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import itam.q_puzzle.model.BlokKosong;
import itam.q_puzzle.model.Kata;
import itam.q_puzzle.model.Level;
import itam.q_puzzle.model.Nilai;
import itam.q_puzzle.model.Settings;
import itam.q_puzzle.model.Surat;

/**
 * Created by M. ROMADLONI on 18-06-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 10;

    // Database Name
    private static final String DATABASE_NAME = "qPuzzle";

    // Table Names
    private static final String TABLE_SURAT = "surat";
    private static final String TABLE_LEVEL = "level";
    private static final String TABLE_KATA = "kata";
    private static final String TABLE_BLOK_KOSONG = "blok_kosong";
    private static final String TABLE_SETTINGS = "settings";
    private static final String TABLE_NILAI = "nilai";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_NOMOR = "nomor";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_AYAT = "ayat";
    private static final String KEY_KATA = "kata";
    private static final String KEY_SURAT_NOMOR = "surat_nomor";

    // SURAT Table - column names
    private static final String KEY_PUZZLE = "puzzle";

    // LEVEL Table - column names
    private static final String KEY_MAX_ROW = "max_row";

    // KATA Table - column names
    private static final String KEY_SRC = "src";

    // BLOK_KOSONG Table - column names
    private static final String KEY_LEVEL_ID = "level_id";
    private static final String KEY_BLANK = "blank";

    // SETTINGS Table - column names
    private static final String KEY_PARAM = "param";
    private static final String KEY_VAL_INT = "val_int";
    private static final String KEY_VAL_STRING = "val_string";

    // NILAI Table - column names
    private static final String KEY_NILAI = "nilai";
    private static final String KEY_WAKTU = "waktu";

    // Table Create Statements
    // SURAT Table create statement
    private static final String CREATE_TABLE_SURAT = "CREATE TABLE IF NOT EXISTS " + TABLE_SURAT + "("
            + KEY_NOMOR + " INTEGER PRIMARY KEY,"
            + KEY_NAMA + " TEXT,"
            + KEY_AYAT + " INTEGER,"
            + KEY_KATA + " INTEGER,"
            + KEY_PUZZLE + " INTEGER"
            + ")";

    // LEVEL Table create statement
    private static final String CREATE_TABLE_LEVEL = "CREATE TABLE IF NOT EXISTS " + TABLE_LEVEL + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAMA + " TEXT,"
            + KEY_MAX_ROW + " INTEGER"
            + ")";

    // KATA Table create statement
    private static final String CREATE_TABLE_KATA = "CREATE TABLE IF NOT EXISTS " + TABLE_KATA + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_SURAT_NOMOR + " INTEGER,"
            + KEY_AYAT + " INTEGER,"
            + KEY_KATA + " INTEGER,"
            + KEY_SRC + " TEXT,"
            + KEY_NOMOR + " INTEGER"
            + ")";

    // BLOK_KOSONG Table create statement
    private static final String CREATE_TABLE_BLOK_KOSONG = "CREATE TABLE IF NOT EXISTS " + TABLE_BLOK_KOSONG + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_SURAT_NOMOR + " INTEGER,"
            + KEY_LEVEL_ID + " INTEGER,"
            + KEY_BLANK + " INTEGER"
            + ")";

    // SETTINGS Table create statement
    private static final String CREATE_TABLE_SETTINGS = "CREATE TABLE IF NOT EXISTS " + TABLE_SETTINGS + "("
            + KEY_PARAM + " TEXT PRIMARY KEY,"
            + KEY_VAL_INT + " INTEGER,"
            + KEY_VAL_STRING + " TEXT"
            + ")";

    // NILAI Table create statement
    private static final String CREATE_TABLE_NILAI = "CREATE TABLE IF NOT EXISTS " + TABLE_NILAI + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + KEY_NAMA + " TEXT,"
            + KEY_NILAI + " INTEGER,"
            + KEY_WAKTU + " INTEGER"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_SURAT);
        db.execSQL(CREATE_TABLE_LEVEL);
        db.execSQL(CREATE_TABLE_KATA);
        db.execSQL(CREATE_TABLE_BLOK_KOSONG);
        db.execSQL(CREATE_TABLE_SETTINGS);
        db.execSQL(CREATE_TABLE_NILAI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SURAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEVEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BLOK_KOSONG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETTINGS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NILAI);

        // create new tables
        onCreate(db);
    }

    /*
    * Creating a SURAT
    */
    public long createSurat(Surat surat) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR, surat.getNomor());
        values.put(KEY_NAMA, surat.getNama());
        values.put(KEY_AYAT, surat.getAyat());
        values.put(KEY_KATA, surat.getKata());
        values.put(KEY_PUZZLE, surat.getPuzzle());

        // insert row
        long surat_id = db.insert(TABLE_SURAT, null, values);

        return surat_id;
    }

    /*
    * get single SURAT
    */
    public Surat getSurat(int surat_nomor) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_SURAT + " WHERE "
                + KEY_NOMOR + " = " + surat_nomor;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Surat sr = new Surat();
        sr.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));
        sr.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
        sr.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
        sr.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
        sr.setPuzzle(c.getInt(c.getColumnIndex(KEY_PUZZLE)));

        return sr;
    }

    /*
    * getting all SURAT
    * */
    public List<Surat> getAllSurat() {
        List<Surat> surats = new ArrayList<Surat>();
        String selectQuery = "SELECT * FROM " + TABLE_SURAT + " ORDER BY " + KEY_PUZZLE + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Surat sr = new Surat();
                sr.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));
                sr.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                sr.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
                sr.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
                sr.setPuzzle(c.getInt(c.getColumnIndex(KEY_PUZZLE)));

                // adding to SURAT list
                surats.add(sr);
            } while (c.moveToNext());
        }

        return surats;
    }

    /*
    * Creating a LEVEL
    */
    public long createLevel(Level level) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, level.getId());
        values.put(KEY_NAMA, level.getNama());
        values.put(KEY_MAX_ROW, level.getMaxRow());

        // insert row
        long level_id = db.insert(TABLE_LEVEL, null, values);

        return level_id;
    }

    /*
    * get single LEVEL
    */
    public Level getLevel(int level_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_LEVEL + " WHERE "
                + KEY_ID + " = " + level_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Level lv = new Level();
        lv.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        lv.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
        lv.setMaxRow(c.getInt(c.getColumnIndex(KEY_MAX_ROW)));

        return lv;
    }

    /*
    * getting all LEVEL
    * */
    public List<Level> getAllLevel() {
        List<Level> levels = new ArrayList<Level>();
        String selectQuery = "SELECT * FROM " + TABLE_LEVEL + " ORDER BY " + KEY_ID + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Level lv = new Level();
                lv.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                lv.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                lv.setMaxRow(c.getInt(c.getColumnIndex(KEY_MAX_ROW)));

                // adding to LEVEL list
                levels.add(lv);
            } while (c.moveToNext());
        }

        return levels;
    }

    /*
    * Creating a KATA
    */
    public long createKata(Kata kata) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, kata.getId());
        values.put(KEY_SURAT_NOMOR, kata.getSuratNomor());
        values.put(KEY_AYAT, kata.getAyat());
        values.put(KEY_KATA, kata.getKata());
        values.put(KEY_SRC, kata.getSrc());
        values.put(KEY_NOMOR, kata.getNomor());

        // insert row
        long kata_id = db.insert(TABLE_KATA, null, values);

        return kata_id;
    }

    /*
    * getting all KATA
    * */
    public List<Kata> getAllKata() {
        List<Kata> katas = new ArrayList<Kata>();
        String selectQuery = "SELECT * FROM " + TABLE_KATA
                + " ORDER BY " + KEY_SURAT_NOMOR + " ASC, "  + KEY_AYAT + " ASC, " + KEY_KATA + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Kata kt = new Kata();
                kt.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                kt.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
                kt.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
                kt.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
                kt.setSrc(c.getString(c.getColumnIndex(KEY_SRC)));
                kt.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));

                // adding to KATA list
                katas.add(kt);
            } while (c.moveToNext());
        }

        return katas;
    }

    /*
    * getting all KATA by nomor surat
    * */
    public List<Kata> getAllKataByNomorSurat(int surat_nomor) {
        List<Kata> katas = new ArrayList<Kata>();
        String selectQuery = "SELECT * FROM " + TABLE_KATA
                + " WHERE " + KEY_SURAT_NOMOR + " = " + surat_nomor
                + " ORDER BY " + KEY_AYAT + " ASC, " + KEY_KATA + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Kata kt = new Kata();
                kt.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                kt.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
                kt.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
                kt.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
                kt.setSrc(c.getString(c.getColumnIndex(KEY_SRC)));
                kt.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));

                // adding to KATA list
                katas.add(kt);
            } while (c.moveToNext());
        }

        return katas;
    }

    /*
   * getting all KATA by nomor surat dan ayat
   * */
    public List<Kata> getAllKataByNomorSuratAyat(int surat_nomor, int ayat) {
        List<Kata> katas = new ArrayList<Kata>();
        String selectQuery = "SELECT * FROM " + TABLE_KATA
                + " WHERE " + KEY_SURAT_NOMOR + " = " + surat_nomor +" AND " + KEY_AYAT + " = " + ayat
                + " ORDER BY " + KEY_AYAT + " ASC, " + KEY_KATA + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Kata kt = new Kata();
                kt.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                kt.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
                kt.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
                kt.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
                kt.setSrc(c.getString(c.getColumnIndex(KEY_SRC)));
                kt.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));

                // adding to KATA list
                katas.add(kt);
            } while (c.moveToNext());
        }

        return katas;
    }

    /*
  * getting KATA by nomor surat dan nomor
  * */
    public List<Kata> getKataByNomorSuratNomor(int surat_nomor, int nomor) {
        List<Kata> katas = new ArrayList<Kata>();
        String selectQuery = "SELECT * FROM " + TABLE_KATA
                + " WHERE " + KEY_SURAT_NOMOR + " = " + surat_nomor +" AND " + KEY_NOMOR + " = " + nomor;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Kata kt = new Kata();
                kt.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                kt.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
                kt.setAyat(c.getInt(c.getColumnIndex(KEY_AYAT)));
                kt.setKata(c.getInt(c.getColumnIndex(KEY_KATA)));
                kt.setSrc(c.getString(c.getColumnIndex(KEY_SRC)));
                kt.setNomor(c.getInt(c.getColumnIndex(KEY_NOMOR)));

                // adding to KATA list
                katas.add(kt);
            } while (c.moveToNext());
        }

        return katas;
    }

    /*
    * Creating a BLOK_KOSONG
    */
    public long createBlokKosong(BlokKosong blok_kosong) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, blok_kosong.getId());
        values.put(KEY_SURAT_NOMOR, blok_kosong.getSuratNomor());
        values.put(KEY_LEVEL_ID, blok_kosong.getLevelId());
        values.put(KEY_BLANK, blok_kosong.getBlank());

        // insert row
        long blok_kosong_id = db.insert(TABLE_BLOK_KOSONG, null, values);

        return blok_kosong_id;
    }

    /*
    * get single BLOK_KOSONG
    */
    public BlokKosong getBlokKosong(int surat_nomor, int level_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_BLOK_KOSONG + " WHERE "
                + KEY_SURAT_NOMOR + " = " + surat_nomor + " AND " + KEY_LEVEL_ID + " = " + level_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        BlokKosong bk = new BlokKosong();
        bk.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        bk.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
        bk.setLevelId(c.getInt(c.getColumnIndex(KEY_LEVEL_ID)));
        bk.setBlank(c.getInt(c.getColumnIndex(KEY_BLANK)));

        return bk;
    }

    /*
    * getting all BLOK_KOSONG
    * */
    public List<BlokKosong> getAllBlokKosong() {
        List<BlokKosong> blok_kosongs = new ArrayList<BlokKosong>();
        String selectQuery = "SELECT * FROM " + TABLE_BLOK_KOSONG + " ORDER BY " + KEY_ID + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                BlokKosong bk = new BlokKosong();
                bk.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                bk.setSuratNomor(c.getInt(c.getColumnIndex(KEY_SURAT_NOMOR)));
                bk.setLevelId(c.getInt(c.getColumnIndex(KEY_LEVEL_ID)));
                bk.setBlank(c.getInt(c.getColumnIndex(KEY_BLANK)));

                // adding to BLOK_KOSONG list
                blok_kosongs.add(bk);
            } while (c.moveToNext());
        }

        return blok_kosongs;
    }

    /*
    * Creating a SETTINGS
    */
    public long createSettings(Settings settings) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PARAM, settings.getParam());
        values.put(KEY_VAL_INT, settings.getValInt());
        values.put(KEY_VAL_STRING, settings.getValString());

        // insert row
        long settings_id = db.insert(TABLE_SETTINGS, null, values);

        return settings_id;
    }

    /*
    * Update a SETTINGS
    */
    public int updateSettings(Settings settings) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PARAM, settings.getParam());
        values.put(KEY_VAL_INT, settings.getValInt());
        values.put(KEY_VAL_STRING, settings.getValString());

        // updating row
        return db.update(TABLE_SETTINGS, values, KEY_PARAM + " = ?",
                new String[] { String.valueOf(settings.getParam()) });
    }

    /*
    * get single SETTINGS
    */
    public Settings getSettings(String param) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_SETTINGS + " WHERE "
                + KEY_PARAM + " = '" + param + "'";

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Settings st = new Settings();
        st.setParam(c.getString(c.getColumnIndex(KEY_PARAM)));
        st.setValInt(c.getInt(c.getColumnIndex(KEY_VAL_INT)));
        st.setValString(c.getString(c.getColumnIndex(KEY_VAL_STRING)));

        return st;
    }

    /*
   * getting all Settings
   * */
    public List<Settings> getAllSettings() {
        List<Settings> settings = new ArrayList<Settings>();
        String selectQuery = "SELECT * FROM " + TABLE_SETTINGS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Settings st = new Settings();
                st.setParam(c.getString(c.getColumnIndex(KEY_PARAM)));
                st.setValInt(c.getInt(c.getColumnIndex(KEY_VAL_INT)));
                st.setValString(c.getString(c.getColumnIndex(KEY_VAL_STRING)));

                // adding to BLOK_KOSONG list
                settings.add(st);
            } while (c.moveToNext());
        }

        return settings;
    }

    /*
    * Creating a NILAI
    */
    public long createNilai(Nilai nilai) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, nilai.getNama());
        values.put(KEY_NILAI, nilai.getNilai());
        values.put(KEY_WAKTU, nilai.getWaktu());

        // insert row
        long nilai_id = db.insert(TABLE_NILAI, null, values);

        return nilai_id;
    }

    /*
    * getting all NILAI
    * */
    public List<Nilai> getAllNilai() {
        List<Nilai> nilais = new ArrayList<Nilai>();
        String selectQuery = "SELECT * FROM " + TABLE_NILAI + " ORDER BY " + KEY_NILAI + " DESC, " + KEY_WAKTU + " ASC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Nilai nl = new Nilai();
                nl.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                nl.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                nl.setNilai(c.getInt(c.getColumnIndex(KEY_NILAI)));
                nl.setWaktu(c.getInt(c.getColumnIndex(KEY_WAKTU)));

                // adding to BLOK_KOSONG list
                nilais.add(nl);
            } while (c.moveToNext());
        }

        return nilais;
    }

    public List<Nilai> getLimitedNilai(int limit) {
        List<Nilai> nilais = new ArrayList<Nilai>();
        String selectQuery = "SELECT * FROM " + TABLE_NILAI + " ORDER BY " + KEY_NILAI + " DESC, " + KEY_WAKTU + " ASC, " + KEY_ID + " ASC LIMIT " + limit ;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Nilai nl = new Nilai();
                nl.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                nl.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                nl.setNilai(c.getInt(c.getColumnIndex(KEY_NILAI)));
                nl.setWaktu(c.getInt(c.getColumnIndex(KEY_WAKTU)));

                // adding to BLOK_KOSONG list
                nilais.add(nl);
            } while (c.moveToNext());
        }

        return nilais;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
