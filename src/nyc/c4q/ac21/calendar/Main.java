package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // FIXME: Write this!
        Scanner scanner = new Scanner(System.in);
        System.out.print("date: ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if (date == null)
            return;

        System.out.println(DateTools.formatDate(date));

        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        System.out.println("day of week: " + dayOfWeekNames.get(dayOfWeek));

        HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        System.out.println("work day: " + workDays.get(dayOfWeek));

        HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        String holiday = holidays.get(date);
        if (holiday == null)
            holiday = "none";
        System.out.println("national holiday: " + holiday);

        boolean isDST = DST.isDST(date);
        System.out.println("is DST: " + isDST);

        System.out.println("Zodiac sign: " + Zodiac.getZodiacSign(date));

        System.out.println();
        CalendarPrinter.printMonthCalendar(date);
    }
}
