package nyc.c4q.ac21.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class DateTools {
    /**
     * Formats a 'Calendar' object as a date.
     * @param cal
     *   The object to format.
     * @return
     *   The date in "YYYY-MM-DD" format.
     */
    public static String formatDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cal.getTime());
    }

    /**
     * Parses a date in "YYYY-MM-DD" format.
     * @param date
     *   The date in "YYYY-MM-DD" format.
     * @return
     *   The date it represents, or null if the date is incorrectly formatted.
     */
    public static Calendar parseDate(String date) { // -- makes sure input is in proper format
        if (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-') {
            try {
                int year = Integer.valueOf(date.substring(0, 4));
                int month = Integer.valueOf(date.substring(5, 7));
                int dayOfMonth = Integer.valueOf(date.substring(8, 10));
                if (year > 0 && year <= 9999
                        && month >= 1 && month <= 12
                        && dayOfMonth >= 1 && dayOfMonth <= 31) {
                    // Allocate directly instead of using Calendar.getInstance() so that we don't
                    // set the time fields and leave them initialized to zero.
                    return new GregorianCalendar(year, month - 1, dayOfMonth);
                }
            } catch (NumberFormatException exception) {
                // Fall through. -- b/c it is not in proper format
            }
        }
        // Didn't work.
        return null;
    }

    /**
     * Returns the following day.
     */
    public static Calendar getNextDay(Calendar cal) {
        // 'Calendar' is mutable, but we don't want to change it.  Instead, create a copy and change that.
        cal = (Calendar) cal.clone();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal;
    }

    /**
     * Builds and returns a map from integers representing days of the week to the names of the days of the week.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY' with corresponding day names as values.
     */
    public static HashMap<Integer, String> getDayOfWeekNames() {
        HashMap<Integer, String> names = new HashMap<Integer, String>();
        names.put(Calendar.SUNDAY, "Sunday");
        names.put(Calendar.MONDAY, "Monday");
        names.put(Calendar.TUESDAY, "Tuesday");
        names.put(Calendar.WEDNESDAY, "Wednesday");
        names.put(Calendar.THURSDAY, "Thursday");
        names.put(Calendar.FRIDAY, "Friday");
        names.put(Calendar.SATURDAY, "Saturday");

        // FIXME: Write this.
        return names;
    }

    /**
     * Builds and returns a map from integers representing days of the month to the names of the days of the month.
     * @return
     * A map with keys 'Calendar.JANUARY' through 'Calendar.DECEMBER' with corresponding month names as values.
     */
    public static HashMap<Integer, String> getMonthNames() {
        HashMap<Integer, String> names = new HashMap<Integer, String>();
        names.put(Calendar.JANUARY, "January");
        names.put(Calendar.FEBRUARY, "February");
        names.put(Calendar.MARCH, "March");
        names.put(Calendar.APRIL, "April");
        names.put(Calendar.MAY, "May");
        names.put(Calendar.JUNE, "June");
        names.put(Calendar.JULY, "July");
        names.put(Calendar.AUGUST, "August");
        names.put(Calendar.SEPTEMBER, "September");
        names.put(Calendar.OCTOBER, "October");
        names.put(Calendar.NOVEMBER, "November");
        names.put(Calendar.DECEMBER, "December");

        // FIXME: Write this.
        return names;  // Change this!
    }

    public static void main(String[] args) {
        System.out.println(getDayOfWeekNames());
        System.out.println(getDayOfWeekNames().get(Calendar.SUNDAY));
        System.out.println(getMonthNames());
        System.out.println(getMonthNames().get(Calendar.JANUARY));
    }

}
