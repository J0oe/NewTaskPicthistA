package com.ex.admin.newtaskpicthist;

import android.content.Context;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Admin on 25.02.2018.
 */

public interface IWorker {
    void updateImage(Context context, String urlmage,String idImage,String action);

    void moveToApp(Context context, EditText urlImage);

    void imageHistory(Cursor c, Context context, ListView listView);
}
