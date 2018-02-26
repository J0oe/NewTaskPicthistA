package com.ex.admin.newtaskpicthist;

import android.content.Context;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Admin on 25.02.2018.
 */

public class Collect implements ICollect {
    Worker worker = new Worker();

    @Override
    public void upHistory(Context context, String urlmage, String idImage,String action) {
        worker.updateImage(context,urlmage,idImage,action);
    }

    @Override
    public void nextApp(Context context, EditText urlImage) {
        worker.moveToApp(context, urlImage);
    }

    @Override
    public void showMeHistory(Cursor c, Context context, ListView listView) {
        worker.imageHistory(c, context, listView);
    }
}
