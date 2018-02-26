package com.ex.admin.newtaskpicthist;

import android.content.Context;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Admin on 25.02.2018.
 */

public interface ICollect {

    void upHistory(Context context, String urlmage, String idImage,String action);

    void nextApp(Context context, EditText urlImage);

    void showMeHistory(Cursor c, Context context, ListView listView);
}
