package com.example.gabriel.caillou;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class teamPageView extends AppCompatActivity
{
    private TextView teamTitle;
    private Bundle bundle;
    private User user;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_page_view);

        Intent intent = getIntent();
        bundle = intent.getExtras();
        toolbar = findViewById(R.id.teamViewToolbar);
        setSupportActionBar(toolbar);

        // Get variables/object from intent
        user = bundle.getParcelable("USER");

        int position = bundle.getInt("POSITION");

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Calendar"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(getResources().getColorStateList(android.R.color.white));

        System.out.println("position: " + position);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final com.example.gabriel.caillou.PagerAdapter adapter = new com.example.gabriel.caillou.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), user, position);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });


        /*// Get variables/object from intent
        user = bundle.getParcelable("USER");

        int position = bundle.getInt("POSITION");*/


        // Set toolbar title
        toolbar.setTitle("Team: " + user.getTeam(position).getTeamName());
        toolbar.setTitleTextColor(Color.WHITE);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getGroupId();
        if (id == R.id.action_settings)
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_team_page_view_v2, menu);
        return true;
    }
}
