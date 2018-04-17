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
    private ArrayAdapter<?> listAdapter;
    //private List<String> listDataHeader;
    private User user;
    private HashMap<String, List<String>> listHash;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_teampage, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<String> teamNames = new ArrayList<>();

        listView = view.findViewById(R.id.teamList);

        final TextView text = view.findViewById(R.id.lblListHeader);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_group, R.id.lblListHeader, teamNames);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && teamNames.size() >= teamNames.size())
                {
                    System.out.println("teamNames: " + teamNames.get(position));
                }
            }
        });

        fab = view.findViewById(R.id.teamFloatingActionButton);

        // Create Team Page
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(getContext(), TeamCreation.class);
                startActivity(intent);
                Toast.makeText(getContext( ), "Team Created", Toast.LENGTH_SHORT).show();

            }
        });
    }
}