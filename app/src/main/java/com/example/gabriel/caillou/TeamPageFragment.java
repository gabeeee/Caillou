package com.example.gabriel.caillou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TeamPageFragment extends Fragment
{
    private ListView listView;
    //private ArrayAdapter<?> listAdapter;
    //private List<String> listDataHeader;
    private User user;
    private FloatingActionButton fab;
    private Team teamCreated;
    private List<String> teamNames;
    private ArrayAdapter<String> listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_teampage, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        user = getArguments().getParcelable("USER");

        teamNames = new ArrayList<>();

        List<Team> t = user.getTeamList();

        for (Team z : t)
            teamNames.add(z.getTeamName());

        listView = view.findViewById(R.id.teamList);

        final TextView text = view.findViewById(R.id.lblListHeader);

        listAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_group, R.id.lblListHeader, teamNames);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position >= 0 && teamNames.size() >= teamNames.size())
                {
                    // System.out.println("teamNames: " + teamNames.get(position));
                    Intent intent = new Intent(getContext(), teamPageView.class);
                    intent.putExtra("USER", user);
                    intent.putExtra("POSITION", position);
                    startActivity(intent);



                    /*intent.("STRINGTEAMS", teamNames);
                    intent.putExtra("LISTADAPTER", listAdapter);
                    Team t = user.getTeam(position);
                    System.out.println("Team name: " + t.getTeamName());
                    teamNames.remove(t.getTeamName());
                    user.removeTeam(t);
                    listAdapter.notifyDataSetChanged();*/
                }
            }
        });

        fab = view.findViewById(R.id.teamFloatingActionButton);

        // Call (TeamCreation.class)
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int resultCode = 0;
                Intent intent = new Intent(getContext(), TeamCreation.class);
                startActivityForResult(intent, resultCode);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO: Delete when finished debugging...
        System.out.println("onActivityResult has been called.");

        if (resultCode == 2)
        {
            // Grab Team object from intent(TeamCreation.class) changes.
            teamCreated = data.getExtras().getParcelable("TEAM");

            //TODO: Delete when finished debugging...
            System.out.println("DATA FROM PARCEL: " + teamCreated);
            System.out.println("DATA: " + teamCreated.getTeamName());

            // Add teamCreated name to teamNames arraylist.
            // Follow by adding createdTeam to users list of teams.
            teamNames.add(teamCreated.getTeamName());
            user.addTeam(teamCreated);

            // Update adapter for changes in list<String> teamNames which reflects
            // upon ListView ui.
            listAdapter.notifyDataSetChanged();
        }
    }
}