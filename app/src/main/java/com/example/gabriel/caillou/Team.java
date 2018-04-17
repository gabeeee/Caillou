package com.example.gabriel.caillou;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Team
{
    // TODO: Might want to implement a Parcable inteface?
    // (Do we need to serialize this object?)

    private String teamName;
    private List<User> members;
    private String description;
    private List<String> stringMembers;

    //TODO: calendar
    //private Calendar;


    public Team(String teamName, String description, List<User> members)
    {
        this.teamName = teamName;
        this.members = members;
        this.description = description;

        stringMembers = new ArrayList<>();

        for(User u : members)
            stringMembers.add(u.getFirstName());
    }

    public List<String> getStringMembers()
    {
        return stringMembers;
    }

    public void setStringMembers(List<String> stringMembers)
    {
        this.stringMembers = stringMembers;
    }

    public Team(String teamName, List<String> stringMembers, String description)
    {
        this.teamName = teamName;
        this.description = description;
        this.stringMembers = stringMembers;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public List<User> getMembers()
    {
        return members;
    }

    public void setMembers(List<User> members)
    {
        this.members = members;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
