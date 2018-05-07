package st2.group2.kyp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import st2.group2.kyp.R;
import st2.group2.kyp.activity.Training;
import st2.group2.kyp.model.word;

/**
 * Created by pjmma on 4/14/2018.
 */

public class Adapter_rc_main extends RecyclerView.Adapter<Adapter_rc_main.RecyclerViewHolder> implements TextToSpeech.OnInitListener{
    private ArrayList<word> items = new ArrayList<word>();
    private Context context;
    private TextToSpeech myTTS;

    public Adapter_rc_main(Context context, ArrayList<word> items){
        this.context=context;
        this.items=items;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.word_list_row, parent, false);
        myTTS = new TextToSpeech(context, this);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter_rc_main.RecyclerViewHolder holder, final int position) {
        holder.en.setText(items.get(position).getEn());
        holder.pronouce.setText(items.get(position).getPronouce());
        holder.vnm.setText(items.get(position).getVnm());

        holder.ln_list_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Training.class);
                context.startActivity(intent);
            }
        });
        holder.speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTTS.speak(holder.en.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView  en,pronouce,vnm;
        private LinearLayout ln_list_row;
        private ImageView speaker;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ln_list_row = (LinearLayout) itemView.findViewById(R.id.ln_list_row);
            en = (TextView) itemView.findViewById(R.id.en);
            pronouce = (TextView) itemView.findViewById(R.id.pronouce);
            vnm = (TextView) itemView.findViewById(R.id.vnm);
            speaker = (ImageView) itemView.findViewById(R.id.speaker);
        }
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = myTTS.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {

            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }
    private void speakOut(String text) {
        myTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }



}