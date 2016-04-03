package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.widget.TextView;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User_Info extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__info);
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
            String userName=sharedPreferences.getString("current_username","error");
            SQLiteOpenHelper  UserUniversityDatabase =new UserUniversityDatabase (this);
            SQLiteDatabase db=UserUniversityDatabase.getReadableDatabase();
            Cursor cursor=db.query("student", new String[] {"username", "password","res_ssc","res_hsc","group_","type","hsc_yr", "blood_grp"}
            ,"username=?", new String[]{userName},null,null,null );
            if(cursor.moveToFirst()){
                String user_name=cursor.getString(0);
                String password = cursor.getString(1);
                String  res_ssc =cursor.getString(2);
                String res_hsc =cursor.getString(3);
                String group_  =cursor.getString(4);
                String type =cursor.getString(5);
                String hsc_yr= cursor.getString(6);
                String blood_grp =cursor.getString(7);
                TextView username_=(TextView)findViewById(R.id.username_);
                username_.setText(user_name);
                TextView pass=(TextView)findViewById(R.id.pass);
                pass.setText(password);
                TextView res_s=(TextView)findViewById(R.id.res_s);
                res_s.setText(res_ssc);
                TextView res_h=(TextView)findViewById(R.id.res_h);
                res_h.setText(res_hsc);
                TextView groupname=(TextView)findViewById(R.id.groupname);
                groupname.setText(group_);
                TextView type_=(TextView)findViewById(R.id.type_);
                type_.setText(type);
                TextView hsc_yr_=(TextView)findViewById(R.id.hsc_yr_);
                hsc_yr_.setText(hsc_yr);
                TextView blood_=(TextView)findViewById(R.id.blood_);
                blood_.setText(blood_grp);
            }
        }
        catch (SQLiteException e){

        }
    }
    public void edit_(View view){
        Intent intent=new Intent(this,OptionActivity.class);
        startActivity(intent);
        finish();
    }
    public void delete_(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String userName =sharedPreferences.getString("current_username", "error");
        SQLiteOpenHelper  UserUniversityDatabase =new UserUniversityDatabase (this);
        SQLiteDatabase db=UserUniversityDatabase.getReadableDatabase();
        db.delete("student","username=?",new String[]{userName});
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("current_username","no_user");
        editor.commit();
        Intent intent=new Intent(this,User_Info.class);
        startActivity(intent);
        finish();
    }

}
