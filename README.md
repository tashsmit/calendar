# Calendar

In this project, we'll write some code to work with dates, including days of the week and holidays.  You'll write a program that asks for a date and prints a number of important facts about the date.


## Setup

1. Each team should fork the repository.

1. Each team member should clone the forked repository and work there.

1. Open (not import) the project in IntelliJ.

1. Review the code to get a general understanding of the code that's already there. 

## Tasks

Look for the `FIXME` comments in the code.  You'll have to do the following:

- Finish `DateTools.getDaysInYear`, which constructs a list of days in a year.  Use `getNextDay` to help you.

- Write `DateTools.getDaysOfWeekNames`, which builds a hash map from codes for the day of the week to day of week names.  Use the codes from `java.util.Calendar`, such as `java.util.Calendar.MONDAY`.

- Write `WorkDays.getWorkDays`, which builds a hash map from codes for the day of teh week to whether it is a work day or not.

- Write `Holidays.getHolidays`, which returns a hash map from holiday date to holiday name for holidays between 1980 and 2020.  This method uses holiday data stored in the file `holidays.csv`.  We've provided a method `FileTools.readLinesFromFile` that reads the contents of a file to an array list of lines.

- 
