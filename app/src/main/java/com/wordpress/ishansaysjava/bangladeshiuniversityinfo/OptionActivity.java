package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }

    public void search(View view)
    {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void user_info(View view)
    {

    }

    public void feedback(View view) {
        Intent intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("current_username", "no_user");
        editor.commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
