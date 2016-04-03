package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.content.ContentValues;
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
                + "_id integer primary key autoincrement,"
                + "username text,"
                + "password text,"
                + "res_ssc real,"
                + "res_hsc real,"
                + "group_ text,"
                + "type text,"
                + "hsc_yr integer,"
                + "blood_grp text);");
        db.execSQL("create table public("
                + "uni_name text primary key, "
                + "hall_num integer, "
                + "location text, "
                + "Viva_req, "
                + "web_link text, "
                + "second_time text,"
                + " FOREIGN KEY (uni_name) REFERENCES  university (uni_name));");
        db.execSQL("create table university("
                + "uni_name text primary key);");
        insertuniversity(db, "Dhaka University");
        insertuniversity(db, "Jagannath University");
        insertuniversity(db, "BUET");
        insertuniversity(db,"KUET");
        insertuniversity(db, "RUET");
        insertuniversity(db,"CUET");
         insertuniversity(db, "Brac University");
        insertuniversity(db, "Ahsanullah University of Science & Technology");
        insertuniversity(db, "North South University");
        insertuniversity(db, "East West University");
        insertpublic(db, "Dhaka University", 23, "Nilkhet Road.Dhaka", "Yes", "http://www.du.ac.bd/", "No");
        insertpublic(db, "Jagannath University", 13, "Patuatuli,Dhaka", "Yes", "http://www.jnu.ac.bd/", "Yes");
        insertpublic(db, "jahangirnagar University", 7, "Savar,Dhaka", "Yes", "http://www.juniv.edu/", "Yes");
        insertpublic(db, "BUET", 8, "Zahir Rayhan Road,Dhaka", "No", "http://www.buet.ac.bd/", "No");
        insertpublic(db, "KUET", 7, "Taligali,Khulna","No", "http://www.kuet.ac.bd/", "No");
        insertpublic(db, "RUET", 6, "Jahangir Sarani,Rajshahi", "No", "http://www.ruet.ac.bd/", "No");
        insertpublic(db, "CUET", 5, "Kapatai Road, Chittagong", "No", "http://www.cuet.ac.bd/", "No");

        db.execSQL("create table private("
                + "uni_name text primary key, "
                + "location text, "
                + "web_link text, "
                + "sem_per_year text, "
                + "own_campus text, "
                + "credit_system text,"
                + " FOREIGN KEY (uni_name) REFERENCES  university (uni_name));");
        insertprivate(db, "BRAC University", "Mohakhali,Dhaka", "http://bracu.ac.bd/", "3 (except Architechture and Pharmacy)", "No", "open");
        insertprivate(db, "Ahsanullah University of Science & Technology", "Tejgaon,Dhaka", "http://www.aust.edu/index.htm", "2", "Yes", "closed");
        insertprivate(db, "North South University", "Basundhara,Dhaka", "http://www.northsouth.edu/", "3", "Yes", "open");
        insertprivate(db, "East West University", "Aftabnagar,Dhaka", "http://www.ewubd.edu/", "3", "Yes", "open");
    }

    private void insertuniversity(SQLiteDatabase db, String s) {
        ContentValues universityvalue=new ContentValues();
        universityvalue.put("uni_name",s);
        db.insert("university", null, universityvalue);
    }

    private void insertpublic(SQLiteDatabase db, String s, int i, String s1, String s2,String s3,String s4) {
        ContentValues publicvalue=new ContentValues();
        publicvalue.put("uni_name", s);
        publicvalue.put("hall_num",i);
        publicvalue.put("location",s1);
        publicvalue.put("Viva_req",s2);
        publicvalue.put("web_link",s3);
        publicvalue.put("second_time",s4);
        db.insert("public",null, publicvalue);
    }

    private void insertprivate(SQLiteDatabase db, String bracu1, String bracu, String s, String s1, String s2, String no) {
        ContentValues privatevalue=new ContentValues();
        privatevalue.put("uni_name",bracu1);
        privatevalue.put("location",bracu);
        privatevalue.put("web_link",s);
        privatevalue.put("sem_per_year",s1);
        privatevalue.put("own_campus",s2);
        privatevalue.put("credit_system",no);
        db.insert("private",null, privatevalue);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
