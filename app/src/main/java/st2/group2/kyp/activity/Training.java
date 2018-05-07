package st2.group2.kyp.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import st2.group2.kyp.R;

public class Training extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private static final int VR_REQUEST = 999;
    private Toolbar toolbar_training;
    private ImageButton imgB_speak,imgB_listen;
    private TextView en,you_speak,pronouce;
    private String TAG = "Training";
    private TextToSpeech myTTS;
    private String en1,pronouce1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        imgB_listen = (ImageButton) findViewById(R.id.imgB_listen);
        imgB_speak = (ImageButton) findViewById(R.id.imgB_speak);
        toolbar_training = (Toolbar) findViewById(R.id.toolbar_training);
        en = (TextView) findViewById(R.id.en);
        pronouce = (TextView) findViewById(R.id.pronouce);
        you_speak = (TextView) findViewById(R.id.you_speak);

        //Set Back ToolBar
        setSupportActionBar(toolbar_training);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar_training.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String en1 = intent.getStringExtra("en");
        String pronouce1 = intent.getStringExtra("pronouce");

        en.setText(en1);
        pronouce.setText(pronouce1);

        myTTS = new TextToSpeech(this, this);
        imgB_listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = myTTS.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //imgB_listen.setEnabled(true);
                //speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {

        String text = en.getText().toString();
        myTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (myTTS != null) {
            myTTS.stop();
            myTTS.shutdown();
        }
        super.onDestroy();
    }
}
