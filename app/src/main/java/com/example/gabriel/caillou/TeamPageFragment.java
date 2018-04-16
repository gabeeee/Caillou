package com.example.gabriel.caillou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TeamPageFragment extends Fragment
{
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

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

        listView = view.findViewById(R.id.teamExpandableList);

        initData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        //System.out.println("List size: " + listAdapter.getGroupCount());

    }

    public void initData()
    {
        Team testTeam;
        List<String>names = new ArrayList<>();
        names.add("Gabriel");
        names.add("Cole");
        names.add("Justin");
        names.add("Taharka");
        names.add("Jamison");
        names.add("Jason");

        testTeam = new Team("Cool team", names, "This team is rad!!!");

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Team1");
        listDataHeader.add("Team2");
        listDataHeader.add("Team3");
        listDataHeader.add("Team4");
        listDataHeader.add("Team5");
        listDataHeader.add(testTeam.getTeamName());

        List<String> team1 = new ArrayList<>();
        team1.add("This is a expandable listview");

        List<String> team2 = new ArrayList<>();
        team2.add("shit");

        List<String> team3 = new ArrayList<>();
        team3.add("to");

        List<String> team4 = new ArrayList<>();
        team4.add("do");

        List<String> team5 = new ArrayList<>();
        team5.add("Teamy cinco");


        listHash.put(listDataHeader.get(0), team1);
        listHash.put(listDataHeader.get(1), team2);
        listHash.put(listDataHeader.get(2), team3);
        listHash.put(listDataHeader.get(3), team4);
        listHash.put(listDataHeader.get(4), team5);
        listHash.put(listDataHeader.get(5), testTeam.getStringMembers());



    }
}