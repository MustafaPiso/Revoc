package mohammed.revok.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mohammed.revok.R;


/**
 * Created by mahmo on 20/11/2016.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.Holder> {
    private static RecyclerViewClickListener itemListener;
    Context context;
    List<String> words;
    public WordAdapter(Context context, ArrayList<String> arr,RecyclerViewClickListener listener) {
        // TODO Auto-generated constructor stub
        this.context=context;
        this.words=arr;
        this.itemListener=listener;
    }
    public WordAdapter(Context context, ArrayList<String> arr) {
        // TODO Auto-generated constructor stub
        this.context=context;
        this.words=arr;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.word,parent,false);
        Holder holder=new Holder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.Name.setText(words.get(position));

    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Name ;
        public Holder(View itemView){
            super(itemView);
            Name=(TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);


        }
        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(view, this.getLayoutPosition());

        }
    }
    public interface RecyclerViewClickListener {

        void recyclerViewListClicked(View v, int position);
    }


}