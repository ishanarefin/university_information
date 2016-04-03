package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.database.Cursor;
import android.widget.TextView;

public class EditActivity extends Activity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SQLiteOpenHelper UserUniversityDatabase = new UserUniversityDatabase(this);
        SQLiteDatabase db = UserUniversityDatabase.getReadableDatabase();
        String userName = sharedPreferences.getString("current_username", "no_user");
        Cursor cursor = db.query("student", new String[]{"username", "password", "res_ssc", "res_hsc", "group_", "type", "hsc_yr", "blood_grp"}
                , "username=?", new String[]{userName}, null, null, null);

        if (cursor.moveToFirst()) {
            Log.i("ismail test", "kochu");
            String user_name = cursor.getString(0);
            String password = cursor.getString(1);
            String res_ssc = cursor.getString(2);
            String res_hsc = cursor.getString(3);
            String group_ = cursor.getString(4);
            String type = cursor.getString(5);
            String hsc_yr = cursor.getString(6);
            String blood_grp = cursor.getString(7);


            EditText hsc_res = (EditText) findViewById(R.id.res_hsc);
            hsc_res.setText(res_hsc, TextView.BufferType.EDITABLE);

            EditText ssc_res = (EditText) findViewById(R.id.blood_grp);
            ssc_res.setText(blood_grp, TextView.BufferType.EDITABLE);

            EditText group__ = (EditText) findViewById(R.id.res_ssc);
            group__.setText(res_ssc, TextView.BufferType.EDITABLE);

            EditText yr_hsc = (EditText) findViewById(R.id.hsc_yr);
            yr_hsc.setText(hsc_yr, TextView.BufferType.EDITABLE);
        }

        cursor.close();
        db.close();
    }

    public void update(View view) {


        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("current_username", "no_user");
        SQLiteOpenHelper UserUniversityDatabase = new UserUniversityDatabase(this);
        SQLiteDatabase db = UserUniversityDatabase.getReadableDatabase();




            ContentValues uservalues = new ContentValues();

            uservalues.put("res_ssc", Double.parseDouble(((EditText) findViewById(R.id.res_ssc)).getText().toString()));
            uservalues.put("res_hsc", Double.parseDouble(((EditText) findViewById(R.id.res_hsc)).getText().toString()));
            uservalues.put("hsc_yr", Integer.parseInt(((EditText) findViewById(R.id.hsc_yr)).getText().toString()));
            uservalues.put("blood_grp", ((EditText) findViewById(R.id.blood_grp)).getText().toString());


            Spinner group = (Spinner) findViewById(R.id.group);
            if (group.getSelectedItemPosition() == 0) {
                uservalues.put("group_", "science");
            } else if (group.getSelectedItemPosition() == 1) {
                uservalues.put("group_", "commerce");
            } else uservalues.put("group_", "arts");

            Spinner type1 = (Spinner) findViewById(R.id.type);
            if (type1.getSelectedItemPosition() == 0) {
                uservalues.put("type", "regular");
            } else uservalues.put("type", "irregular");


            db.update("student", uservalues, "username = ?", new String[]{userName});


        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);
        finish();

        db.close();

        }



    public void register(View view)
    {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
