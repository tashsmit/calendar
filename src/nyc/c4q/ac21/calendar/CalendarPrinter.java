package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarPrinter
{

    /**
     * Prints a calendar for a month.
     *
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     *
     * For example, for 2015-04-03, prints this:
     *
     *     April 2015
     *                  1   2   3*  4
     *      5   6   7   8   9  10  11
     *     12  13  14  15  16  17  18
     *     19  20  21  22  23  24  25
     *     26  27  28  29  30
     *
     * @param date
     *   The date containing the month to print.
     */
    public static void printMonthCalendar(Calendar date) {
        //System.out.println(date);
        System.out.println();

        HashMap <Integer, String> month = DateTools.getMonthNames(); //contains names of months

        int currentDay = date.get(Calendar.DAY_OF_MONTH);
        int currentMonth = date.get(Calendar.MONTH);
        int currentYear = date.get(Calendar.YEAR);

        Calendar currentDayToPrint = Calendar.getInstance();
        currentDayToPrint.set(currentYear,currentMonth,1);//will all the calendar to print starting the first day of the month


        System.out.println(month.get(currentMonth) +  " " + currentYear); // Prints out current month and year

        int spaces = currentDayToPrint.get(Calendar.DAY_OF_WEEK);

        for(int i = 1; i < spaces; i++) { //will add spaces to first week line depending on what day the first day of the month starts on.
            System.out.print("    ");
        }

        while (true) { //prints calendar
            int day = currentDayToPrint.get(Calendar.DAY_OF_MONTH);

            if(day < 10) {//will determine whether it needs to add an extra space to number for alignment.
                System.out.print(" ");
            }

            if(day == currentDay) { //will print a star next to current day
                System.out.print(" *");
            } else {
                System.out.print("  ");
            }

            System.out.print(day);

            if(currentDayToPrint.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }

            Calendar nextDay = DateTools.getNextDay(currentDayToPrint);
            int nextDayMonth = nextDay.get(Calendar.MONTH);
            if(nextDayMonth != currentMonth) {// checks to see if new month has started
                break;
            }
            currentDayToPrint = nextDay;
        }
    }

}