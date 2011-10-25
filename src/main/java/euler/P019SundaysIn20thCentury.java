package euler;

/**
 */
public class P019SundaysIn20thCentury {
    static int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean leapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int daysSince = 1;
        int sundays = 0;
        for (int year = 1900; year <= 2000; year++) {
            boolean isLeap = leapYear(year);
            for (int daysInThisMonth : daysInMonth) {
                if (daysSince % 7 == 0 && year >= 1901) sundays++;
                daysInThisMonth = isLeap && daysInThisMonth == 28 ? 29 : daysInThisMonth;
                daysSince += daysInThisMonth;
            }
        }
        System.out.println(sundays);
    }

}
