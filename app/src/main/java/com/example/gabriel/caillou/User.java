package com.example.gabriel.caillou;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User implements Parcelable {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private List<Team> teams;

    public User() {
        teams = new ArrayList<>();
        teams.add(new Team("this", "pizza"));
    }

    public User(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String userName, String email, List<Team> teams) {
        this.userName = userName;
        this.email = email;
        this.teams = teams;
    }

    public User(String firstName, String lastName, String userName, String email, List<Team> teams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.teams = teams;
    }

    protected User(Parcel in)
    {
        firstName = in.readString();
        lastName = in.readString();
        userName = in.readString();
        email = in.readString();
        teams = in.createTypedArrayList(Team.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(userName);
        dest.writeString(email);
        dest.writeTypedList(teams);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel in)
        {
            return new User(in);
        }

        @Override
        public User[] newArray(int size)
        {
            return new User[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addTeam(Team... team) {

        Collections.addAll(teams, team);
    }

    public int teamSize() {
        return teams.size();
    }

    public List<Team> getTeamList() {
        return teams;
    }

    public void setTeamList(List<Team> teams) {
        this.teams = teams;
    }

    public Team getTeam(int index)
    {
        return teams.get(index);
    }

    public void removeTeam(Team t)
    {
        teams.remove(t);
        System.out.println(t.getTeamName() + " was removed.");
    }
}
