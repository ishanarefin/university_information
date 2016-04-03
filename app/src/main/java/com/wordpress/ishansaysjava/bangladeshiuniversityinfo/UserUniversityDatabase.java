package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


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

        db.execSQL("create table private("
                + "_id integer primary key autoincrement,"
                + "uni_name text, "
                + "location text, "
                + "web_link text, "
                + "sem_per_year text, "
                + "own_campus text, cost integer,"
                + "credit_system text);");

        insertprivate(db, "Brac University", "Mohakhali,Dhaka", "http://bracu.ac.bd/", "3 (except Architechture and Pharmacy)", "No", "open", 5500);
        insertprivate(db, "Ahsanullah University of Science & Technology ", "Tejgaon,Dhaka", "http://www.aust.edu/index.htm", "2", "Yes", "closed", 2000);
        insertprivate(db, "North South University", "Basundhara,Dhaka", "http://www.northsouth.edu/", "3", "Yes", "open", 5500);
        insertprivate(db, "East West University", "Aftabnagar,Dhaka", "http://www.ewubd.edu/", "3", "Yes", "open", 4500);

        db.execSQL("create table department("
                + "uni_name text, "
                + "dept_name text, "
                + "seat text, "
                + "credit integer, "
                + "req_gpa real,"
                + "group_ text,"
                + "IEB text);");

        insertdepartment(db, "BRAC University", "Architechture", null, 201, "science", 8, "N");
        insertdepartment (db,"BRAC University","CSE",null,136,"science",8,"Y");
        insertdepartment (db,"BRAC University","EEE",null,136,"science",8,"N");
        insertdepartment (db,"BRAC University","CS",null,124,"science",8,"N");
        insertdepartment (db,"BRAC University","ECE",null,124,"science",8,"Y");
        insertdepartment (db,"BRAC University","Mathematics",null,127,"science",8,"N");
        insertdepartment (db,"BRAC University","Pharmacy",null,164,"science",8,"N");
        insertdepartment (db,"BRAC University","Law",null,135,"commerce",8,"N");
        insertdepartment (db,"BRAC University","Microbiology",null,136,"science",8,"N");
        insertdepartment (db,"BRAC University","Physics",null,132,"science",8,"N");
        insertdepartment (db,"BRAC University","Biotechnology",null,136,"science",8,"N");
        insertdepartment (db,"BRAC University","APE",null,130,"science",8,"N");
        insertdepartment (db,"BRAC University","BBA",null,130,"commerce",8,"N");
        insertdepartment (db,"BRAC University","Economics",null,120,"commerce",8,"N");

        insertdepartment (db,"East West University","CSE",null,140,"science",5,"Y");
        insertdepartment (db,"East West University","EEE",null,140,"science",5,"Y");

    }



    private void insertprivate(SQLiteDatabase db, String bracu1, String bracu, String s, String s1, String s2, String no, int cost) {
        ContentValues privatevalue=new ContentValues();
        privatevalue.put("uni_name",bracu1);
        privatevalue.put("location", bracu);
        privatevalue.put("web_link", s);
        privatevalue.put("sem_per_year", s1);
        privatevalue.put("own_campus", s2);
        privatevalue.put("credit_system", no);
        privatevalue.put("cost", cost);
        db.insert("private", null, privatevalue);
    }

    private void insertdepartment(SQLiteDatabase db, String s, String architechture, String o, int i, String science, int i1, String n) {
        ContentValues departmentvalue=new ContentValues();
        departmentvalue.put("uni_name",s);
        departmentvalue.put("dept_name",architechture);
        departmentvalue.put("seat",o);
        departmentvalue.put("credit",i);
        departmentvalue.put("group_", science);
        departmentvalue.put("req_gpa",i1);
        departmentvalue.put("IEB",n);
        db.insert("department", null, departmentvalue);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
