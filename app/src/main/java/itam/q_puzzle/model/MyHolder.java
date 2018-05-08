package itam.q_puzzle.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.mromadloni.q_puzzle.R;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //OUR VIEWS
    ImageView img;
    TextView nameTxt,posTxt;

    ItemClickListener itemClickListener;


    public MyHolder(View itemView) {
        super(itemView);

        this.img= itemView.findViewById(R.id.playerImage);
        this.nameTxt= itemView.findViewById(R.id.nameTxt);
        this.posTxt= itemView.findViewById(R.id.posTxt);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
