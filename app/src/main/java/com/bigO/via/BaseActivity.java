package com.bigO.via;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import io.mapwize.mapwizesdk.core.MapwizeConfiguration;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        MapwizeConfiguration config = new MapwizeConfiguration.Builder(this, "82a148cb703ba7fc2f0e50bbb3e31902").build();
        MapwizeConfiguration.start(config);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.home:
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.bookmarks:
                intent = new Intent(this, BookmarksActivity.class);
                startActivity(intent);
                break;
            case R.id.schedules:
                intent = new Intent(this, SchedulesActivity.class);
                startActivity(intent);
                break;
            case R.id.settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.privacy:
                intent = new Intent(this, PrivacyPolicyActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                intent = new Intent(this, HelpAndFeedbackActivity.class);
                startActivity(intent);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
