package com.example.gabriel.caillou;

import android.app.DatePickerDialog;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

public class TeamCalendarFragment extends Fragment
{
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

        final TextView tab2 = view.findViewById(R.id.teamNamePlaceHolder);
        tab2.setText(user.getLastName());

        tab2.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v)
            {

                // INTERVAL TEST FOR DATE AND TIME PICKER
                /*Calendar cal = Calendar.getInstance();

                System.out.println("Year: " + cal.get(Calendar.YEAR));
                System.out.println("Month: " + cal.get(Calendar.MONTH));
                System.out.println("Date: " + cal.get(Calendar.DATE));

                int year = cal.get(Calendar.YEAR), month = cal.get(Calendar.MONTH), day = cal.get(Calendar.DATE);

                final DatePickerDialog dpd = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                        System.out.println("DIALOG: " + year + " " + month + " " + dayOfMonth);
                    }
                }, year, month, day);
                dpd.show();
                System.out.println("OUTPUT: " + year + month + day);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tab2.setText("Tester");
                        dpd.show();
                    }
                },  5000);*/


                /*DatePickerDialog dpd2 = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                    {
                        System.out.println("DIALOG: " + year + " " + month + " " + dayOfMonth);
                    }
                }, year, month, day);
                dpd2.show();

                System.out.println("OUTPUT: " + year + month + day);*/



                /*Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                Uri test = intent.getData();
                startActivity(intent);

                System.out.println("Calendar: " + test.getQuery() + " or " + intent.getDataString());*/


                /*long startMillis = 0;
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent2 = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent2);*/

                /*long startMillis = System.currentTimeMillis();
                Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                ContentUris.appendId(builder, startMillis);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder.build());
                startActivity(intent);

                System.out.println("Login: " + intent.getData());*/


            }
        });
    }
}
