package com.example.gabriel.caillou;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team implements Parcelable
{
    // TODO: Might want to implement a Parcable inteface?
    // (Do we need to serialize this object?)

    private String teamName;
    private List<User> members;
    private String description;
    private List<String> stringMembers;

    //TODO: calendar
    //private Calendar;

    public Team()
    {
        members = new ArrayList<>();
        stringMembers = new ArrayList<>();
    }
    public Team(String teamName)
    {
        this.teamName = teamName;
    }

    public Team(String teamName, String description)
    {
        this.teamName = teamName;
        this.description = description;
        stringMembers = new ArrayList<>();
    }

    public Team(String teamName, String description, List<User> members)
    {
        this.teamName = teamName;
        this.members = members;
        this.description = description;

        stringMembers = new ArrayList<>();

        for (User u : members)
            stringMembers.add(u.getFirstName());
    }

    public Team(String teamName, List<String> stringMembers, String description)
    {
        this.teamName = teamName;
        this.description = description;
        this.stringMembers = stringMembers;
    }

    protected Team(Parcel in) {
        teamName = in.readString();
        members = in.createTypedArrayList(User.CREATOR);
        description = in.readString();
        stringMembers = in.createStringArrayList();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public List<String> getStringMembers()
    {
        return stringMembers;
    }

    public void setStringMembers(List<String> stringMembers)
    {
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

    public List<User> getListMembers()
    {
        return members;
    }

    public void setListMembers(List<User> members)
    {
        this.members = members;
    }

    public void addMember(User... users)
    {
        Collections.addAll(members, users);
    }

    public void addStringMember(String... userString)
    {
        for (String s : userString)
            stringMembers.add(s);
        // Might have to check if theirs a users that exists maybe?
    }

    public User getMember(int position)
    {
        return members.get(position);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamName);
        dest.writeTypedList(members);
        dest.writeString(description);
        dest.writeStringList(stringMembers);
    }
}
