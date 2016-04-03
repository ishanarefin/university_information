package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void start(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        if(sharedPreferences.getString("current_user", "no_user").equals("no_user"))
        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        else
        {
            Intent intent = new Intent(this, OptionActivity.class);
            startActivity(intent);
        }

        finish();
    }
}
