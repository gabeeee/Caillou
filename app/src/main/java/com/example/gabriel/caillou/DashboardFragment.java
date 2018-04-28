package com.example.gabriel.caillou;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.InputType;
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
import java.util.concurrent.TimeUnit;

/**
 * Created by gabriel on 3/31/18.
 */

public class DashboardFragment extends Fragment
{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_dashboard, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Calendar cal = Calendar.getInstance();
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

        SimpleDateFormat format = new SimpleDateFormat("EEE, MMM, d");
        SimpleDateFormat tFormat = new SimpleDateFormat("h:mm a");

        startDate.setText(format.format(cal.getTime()));
        startTime.setText(tFormat.format(cal.getTime()));

        endDate.setText(format.format(cal.getTime()));
        endTime.setText(tFormat.format((cal.getTimeInMillis()+3600000L)));

        startDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setDate(startDate);

            }
        });

        endDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setDate(endDate);
            }
        });

        startTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setTime(startTime);
            }
        });

        endTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setTime(endTime);
            }
        });



    }

    public void setDate(final TextView startDate)
    {
        final Calendar cal = Calendar.getInstance();
        int year, day, month;
        year = cal.get(Calendar.YEAR);
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
         Date d;

        DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                cal.set(year, month, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("EEE, MMM, d");
                startDate.setText(format.format(cal.getTime()));
                d = new Date(year, month, dayOfMonth);

            }
        },year, month, day);
        dpd.show();
    }

    public void setTime(final TextView startTime)
    {
        final Calendar cal = Calendar.getInstance();
        final int hour, minute;
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute)
            {
                long hou = view.getHour();
                hou = TimeUnit.HOURS.toMillis(hou);
                long min = view.getMinute();
                min = TimeUnit.MINUTES.toMillis(min);

                Date d = new Date(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);

                //long milliseconds = (minute * 60000) + (hourOfDay * 360000);
                view.setHour(hourOfDay); view.setMinute(minute);
                cal.setTime(d);
                SimpleDateFormat tFormat = new SimpleDateFormat("h:mm a");
                startTime.setText(tFormat.format(cal.getTime()));
            }
        },hour, minute, false);
        tpd.show();
    }
    /*
    public void eventSearch()
    {

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALENDAR}, 1);
            return;
        }
        Cursor cursor = getContext().getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null);

        while (cursor.moveToNext())
        {
            if (cursor != null)
            {
                int id_1 = cursor.getColumnIndex(CalendarContract.Events._ID);
                int id_2 = cursor.getColumnIndex(CalendarContract.Events.TITLE);
                int id_3 = cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION);
                int id_4 = cursor.getColumnIndex(CalendarContract.Events.EVENT_LOCATION);
                int id_5 = cursor.getColumnIndex(CalendarContract.Events.DTSTART);
                int id_6 = cursor.getColumnIndex(CalendarContract.Events.DTEND);
                int id_7 = cursor.getColumnIndex(CalendarContract.Events.DURATION);

                Long id = cursor.getLong(id_1);
                String title = cursor.getString(id_2);
                String description = cursor.getString(id_3);
                String location = cursor.getString(id_4);
                Long start = cursor.getLong(id_5);
                Long end = cursor.getLong(id_6);
                String duration = cursor.getString(id_7);


                if (title.equals("Pants"))
                {
                    Calendar cal = Calendar.getInstance();
                    System.out.println(cal.get(Calendar.MONTH));
                    System.out.println(cal.get(Calendar.YEAR));
                    System.out.println("FOUND THAT EVENT");
                    System.out.println("Id: " + id + "  Title: " + title + "  Description: " + description + "  Location: " + location
                            + "start: " + start + " end: " + end + " duration: " + duration);

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SS");

                    cal.setTimeInMillis(start);
                    System.out.println("start: " + formatter.format(cal.getTime()));

                    cal.setTimeInMillis(end);
                    System.out.println("end: " + formatter.format(cal.getTime()));

                } else
                    System.out.println("ERROR");

            } else
            {
                System.out.println("cursor is null");
            }
        }
    }
*/

}
