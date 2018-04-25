package com.example.gabriel.caillou;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TeamCalendarFragment extends Fragment
{
    DatePicker datePickerResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_team_calendar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        User user = getArguments().getParcelable("USER");

        datePickerResult = view.findViewById(R.id.DatePickerTag);

        final TextView tab2 = view.findViewById(R.id.teamNamePlaceHolder);
        tab2.setText(user.getLastName());

        tab2.setOnClickListener(new View.OnClickListener()
        {
            @TargetApi(Build.VERSION_CODES.N)
            public void onClick(View v)
            {
                Calendar cal = Calendar.getInstance();
                /*int day = cal.get(Calendar.DAY_OF_MONTH), month = cal.get(Calendar.MONTH), year = cal.get(Calendar.YEAR);

                DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                        tab2.setText(Integer.toString(dayOfMonth));
                    }
                }, year, month, day);
                dpd.show();
*/

                final int hour = cal.get(Calendar.HOUR_OF_DAY), minute = cal.get(Calendar.MINUTE);
                TimePickerDialog tpd = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {
                        tab2.setText(Integer.toString(hourOfDay));
                    }
                }, hour, minute, false);
                tpd.setTitle("Pick a time");
                tpd.show();

                /*Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, "Yoga")
                        .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                        .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
                startActivity(intent);*/
            }
        });
    }
}

