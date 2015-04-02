package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Holidays {

    /**
     * Loads holidays from a file.
     *
     * @param holidayType
     *   The type of holiday.  Use "National holiday" for U.S. federal holidays.
     * @return
     *   A map from date to holiday name for holidays.
     */
    public static HashMap<Calendar, String> getHolidays(String holidayType) {
        ArrayList<String> lines = FileTools.readLinesFromFile("holidays.csv");
        // Each line is of the form "date,name,type", where "date" is a date
        // in YYYY-MM-DD format, "name" is the holiday name, and "type" is
        // the holiday type.  Include only those lines where "type" matches
        // the 'holidayType' parameter.

        HashMap<Calendar, String> holidays = new HashMap<Calendar, String>();
        for (String line : lines) {

            // Separating data within each line.
            int comma1 = line.indexOf(',');
            String date = line.substring(0, comma1);
            int comma2 = line.indexOf(',', comma1 + 1);
            String name = line.substring(comma1 + 1, comma2);
            String type = line.substring(comma2 + 1);

            // Adding only the lines where type matches holidayType.
            if (type.equals(holidayType)) {
                holidays.put(DateTools.parseDate(date), name);
            }

        }
        return holidays;
    }

}
