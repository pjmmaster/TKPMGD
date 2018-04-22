package st2.group2.kyp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import st2.group2.kyp.R;
import st2.group2.kyp.model.word;

/**
 * Created by pjmma on 4/14/2018.
 */

public class Adapter_rc_main extends RecyclerView.Adapter<Adapter_rc_main.RecyclerViewHolder>{
    private ArrayList<word> items = new ArrayList<word>();
    private Context context;

    public Adapter_rc_main(Context context, ArrayList<word> items){
        this.context=context;
        this.items=items;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.word_list_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter_rc_main.RecyclerViewHolder holder, final int position) {
        holder.en.setText(items.get(position).getEn());
        holder.pronouce.setText(items.get(position).getPronouce());
        holder.vnm.setText(items.get(position).getVnm());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView  en,pronouce,vnm;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            en = (TextView) itemView.findViewById(R.id.en);
            pronouce = (TextView) itemView.findViewById(R.id.pronouce);
            vnm = (TextView) itemView.findViewById(R.id.vnm);
        }
    }
}