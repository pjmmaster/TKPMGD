package st2.group2.kyp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import st2.group2.kyp.adapter.Adapter_rc_main;
import st2.group2.kyp.R;
import st2.group2.kyp.adapter.Adapter_rc_short;
import st2.group2.kyp.model.phonetic;
import st2.group2.kyp.model.word;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<word> wordList = new ArrayList<word>();
    private ArrayList<phonetic> phoneticList = new ArrayList<phonetic>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rc_content_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage) {
            mAdapter = new Adapter_rc_main(this,wordList);
            mRecyclerView.setAdapter(mAdapter);
        } else if (id == R.id.nav_short) {

            phoneticList.clear();
            //Set data phonetic short
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /e/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /ə/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /ɪ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /ɒ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /ʌ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm ngắn /ʊ/"));

            mAdapter = new Adapter_rc_short(this, phoneticList);
            mRecyclerView.setAdapter(mAdapter);

        } else if (id == R.id.nav_long) {

            phoneticList.clear();
            //Set data phonetic short
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm dài /ɑ:/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm dài /æ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm dài /ɜ:/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm dài /i:/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm dài /ɔ:/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /u:/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /aɪ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /aʊ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /eɪ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /oʊ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /ɔɪ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /eə/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /ɪə/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Nguyên âm đôi /ʊə/"));

            mAdapter = new Adapter_rc_short(this, phoneticList);
            mRecyclerView.setAdapter(mAdapter);

        } else if (id == R.id.nav_sound) {
            phoneticList.clear();
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /b/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /d/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /f/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /g/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /h/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /j/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /k/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /l/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /m/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /n/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /ŋ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /p/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /r/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /s/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /ʃ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /t/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /tʃ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /θ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /ð/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /v/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /w/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /z/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /ʒ/"));
            phoneticList.add(new phonetic(R.drawable.tooth,"Phụ âm thường /dʒ/"));

            mAdapter = new Adapter_rc_short(this, phoneticList);
            mRecyclerView.setAdapter(mAdapter);
        } else if (id == R.id.nav_nosound) {
            phoneticList.clear();
            phoneticList.add(new phonetic(R.drawable.tooth,"Đang cập nhật...!"));
            mAdapter = new Adapter_rc_short(this, phoneticList);
            mRecyclerView.setAdapter(mAdapter);
        } else if (id == R.id.nav_favorite) {
            mAdapter = new Adapter_rc_main(this,wordList);
            mRecyclerView.setAdapter(mAdapter);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
