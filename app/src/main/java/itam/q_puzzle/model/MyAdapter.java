package itam.q_puzzle.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

import id.mromadloni.q_puzzle.R;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<surah> surahs,filterList;
    CustomFilter filter;


    public MyAdapter(Context ctx, ArrayList<surah> surahs)
    {
        this.c=ctx;
        this.surahs = surahs;
        this.filterList= surahs;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //CONVERT XML TO VIEW ONBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);

        //HOLDER
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        //BIND DATA
        holder.posTxt.setText(surahs.get(position).getPos());
        holder.nameTxt.setText(surahs.get(position).getName());
        holder.img.setImageResource(surahs.get(position).getImg());


        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
//                Snackbar.make(v,surahs.get(pos).getName(),Snackbar.LENGTH_SHORT).show();
//                int i=1;
//                if (i==1){
//
//                }
            }
        });

    }

    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return surahs.size();
    }

    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
}
