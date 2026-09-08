PROBELM STATEMENT:
/* Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
 

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31st, 2019.*/

PROGRAM:
class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonths[1] = 29;
        }
        int dayCount = 0;
        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonths[i];
        }
        
        // Add the days of the current month
        return dayCount + day;
    }
}
