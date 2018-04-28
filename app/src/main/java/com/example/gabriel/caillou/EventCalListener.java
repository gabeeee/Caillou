package com.example.gabriel.caillou;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class EventCalListener
{
    public static HashMap<Long, EventCal> eventMap = new HashMap<>();

    public static void eventUpdate(Context ctx, FragmentActivity fragAct)
    {

        if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(fragAct, new String[]{Manifest.permission.READ_CALENDAR}, 1);
            return;
        }
        Cursor cursor = ctx.getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null);

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

                Calendar cal = Calendar.getInstance();

                System.out.print("Id: " + id + "  Title: " + title + "  Description: " + description + "  Location: " + location);

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SS");

                cal.setTimeInMillis(start);
                System.out.print(" start: " + formatter.format(cal.getTime()));

                cal.setTimeInMillis(end);
                System.out.println(" end: " + formatter.format(cal.getTime()));

            } else
                System.out.println("ERROR");

        }
    }

    public static void eventUpdate(Context ctx, FragmentActivity fragAct, ArrayList<EventCal> eventList, HashMap<Long, EventCal> eventMap)
    {

        if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(fragAct, new String[]{Manifest.permission.READ_CALENDAR}, 1);
            return;
        }
        Cursor cursor = ctx.getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null);

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

                EventCal event = new EventCal(id, title, description, location, start, end);
                eventList.add(event);
                eventMap.put(event.getEvId(), event);

                Calendar cal = Calendar.getInstance();

                System.out.print("Id: " + id + "  Title: " + title + "  Description: " + description + "  Location: " + location);

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SS");

                cal.setTimeInMillis(start);
                System.out.print(" start: " + formatter.format(cal.getTime()));

                cal.setTimeInMillis(end);
                System.out.println(" end: " + formatter.format(cal.getTime()));

            } else
                System.out.println("ERROR");

        }
    }
}

