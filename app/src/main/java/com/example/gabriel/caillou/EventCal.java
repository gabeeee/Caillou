package com.example.gabriel.caillou;

public class EventCal
{
    private long evId;
    private String eventTitle;
    private String eventDescription;
    private String eventLocation;
    private long dStart;
    private long dEnd;
    private long tStart;
    private long tEnd;
    private String start;
    private String end;

    // This is with strings applied
    public EventCal(String eventTitle, String eventDescription, String start, String end, String eventLocation)
    {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.start = start;
        this.end = end;
        this.eventLocation = eventLocation;
    }

    public EventCal(long evId, String eventTitle, String eventDescription, String eventLocation, long dStart, long dEnd, long tStart, long tEnd)
    {
        this.evId = evId;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.dStart = dStart;
        this.dEnd = dEnd;
        this.tStart = tStart;
        this.tEnd = tEnd;
    }

    public EventCal(long evId, String eventTitle, String eventDescription, String eventLocation, long dStart, long dEnd)
    {
        this.evId = evId;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventLocation = eventLocation;
        this.dStart = dStart;
        this.dEnd = dEnd;
    }

    public long getEvId()
    {
        return evId;
    }

    public void setEvId(int evId)
    {
        this.evId = evId;
    }

    public String getEventTitle()
    {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle)
    {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription)
    {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation()
    {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation)
    {
        this.eventLocation = eventLocation;
    }

    public long getdStart()
    {
        return dStart;
    }

    public void setdStart(long dStart)
    {
        this.dStart = dStart;
    }

    public long getdEnd()
    {
        return dEnd;
    }

    public void setdEnd(long dEnd)
    {
        this.dEnd = dEnd;
    }

    public long gettStart()
    {
        return tStart;
    }

    public void settStart(long tStart)
    {
        this.tStart = tStart;
    }

    public long gettEnd()
    {
        return tEnd;
    }

    public void settEnd(long tEnd)
    {
        this.tEnd = tEnd;
    }

    public void setEvId(long evId)
    {
        this.evId = evId;
    }

    public String getStart()
    {
        return start;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public String getEnd()
    {
        return end;
    }

    public void setEnd(String end)
    {
        this.end = end;
    }
}
