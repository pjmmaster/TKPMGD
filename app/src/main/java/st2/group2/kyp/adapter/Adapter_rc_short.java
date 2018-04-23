package st2.group2.kyp.adapter;

/**
 * Created by pjmma on 4/17/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import st2.group2.kyp.R;
import st2.group2.kyp.activity.Vowels;
import st2.group2.kyp.model.phonetic;

public class Adapter_rc_short extends RecyclerView.Adapter<Adapter_rc_short.RecyclerViewHolder> {
    private ArrayList<phonetic> items = new ArrayList<phonetic>();
    private Context context;

    public Adapter_rc_short(Context context, ArrayList<phonetic> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.short_list_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter_rc_short.RecyclerViewHolder holder, final int position) {
        holder.tv_spelling.setText(items.get(position).getSpelling());
        holder.img_spelling.setImageResource(items.get(position).getImg_spelling());
        holder.tv_spelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Vowels.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_spelling;
        private ImageView img_spelling;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tv_spelling = (TextView) itemView.findViewById(R.id.tv_spelling);
            img_spelling = (ImageView) itemView.findViewById(R.id.img_spelling);
        }
    }
}