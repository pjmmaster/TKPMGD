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
    private TextView vnm,you_speak;
    private String TAG = "Training";
    protected long mSpeechRecognizerStartListeningTime = 0;
    //TTS object
    private TextToSpeech myTTS;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        imgB_listen = (ImageButton) findViewById(R.id.imgB_listen);
        imgB_speak = (ImageButton) findViewById(R.id.imgB_speak);
        toolbar_training = (Toolbar) findViewById(R.id.toolbar_training);
        vnm = (TextView) findViewById(R.id.vnm);
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

        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

        imgB_listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String words = vnm.getText().toString();
                speakWords(words);
            }
        });


        //
        //find out whether speech recognition is supported
        PackageManager packManager = getPackageManager();
        List<ResolveInfo> intActivities = packManager.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (intActivities.size() != 0) {
            //speech recognition is supported - detect user button clicks
            imgB_speak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listenToSpeech();
                }
            });
        }
        else
        {
            //speech recognition not supported, disable button and output message
            imgB_speak.setEnabled(false);
            Toast.makeText(this, "Oops - Speech recognition not supported!", Toast.LENGTH_LONG).show();
        }
        //

    }

    private void listenToSpeech() {

        //start the speech recognition intent passing required data
        Intent listenIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //indicate package
        listenIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
        //message to display while listening
        listenIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say: " + vnm.getText().toString());
        //set speech model
        listenIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //specify number of results to retrieve
        listenIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 10);

        //start listening
        startActivityForResult(listenIntent, VR_REQUEST);
    }

    private void speakWords(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }

        if (requestCode == VR_REQUEST && resultCode == RESULT_OK){
            //store the returned word list as an ArrayList
            ArrayList<String> suggestedWords = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            //set the retrieved list to display in the ListView using an ArrayAdapter
            for(String match : suggestedWords)
                Log.d("TAG",match);
            you_speak.setText(suggestedWords.get(0).toString());
        }
    }
    //setup TTS
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }
}
