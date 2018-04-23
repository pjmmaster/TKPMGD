package st2.group2.kyp.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import st2.group2.kyp.R;
import st2.group2.kyp.adapter.Adapter_rc_main;
import st2.group2.kyp.model.word;

public class Vowels extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<word> wordList = new ArrayList<word>();
    Toolbar toolbar_vowels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowels);

        //Set Back ToolBar
        toolbar_vowels = findViewById(R.id.toolbar_vowels);
        setSupportActionBar(toolbar_vowels);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar_vowels.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rc_vowels);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //set default data
        word addword1 = new word("him","/him/","anh ay","love");
        word addword2 = new word("him1","/him1/","anh ay1","love");
        word addword3 = new word("him2","/him2/","anh ay2","love");
        word addword4 = new word("him3","/him3/","anh ay3","love");
        word addword5 = new word("him4","/him4/","anh ay4","love");
        wordList.add(addword1);
        wordList.add(addword2);
        wordList.add(addword3);
        wordList.add(addword4);
        wordList.add(addword5);
        mAdapter = new Adapter_rc_main(this,wordList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
