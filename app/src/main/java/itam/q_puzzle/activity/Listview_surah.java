package itam.q_puzzle.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

import id.mromadloni.q_puzzle.R;
import itam.q_puzzle.model.MyAdapter;
import itam.q_puzzle.model.surah;

public class Listview_surah extends AppCompatActivity {


   SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_surah);

        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);

        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });



    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<surah> getPlayers()
    {
        ArrayList<surah> surahs =new ArrayList<>();
        surah p=new surah();
        p.setName("QS: Al-Adiyat {100}");
        p.setPos("11 ayat, 29 block puzzle, puzzle ke 15");
        p.setImg(R.drawable.ady);
        surahs.add(p);

        p=new surah();
        p.setName("QS: Al-Qoriah {101}");
        p.setPos("11 ayat, 31 block puzzle, puzzle ke 14");
        p.setImg(R.drawable.qrh);
        surahs.add(p);

        p=new surah();
        p.setName("QS: Al-Takatsur {102}");
        p.setPos("8 ayat, 28 block puzzle, puzzle ke 13");
        p.setImg(R.drawable.tks);
        surahs.add(p);

        p=new surah();
        p.setName("QS: Al-Asr {103}");
        p.setPos("3 ayat, 13 block puzzle, puzzle ke 12");
        p.setImg(R.drawable.ash);
        surahs.add(p);

        p=new surah();
        p.setName("QS: Al-Humazah {104}");
        p.setPos("9 ayat, 29 block puzzle, puzzle ke 11");
        p.setImg(R.drawable.hmz);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-FIL {105}");
        p.setPos("5 ayat, 23 block puzzle, puzzle ke 10");
        p.setImg(R.drawable.lsjd105);
        surahs.add(p);

        p=new surah();
        p.setName("QS: QURAYSH {106}");
        p.setPos("4 ayat, 17 block puzzle, puzzle ke 9");
        p.setImg(R.drawable.lsjd106);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-MA'UN {107}");
        p.setPos("7 ayat, 25 block puzzle, puzzle ke 8");
        p.setImg(R.drawable.lsjd107);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-KAWTHAR {108}");
        p.setPos("3 ayat, 10 block puzzle, puzzle ke 7");
        p.setImg(R.drawable.lsjd108);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-KAFIRUN {109}");
        p.setPos("6 ayat, 26 block puzzle, puzzle ke 6");
        p.setImg(R.drawable.lsjd109);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AN-NASR {110}");
        p.setPos("3 ayat, 19 block puzzle, puzzle ke 5");
        p.setImg(R.drawable.lsjd110);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-MASAD {111}");
        p.setPos("5 ayat, 23 block puzzle, puzzle ke 4");
        p.setImg(R.drawable.lsjd111);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-'IKHLAS {112}");
        p.setPos("4 ayat, 15 block puzzle, puzzle ke 3");
        p.setImg(R.drawable.lsjd112);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-FALAQ {113}");
        p.setPos("5 ayat, 23 block puzzle, puzzle ke 2");
        p.setImg(R.drawable.lsjd113);
        surahs.add(p);

        p=new surah();
        p.setName("QS: AL-FALAQ {113}");
        p.setPos("6 ayat, 20 block puzzle, puzzle ke 1");
        p.setImg(R.drawable.lsjd114);
        surahs.add(p);

        return surahs;
    }



}
