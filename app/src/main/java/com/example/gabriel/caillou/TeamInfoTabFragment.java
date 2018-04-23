package com.example.gabriel.caillou;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TeamInfoTabFragment extends Fragment
{
    private ListView memberListView;
    private ArrayAdapter<String> listAdapter;
    private List<String> members;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_team_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Unpackage bundle that was sent.
        User user = getArguments().getParcelable("USER");
        int position = getArguments().getInt("POSITION");

        TextView teamName = view.findViewById(R.id.teamNamePlaceHolder);
        teamName.setText(user.getTeam(position).getTeamName());

        TextView numOfMembers = view.findViewById(R.id.numMemberLbl);
        int size = user.getTeam(position).getStringMembers().size();
        numOfMembers.setText(Integer.toString(size));

        TextView description = view.findViewById(R.id.descriptionOutput);
        description.setText(user.getTeam(position).getDescription());

        memberListView = view.findViewById(R.id.teamInfoMemberList);
        members = user.getTeam(position).getStringMembers();
        listAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, R.id.lblListItem, members);
        memberListView.setAdapter(listAdapter);



    }
}
