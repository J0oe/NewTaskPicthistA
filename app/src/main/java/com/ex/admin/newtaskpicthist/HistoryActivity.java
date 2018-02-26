package com.ex.admin.newtaskpicthist;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    final Uri IMAGE_URI = Uri
            .parse("content://task.ImageLooker/dateImage");
    ListView listView;
    Collect collect;
    static ArrayList<Product> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = findViewById(R.id.idListHistory);
        Cursor c = getContentResolver().query(IMAGE_URI, null, null,
                null, null);
        collect = new Collect();
        collect.showMeHistory(c, this, listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String _id = arrayList.get(position).id;
                String urlImate = arrayList.get(position).url;
                String status = arrayList.get(position).status;



                collect.upHistory(getApplicationContext(), urlImate, _id, status);
                finish();

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        listView = findViewById(R.id.idListHistory);


        int id = item.getItemId();


        switch (id) {

            case R.id.idSortStatus:
                Cursor c1 = getContentResolver().query(IMAGE_URI, null, null,
                        null, "statusImage");
                collect = new Collect();
                collect.showMeHistory(c1, this, listView);
                return true;
            case R.id.idSortTime:
                Cursor c2 = getContentResolver().query(IMAGE_URI, null, null,
                        null, "timeImage" + " DESC");
                collect = new Collect();
                collect.showMeHistory(c2, this, listView);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history_activity, menu);
        return true;

    }
}
