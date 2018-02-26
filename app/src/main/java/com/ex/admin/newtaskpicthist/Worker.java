package com.ex.admin.newtaskpicthist;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.ex.admin.newtaskpicthist.HistoryActivity.arrayList;

/**
 * Created by Admin on 25.02.2018.
 */

public class Worker implements IWorker {


    @Override
    public void updateImage(Context context, String urlmage, String idImage, String action) {
        Intent myIntent1 = new Intent();
        myIntent1.setComponent(new ComponentName("com.ex.admin.newtaskhist", "com.ex.admin.newtaskhist.MainActivity"));
        myIntent1.putExtra("urlImage", urlmage);
        myIntent1.putExtra("idImage", idImage);


        if (action.equals("1")) {
            myIntent1.putExtra("action", "delete");
        } else {
            myIntent1.putExtra("action", "update");

        }


        context.startActivity(myIntent1);
    }

    @Override
    public void moveToApp(Context context, EditText urlImage) {
        Intent myIntent1 = new Intent();
        myIntent1.setComponent(new ComponentName("com.ex.admin.newtaskhist", "com.ex.admin.newtaskhist.MainActivity"));
        myIntent1.putExtra("urlImage", urlImage.getText().toString());
        myIntent1.putExtra("action", "add");

        context.startActivity(myIntent1);
    }

    @Override
    public void imageHistory(Cursor c, Context context, ListView listView) {
        Product product;
        arrayList.clear();

        if (c.moveToFirst()) {

            int urlImage = c.getColumnIndex("urlImage");
            int timeImage = c.getColumnIndex("timeImage");
            int statusImage = c.getColumnIndex("statusImage");
            int idImage = c.getColumnIndex("_id");


            do {
                product = new Product(c.getString(urlImage), c.getString(timeImage), c.getString(statusImage), c.getString(idImage));
                arrayList.add(product);

                BoxAdapter boxAdapter = new BoxAdapter(context, HistoryActivity.arrayList);
                listView.setAdapter(boxAdapter);
                boxAdapter.notifyDataSetChanged();
            } while (c.moveToNext());

        }
    }
}
