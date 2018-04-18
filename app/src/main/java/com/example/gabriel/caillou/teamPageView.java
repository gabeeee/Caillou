package com.example.gabriel.caillou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class teamPageView extends AppCompatActivity
{
    TextView teamTitle;
    Bundle bundle;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_page_view);

        Intent intent = getIntent();
        bundle = intent.getExtras();

        // Get variables/objecs from intent
        user = bundle.getParcelable("USER");

        int position = bundle.getInt("POSITION");


        teamTitle = findViewById(R.id.teamTitleTextView);

        teamTitle.setText(user.getTeam(position).getTeamName());

        Team t = user.getTeam(position);
        System.out.println(t);
        System.out.println(t.getTeamName());
        t.setListMembers(new ArrayList<User>());

        t.addMember(new User("Joe", "Shmow"), new User("Jana", "Smowy"), new User("Shanet", "Jackson"), new User("Michael", "Bubelisa"));

        System.out.println("Reading the members....");
        for (int i = 0; i < t.getListMembers().size(); i++)
        {
            User u = t.getMember(i);
            System.out.println(u.getFirstName() + "    " + u.getLastName());
        }
        System.out.println("There are " + t.getListMembers().size() + " members that belong to team " + t.getTeamName());
        //System.out.println("TEAM: " + user.getTeam(position).getTeamName());
    }
}
