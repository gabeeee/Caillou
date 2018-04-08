package com.example.gabriel.caillou;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team
{
    // TODO: Might want to implement a Parcable inteface?
    // (Do we need to serialize this object?)

    private String teamName;
    private ArrayList<User> members;
    private String description;

    public Team (String teamName, User[] usersList)
    {
        this.teamName = teamName;

        members = new ArrayList<>();
        for (User users : usersList)
        {
            members.add(users);
        }
    }

    public String getTeamName()
    {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<User> getMembers() {
        return members;
    }
}
