package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view)
    {
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        SQLiteOpenHelper useruniversity_dbhelper = new UserUniversityDatabase(this);
        SQLiteDatabase db = useruniversity_dbhelper.getReadableDatabase();
        Cursor cursor = db.query("student", new String[]{"username"}, "username = ?", new String[]{username}, null, null, null);

<<<<<<< HEAD
        if(cursor.moveToFirst())
=======
        //determines who is user by saving username even after application kill
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("current_username", username);
        editor.commit();

        uservalues.put("username", username);
        uservalues.put("password", ((EditText) findViewById(R.id.password)).getText().toString());
        uservalues.put("res_ssc", Double.parseDouble(((EditText) findViewById(R.id.res_ssc)).getText().toString()));
        uservalues.put("res_hsc", Double.parseDouble(((EditText) findViewById(R.id.res_hsc)).getText().toString()));

        Spinner group = (Spinner) findViewById(R.id.group);
        if(group.getSelectedItemPosition() == 0)
        {
            uservalues.put("group_", "science");
        }
        else if(group.getSelectedItemPosition() == 1)
>>>>>>> a88fc8c3484682073bd110873cec5acb46ef3b43
        {
                Toast toast = Toast.makeText(this, "Enter unique username", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
        }

        else
        {
            ContentValues uservalues = new ContentValues();
            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("current_username", username);
            editor.commit();
            Log.i("jani na jani na", sharedPreferences.getString("current_username", "no_user"));

            uservalues.put("username", username);
            uservalues.put("password", ((EditText) findViewById(R.id.password)).getText().toString());
            uservalues.put("res_ssc", Double.parseDouble(((EditText) findViewById(R.id.res_ssc)).getText().toString()));
            uservalues.put("res_hsc", Double.parseDouble(((EditText) findViewById(R.id.res_hsc)).getText().toString()));

            Spinner group = (Spinner) findViewById(R.id.group);
            if(group.getSelectedItemPosition() == 0)
            {
                uservalues.put("group_", "science");
            }
            else if(group.getSelectedItemPosition() == 1)
            {
                uservalues.put("group_", "commerce");
            }
            else uservalues.put("group_", "arts");

<<<<<<< HEAD
            Spinner type = (Spinner) findViewById(R.id.type);
            if(type.getSelectedItemPosition() == 0)
            {
                uservalues.put("type", "regular");
            }
            else uservalues.put("type", "irregular");

            uservalues.put("hsc_yr", Integer.parseInt(((EditText) findViewById(R.id.hsc_yr)).getText().toString()));
            uservalues.put("blood_grp", ((EditText) findViewById(R.id.blood_grp)).getText().toString());
=======
        Intent intent = new Intent(this,User_Info.class);
        startActivity(intent);
        finish();
    }
>>>>>>> a88fc8c3484682073bd110873cec5acb46ef3b43


            db.insert("student", null, uservalues);
            Intent intent = new Intent(this, OptionActivity.class);
            startActivity(intent);
            finish();
        }

        cursor.close();
        db.close();
    }
}
