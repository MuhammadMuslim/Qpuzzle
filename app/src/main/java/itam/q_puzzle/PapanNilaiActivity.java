package itam.q_puzzle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linearlistview.LinearListView;

import java.util.List;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.DBhelper.DatabaseHelper;
import itam.q_puzzle.function.Waktu;
import itam.q_puzzle.model_activity.Nilai;

/**
 * Created by M. ROMADLONI on 27-06-2016.
 */
public class PapanNilaiActivity extends AppCompatActivity {

    Context context;
    DatabaseHelper databaseHelper;
    LinearListView linearListNilai;
    Waktu waktuClass;
    List<Nilai> listNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papan_nilai);
        context = PapanNilaiActivity.this;
        databaseHelper = new DatabaseHelper(context);
        listNilai = databaseHelper.getLimitedNilai(20);
        waktuClass = new Waktu();

        linearListNilai = (LinearListView) findViewById(R.id.linearListNilai);
        linearListNilai.setAdapter(adapterNilai);
    }

    private BaseAdapter adapterNilai = new BaseAdapter() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {

                convertView = getLayoutInflater().inflate(R.layout.item_list_nilai, parent, false);
                holder = new ViewHolder();
                holder.textNomor = convertView.findViewById(R.id.tV_sbnomor);
                holder.textNama = convertView.findViewById(R.id.tV_sbnama);
                holder.textNilai = convertView.findViewById(R.id.tV_sbnilai);
                holder.textWaktu = convertView.findViewById(R.id.tV_sbwaktu);
                convertView.setTag(holder);
            }

            holder.textNomor.setText(""+(position+1));
            holder.textNama.setText(""+listNilai.get(position).getNama());
            holder.textNilai.setText(""+listNilai.get(position).getNilai());
            holder.textWaktu.setText(""+waktuClass.getWaktuJam(listNilai.get(position).getWaktu()));

            return convertView;
        }

        /*private view holder class*/
        class ViewHolder {
            TextView textNomor;
            TextView textNama;
            TextView textNilai;
            TextView textWaktu;
        }

        @Override
        public int getCount() {
            return listNilai.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    };
}
