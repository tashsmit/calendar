package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("date? ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if(date == null)
        {
            return;
        }
        System.out.println();

        System.out.println("date:              " + DateTools.formatDate(date));

        // FIXME: Write the rest of this method!

        // 1. Show the day of the week.
        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        for (Integer days : dayOfWeekNames.keySet())
        {
            if(days.equals(date.get(Calendar.DAY_OF_WEEK))) {
                System.out.println("day of week:       " + dayOfWeekNames.get(days));
            }
        }

        // 2. Show whether this is a work day.
        boolean value = false;
        HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        for(Integer days : workDays.keySet()) //iterate through the workday keys in hashmap
        {
            if(days.equals(date.get(Calendar.DAY_OF_WEEK))) //if a match is found
            {
                value = workDays.get(days); //get value of key and save it to value variable
                break; //leave loop
            }
        }
        //determine if it is a work day or not, then print out appropriate message
       System.out.println("work day:          " + value);


        // 3. Show whether this is a national holiday, and if so, which.
        HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        if(holidays.containsKey(date))
        {
            System.out.println("national holiday:  " + holidays.get(date));
        }
        else
        {
            System.out.println("national holiday:  " + "not a national holiday");
        }
        // ...

        // 4. Show whether this date is in DST.
        boolean isDST = DST.isDST(date);
        System.out.println("is DST:            " + isDST);


        // 5. Show the zodiac sign.
        String zodiacSign = Zodiac.getZodiacSign(date);
        System.out.println("Zodiac sign:       " + zodiacSign);

        // 6. Print out the monthly calendar.
        CalendarPrinter.printMonthCalendar(date);

    }
}
