package itam.q_puzzle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.DBhelper.DatabaseHelper;
import itam.q_puzzle.model_activity.Settings;

/**
 * Created by M. ROMADLONI on 17-06-2016.
 */
public class LoadingScreenActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Context context;
    RelativeLayout rLLS;
    ProgressBar PBLS;
    TextView TVSL;
    ProgressTask task;
    ImageView imagePuzzle, imageSurat, imageLevel;
    Settings settingsPuzzle, settingsSurat, settingsLevel;
    int curLevel, curSurat, curPuzzle;
    int pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        context = LoadingScreenActivity.this;
        databaseHelper = new DatabaseHelper(context);

        settingsPuzzle = databaseHelper.getSettings("puzzle");
        settingsSurat = databaseHelper.getSettings("surat");
        settingsLevel = databaseHelper.getSettings("level");
        curPuzzle = settingsPuzzle.getValInt();
        curSurat = settingsSurat.getValInt();
        curLevel = settingsLevel.getValInt();

        imagePuzzle = (ImageView) findViewById(R.id.iV_ls_puzzle);
        imageSurat = (ImageView) findViewById(R.id.iV_ls_judul);
        imageLevel = (ImageView) findViewById(R.id.iV_ls_level);

        imagePuzzle.setImageDrawable(getDrawableByName("lspuzzle"+curPuzzle));
        imageSurat.setImageDrawable(getDrawableByName("lsjd"+curSurat));
        imageLevel.setImageDrawable(getDrawableByName("lslevel"+curLevel));

        rLLS = (RelativeLayout) findViewById(R.id.rL_ls);
        PBLS = (ProgressBar) findViewById(R.id.pB_ls);
        TVSL = (TextView) findViewById(R.id.tV_lssentuhlayar);
        PBLS.setVisibility(View.VISIBLE);
        TVSL.setVisibility(View.INVISIBLE);
        showProgress();
    }

    private class ProgressTask extends AsyncTask<Integer,Integer,Void> {

        protected void onPreExecute() {
            PBLS.setMax(100); // set maximum progress to 100.
        }
        protected void onCancelled() {
            PBLS.setMax(0); // stop the progress
        }
        protected Void doInBackground(Integer... params) {

            int start=params[0];
            for(int i=start;i<=100;i+=10){
                try {
                    publishProgress(i);
                    Log.v("Progress","increment " + i);
                    SystemClock.sleep(100);
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                }
            }
            return null;
        }
        protected void onProgressUpdate(Integer... values) {

            // increment progress bar by progress value
            PBLS.setProgress(PBLS.getProgress()+10);
        }
        protected void onPostExecute(Void result) {
            // async task finished
            PBLS.setVisibility(View.INVISIBLE);
            TVSL.setVisibility(View.VISIBLE);
            rLLS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoadingScreenActivity.this, PuzzleBoardActivity.class);
                    startActivity(intent);

                    finish();
                }
            });
            Log.v("Progress", "Finished");
        }

    }

    public void showProgress() {
        task = new ProgressTask();
        // start progress bar with initial progress 10
        task.execute(10);
    }

    private Drawable getDrawableByName(String name) {
        Log.d("getDrawableByName", name);
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }
}
