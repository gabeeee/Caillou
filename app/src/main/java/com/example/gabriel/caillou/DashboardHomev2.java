package com.example.gabriel.caillou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class DashboardHomev2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView userNameNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_homev2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set userNameTextView
        userNameNavBar = (TextView) findViewById(R.id.userNameHeaderNavBar);

        // Checking intent grab
        Intent intent = getIntent();
        User user = intent.getParcelableExtra("Example User");

        userNameNavBar = (TextView) findViewById(R.id.userNameHeaderNavBar);

        if (userNameNavBar == null)
            System.err.println("userNameNavBar is NULL");
        else
            System.out.println(Object.class.isInstance(userNameNavBar));

        System.out.println("Dashboardv2 first and last: " + user.getFirstName() + "   " + user.getLastName());

        // Bottom Navigation
        BottomNavigationView bottomNavigation = findViewById(R.id.navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                public boolean onNavigationItemSelected(MenuItem item)
                {
                    Fragment fragment = null;

                    switch(item.getItemId())
                    {
                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.navigation_dashboard:
                            fragment = new DashboardFragment();
                            break;

                        case R.id.navigation_notifications:
                            fragment = new NotificationsFragment();
                            break;
                    }

                    return loadFragment(fragment);
                }
            });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    // Method that loads the fragment
    private boolean loadFragment(Fragment fragment)
    {
        if (fragment != null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment).commit();
            return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard_homev2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
