package com.example.gabriel.caillou;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class TeamCreation extends AppCompatActivity
{
    EditText teamNameTextBox, teamDescriptionTextBox;
    Button teamSubmitButton;
    String teamNameString, teamDescriptionString;
    Team teamCreated;
    Intent intent;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation);

        toolbar = findViewById(R.id.createTeamToolbar);
        teamNameTextBox = findViewById(R.id.teamNameTextBox);
        teamSubmitButton = findViewById(R.id.teamSubmitButton);
        teamDescriptionTextBox = findViewById(R.id.descriptionTextBox);

        // Set toolbar title
        toolbar.setTitle("ApiCal: Create Team");
        toolbar.setTitleTextColor(Color.WHITE);

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

                // Put created team back into intent for previous activity (TeamPageFragment.class)
                // Set result code to two for team to be stored in current user's team array.
                intent.putExtra("TEAM", teamCreated);
                setResult(2, intent);

                // Close Activity
                finish();
            }
        });
    }
}
