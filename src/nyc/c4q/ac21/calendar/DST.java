package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */
public class DST {


    /**
     * Populates hash maps with the start and end time for DST in each year.
     *
     * @param startDates A hash map of the start date of DST in each year.
     * @param endDates   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates) {

        int intNum = 0;

        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");

        // Each line is of the form "sign,startDate,endDate".  Split it.
        for (String line : lines) {
            int comma1 = line.indexOf(',');
            int minus1 = line.indexOf('-');
            int minus2 = line.indexOf(minus1, '-');

            String year = line.substring(0, minus1);
            Integer intYear = Integer.valueOf(year);

            //intNum ++;

            String start = line.substring(0, comma1);
            Calendar startDate = DateTools.parseDate(start);

            String end = line.substring(comma1 + 1);
            Calendar endDate = DateTools.parseDate(end);

            //Integer num = intNum;

            startDates.put(intYear, startDate);
            endDates.put(intYear, endDate);

        }

        // FIXME: Write this code!
        // Each line in the file is of the form "start,end", where both dates
        // are in the same year.  This represents the dates DST starts and
        // ends in this year.
        //
        // Use DateTools.parseDate.
    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     *
     * @param date The date to check.
     * @return True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date) {

        boolean found = false;

        // Create hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populate them.
        DST.getDSTDates(dstStartDates, dstEndDates);

        // FIXME: Write this code!

        String strDate = DateTools.formatDate(date);
        int minus1 = strDate.indexOf("-");
        String year = strDate.substring(0, minus1);
        Integer intYear = Integer.valueOf(year);

        if (dstStartDates.containsKey(intYear)) {

            Calendar startDate = dstStartDates.get(intYear);
            Calendar endDate = dstEndDates.get(intYear);

             if (date.compareTo(startDate) != -1 && date.compareTo(endDate) != 1)
                 found = true;
        }

        else
            found = false;

        return found;

    }
}
