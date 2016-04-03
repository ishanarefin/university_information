package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class PrivateSearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_search);
    }

    public void search(View view)
    {
        String dept = null;
        int cost = 0;
        double minGPA = 0.0;
        String ieb = null;
        String campus = null;

        Spinner dept_spinner = (Spinner) findViewById(R.id.dept);
        switch (dept_spinner.getSelectedItemPosition())
        {
            case 0: dept = "Physics";
                break;
            case 1: dept = "Chemistry";
                break;
            case 2: dept = "Math";
                break;
            case 3: dept = "Statistics";
                break;
            case 4: dept = "Pharmacy";
                break;
            case 5: dept = "CSE";
                break;
            case 6: dept = "EEE";
                break;
            case 7: dept = "Marketing";
                break;
            case 8: dept = "Management";
                break;
            case 9: dept = "Microbiology";
                break;
            case 10: dept = "Accounting";
                break;
            case 11: dept = "Architecture";
                break;
            case 12: dept = "CE";
                break;
            case 13: dept = "ME";
                break;
            case 14: dept = "IPE";
                break;
            case 15: dept = "Urban";
                break;
            case 16: dept = "Economics";
                break;
        }

        Spinner cost_spinner = (Spinner) findViewById(R.id.cost);
        switch (cost_spinner.getSelectedItemPosition())
        {
            case 0: cost = 4500;
                break;
            case 1: cost = 5000;
                break;
            case 2: cost = 5500;
                break;
        }

        Spinner campus_spinner = (Spinner) findViewById(R.id.campus);
        switch (campus_spinner.getSelectedItemPosition())
        {
            case 0: campus = "Yes";
                break;
            case 1: campus = "No";
                break;

        }

        Spinner ieb_spinner = (Spinner) findViewById(R.id.ieb);
        switch (ieb_spinner.getSelectedItemPosition())
        {
            case 0: ieb = "Y";
                break;
            case 1: ieb = "N";
                break;

        }

        Spinner minGpa_spinner = (Spinner) findViewById(R.id.minGPA);
        switch (minGpa_spinner.getSelectedItemPosition())
        {
            case 0: minGPA = 5;
                break;
            case 1: minGPA = 7.5;
                break;
            case 2: minGPA = 8.0;
                break;
            case 3: minGPA = 10;
                break;
        }

//        String query = "select d.uni_name, location, sem_per_year, credit_system, web_link, dept_name  from department d, private p where d.uni_name = p.uni_name and dept_name = '"
//                +dept+"' and cost <= "+cost+" and own_campus = '"+campus+"' and IEB = '"+ieb+"'  and req_gpa <= "+minGPA;
        Log.i("testerbangla", String.valueOf(cost));
        String query = "select d.uni_name, location, sem_per_year, credit_system, web_link, dept_name  from department d, private p where d.uni_name = p.uni_name  and dept_name = \'"+dept+
                "\' and cost <= "+cost+" and own_campus = \'"+campus+"\' and IEB = \'"+ieb+"\' and req_gpa <= "+minGPA;


        SQLiteOpenHelper useruniversity_dbhelper = new UserUniversityDatabase(this);
        SQLiteDatabase db = useruniversity_dbhelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        String res = "";
        if(cursor.moveToFirst())
        {
            String uni_name = cursor.getString(0);
            String location = cursor.getString(1);
            String sem_per_year = cursor.getString(2);
            String credit_system = cursor.getString(3);
            String web_link = cursor.getString(4);

            String temp = "University: "+uni_name+"\nDeptartment: "+cursor.getString(5)+"\nLocation: "+location+"\nSemester per year: "+sem_per_year+"\nCredit System: "+credit_system
                    +"\nWeb Link: "+web_link+"\n.......|.........\n";
            res += temp;
            Log.i("jani na", res+"katukuti1");
        }
        else  Log.i("jani na", res+"katukuti122222");

        int c =0;
        while(true)
        {
            c++;
            cursor.moveToNext();
            if(cursor.isAfterLast())
            {
                break;
            }
            String uni_name = cursor.getString(0);
            String location = cursor.getString(1);
            String sem_per_year = cursor.getString(2);
            String credit_system = cursor.getString(3);
            String web_link = cursor.getString(4);

            String temp = "University: "+uni_name+"\nDeptartment: "+cursor.getString(5)+"\nLocation: "+location+"\nSemester per year: "+sem_per_year+"\nCredit Systemp: "+credit_system
                    +"\nWeb Link: "+web_link+"\n.......|.........\n";
            res += temp;
            Log.i("jani na", res+"\n"+c);

            if(cursor.isLast()) {
                break;
            }
        }

        cursor.close();
        db.close();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Search Result:");
        builder.setMessage(res);
        builder.show();

        TextView myTextView = new TextView(this);
        ScrollView scroll = new ScrollView(this);
        builder.setView(myTextView);
        builder.setView(scroll);

    }

}
