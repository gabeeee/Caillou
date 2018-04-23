package com.example.gabriel.caillou;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class TeamCreation extends AppCompatActivity
{
    EditText teamNameTextBox, teamDescriptionTextBox, addMemberTextBox;
    Button teamSubmitButton, addMemberButton;
    String teamNameString, teamDescriptionString;
    Team teamCreated;
    Intent intent;
    android.support.v7.widget.Toolbar toolbar;
    ArrayAdapter<String> memberListAdapter;
    ListView memberListView;
    ArrayList<String> currentMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation);

        toolbar = findViewById(R.id.createTeamToolbar);
        teamNameTextBox = findViewById(R.id.teamNameTextBox);
        teamSubmitButton = findViewById(R.id.teamSubmitButton);
        teamDescriptionTextBox = findViewById(R.id.descriptionTextBox);
        addMemberTextBox = findViewById(R.id.addMemberTextBox);
        memberListView = findViewById(R.id.memberListVIew);

        //Set stirng array list for current members.
        currentMembers = new ArrayList<>();

        // Set arraydapater for memberlist to listen/update changes to list
        memberListAdapter = new ArrayAdapter<String>(this, R.layout.list_group, R.id.lblListHeader, currentMembers);
        memberListView.setAdapter(memberListAdapter);

        // Set toolbar title
        toolbar.setTitle("ApiCal: Create Team");
        toolbar.setTitleTextColor(Color.WHITE);

        // Grab data(String) from textbox team name and description.
        teamNameString = teamNameTextBox.getText().toString();
        teamDescriptionString = teamDescriptionTextBox.getText().toString();

        // Create Team
        teamCreated = new Team(teamNameString, teamDescriptionString);

        submitButton();
    }

    public void submitButton()
    {

        intent = new Intent();

        teamSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Grab data(String) from textbox team name and description.
                teamNameString = teamNameTextBox.getText().toString();
                teamDescriptionString = teamDescriptionTextBox.getText().toString();

                // Create Team
                teamCreated = new Team(teamNameString, teamDescriptionString);


                //System.out.println("STRING: " + teamNameString);

                //System.out.println("Team Name: " + teamCreated.getTeamName());
                //System.out.println("Team Description: " + teamCreated.getDescription());


                Toast.makeText(getApplicationContext(),  "Team Created: " + teamCreated.getTeamName(), Toast.LENGTH_LONG).show();

                teamCreated.setStringMembers(currentMembers);

                // Put created team back into intent for previous activity (TeamPageFragment.class)
                // Set result code to two for team to be stored in current user's team array.
                intent.putExtra("TEAM", teamCreated);
                setResult(2, intent);

                // Close Activity
                finish();
            }
        });
    }

    public void addMembers(View v)
    {
        String user;

        // Store text from textbox to string
        user = addMemberTextBox.getText().toString();

        // Clear text
        addMemberTextBox.setText("");

        // TODO: debug delete this
        System.out.println("USER: " + user);


        //teamCreated.addStringMember(user);

        currentMembers.add(user);

        memberListAdapter.notifyDataSetChanged();



    }
}
