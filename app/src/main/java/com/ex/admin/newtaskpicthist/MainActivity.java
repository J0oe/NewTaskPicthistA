package com.ex.admin.newtaskpicthist;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Collect collect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collect = new Collect();
    }

    public void onClickMoveShowImage(View view) {
        EditText text = findViewById(R.id.idTextPict);
        collect.nextApp(this, text);
    }

    public void onClickMoveToHistory(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }


}
