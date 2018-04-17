package com.example.gabriel.caillou;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_teampage, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Test settings
        final String[] teamNames = new String[]{"Red Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team", "Blue Team", "Green Team", "Purple Team", "Orange Team"};
        //final String[] teamNames = new String[0];
        // end test setttings

        listView = view.findViewById(R.id.teamList);

        /*
        if (user == null) // size of list as well
        {
            listView.setVisibility(View.GONE);
        } */

        final TextView text = view.findViewById(R.id.lblListHeader);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_group, R.id.lblListHeader, teamNames);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0:
                        System.out.println(teamNames[0]);
                        Intent intent = new Intent(getActivity(), SignUpActivity.class);
                        startActivity(intent);
                        //Color.RED

                        break;
                    case 1:
                        System.out.println(teamNames[1]);
                        break;
                    case 2:
                        System.out.println(teamNames[2]);
                        break;
                    case 3:
                        System.out.println(teamNames[3]);
                        break;
                    default:
                        System.err.println("OUT");
                        break;
                }
            }
        });

    }
}