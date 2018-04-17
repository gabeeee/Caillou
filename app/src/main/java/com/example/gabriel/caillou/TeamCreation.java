package com.example.gabriel.caillou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TeamCreation extends AppCompatActivity
{
    EditText teamNameTextBox, teamDescriptionTextBox;
    Button teamSubmitButton;
    String teamNameString, teamDescriptionString;
    Team teamCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation);

        teamNameTextBox = findViewById(R.id.teamNameTextBox);
        teamSubmitButton = findViewById(R.id.teamSubmitButton);
        teamDescriptionTextBox = findViewById(R.id.descriptionTextBox);

        submitButton();
    }

    public void submitButton()
    {


        teamSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                teamNameString = teamNameTextBox.getText().toString();
                teamDescriptionString = teamDescriptionTextBox.getText().toString();

                teamCreated = new Team(teamNameString, teamDescriptionString);


                System.out.println("STRING: " + teamNameString);

                System.out.println("Team Name: " + teamCreated.getTeamName());
                System.out.println("Team Description: " + teamCreated.getDescription());
                Toast.makeText(getApplicationContext(),  "Team Created: " + teamCreated.getTeamName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
