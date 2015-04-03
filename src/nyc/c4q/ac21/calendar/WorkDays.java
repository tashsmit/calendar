package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class WorkDays
{

    /**
     * Builds a map from day of week to whether this is a work day.
     *
     * @return A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY', indicating whether each is a work day.
     */
    public static HashMap<Integer, Boolean> getWorkDays()
    {
        // FIXME: Write this.
        //Make the HashMap
        HashMap<Integer, Boolean> getWorkDays = new HashMap<Integer, Boolean>();
        getWorkDays.put(Calendar.SUNDAY, false);
        getWorkDays.put(Calendar.MONDAY, true);
        getWorkDays.put(Calendar.TUESDAY, true);
        getWorkDays.put(Calendar.WEDNESDAY, true);
        getWorkDays.put(Calendar.THURSDAY, true);
        getWorkDays.put(Calendar.FRIDAY, true);
        getWorkDays.put(Calendar.SATURDAY, false);
        return getWorkDays;
    }


}


