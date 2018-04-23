package st2.group2.kyp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import st2.group2.kyp.R;

public class Training extends AppCompatActivity {

    private Toolbar toolbar_training;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        //Set Back ToolBar
        toolbar_training = (Toolbar) findViewById(R.id.toolbar_training);
        setSupportActionBar(toolbar_training);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar_training.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
