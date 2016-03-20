package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Md. Ishan Arefin on 19-03-16.
 */
public class UserUniversityDatabase extends SQLiteOpenHelper{
    private static final String DBNAME = "appicationdb";
    private static final int DB_VER = 1;

    public UserUniversityDatabase(Context context)
    {
        super(context, DBNAME, null, DB_VER);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student ("
        +"_id integer primary key autoincrement,"
        +"username text,"
        +"password text,"
        +"res_ssc real,"
        +"res_hsc real,"
        +"group_ text,"
        +"type text,"
        +"hsc_yr integer,"
        +"blood_grp text);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
