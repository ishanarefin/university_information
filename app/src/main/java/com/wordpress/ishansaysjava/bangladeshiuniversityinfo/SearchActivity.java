package com.wordpress.ishansaysjava.bangladeshiuniversityinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void privateSearch(View view)
    {
        Intent intent = new Intent(this, PrivateSearchActivity.class);
        startActivity(intent);
        finish();
    }
}
