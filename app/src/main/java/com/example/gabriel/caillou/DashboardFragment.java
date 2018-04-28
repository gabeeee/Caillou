package com.example.gabriel.caillou;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by gabriel on 3/31/18.
 */

public class DashboardFragment extends Fragment
{
    Date sDT = new Date();
    Calendar cal = Calendar.getInstance() ,Ecal = Calendar.getInstance();
    String start, end;



    SimpleDateFormat format = new SimpleDateFormat("EEE, MMM, d");
    SimpleDateFormat tFormat = new SimpleDateFormat("h:mm a");

    SimpleDateFormat jFormat = new SimpleDateFormat("EEE, MMM, d, h:mm a zzz");
    SimpleDateFormat test = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_dashboard, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        //Calendar cal = Calendar.getInstance();
        Button btn = view.findViewById(R.id.createEventButton);
        final TextView startDate = view.findViewById(R.id.startDate);
        final TextView startTime = view.findViewById(R.id.startTime);
        final TextView endDate = view.findViewById(R.id.endDate);
        final TextView endTime = view.findViewById(R.id.endTime);
        EditText eventTitle = view.findViewById(R.id.eventTitleTextBox);
        EditText eventDescription = view.findViewById(R.id.eventDescriptionTextBox);

        eventTitle.setText("");
        eventDescription.setText("");


        int month, year, day;

        startDate.setText(format.format(cal.getTime()));
        startTime.setText(tFormat.format(cal.getTime()));

        endDate.setText(format.format(cal.getTime()));
        endTime.setText(tFormat.format((cal.getTimeInMillis()+3600000L)));

        // Start Date Event
        startDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setDate(startDate);

            }
        });

        // End Date Event
        endDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EsetDate(endDate);
            }
        });

        // Start Time Event
        startTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setTime(startTime);
            }
        });

        // End Time Event
        endTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EsetTime(endTime);
            }
        });


        // Button Event
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Start: " + start);
                System.out.println("End: " + end);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setDate(final TextView startDate)
    {
        int year, day, month;
        year = cal.get(Calendar.YEAR);
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);

        DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                cal.set(year, month, dayOfMonth);
                startDate.setText(format.format(cal.getTime()));
                //System.out.println("Month: " + month + "Day: " + dayOfMonth + "Year: " + year);
                Log.d("Debug", "Month: " + month + " Day: " + dayOfMonth + " Year: " + year);

            }
        },year, month, day);
        dpd.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setTime(final TextView startTime)
    {
        final int hour, minute;
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                cal.set(Calendar.MINUTE, minute);

                startTime.setText(tFormat.format(cal.getTime()));
                Log.d("Debug", jFormat.format(cal.getTime()));
                System.out.println("Start: " + test.format(cal.getTime()));
                start = jFormat.format(cal.getTime());
            }
        },hour, minute, false);
        tpd.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void EsetDate(final TextView startDate)
    {
        int year, day, month;
        year = Ecal.get(Calendar.YEAR);
        day = Ecal.get(Calendar.DAY_OF_MONTH);
        month = Ecal.get(Calendar.MONTH);

        DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                Ecal.set(year, month, dayOfMonth);
                startDate.setText(format.format(Ecal.getTime()));
                //System.out.println("Month: " + month + "Day: " + dayOfMonth + "Year: " + year);
                Log.d("Debug", "Month: " + month + " Day: " + dayOfMonth + " Year: " + year);

            }
        },year, month, day);
        dpd.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void EsetTime(final TextView startTime)
    {
        final int hour, minute;
        hour = Ecal.get(Calendar.HOUR_OF_DAY);
        minute = Ecal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {

                Ecal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                Ecal.set(Calendar.MINUTE, minute);

                startTime.setText(tFormat.format(Ecal.getTime()));
                Log.d("Debug", jFormat.format(Ecal.getTime()));
                System.out.println("End: " + test.format(Ecal.getTime()));
                end = jFormat.format(Ecal.getTime());
            }
        },hour, minute, false);
        tpd.show();
    }
}
