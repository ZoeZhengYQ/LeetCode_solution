class Solution {
    private String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private Map<Integer, Integer> monthToDays = new HashMap<>();
    
    public String dayOfTheWeek(int day, int month, int year) {
        // setup
        monthToDays.put(1, 31);
        monthToDays.put(2, 28);
        monthToDays.put(3, 31);
        monthToDays.put(4, 30);
        monthToDays.put(5, 31);
        monthToDays.put(6, 30);
        monthToDays.put(7, 31);
        monthToDays.put(8, 31);
        monthToDays.put(9, 30);
        monthToDays.put(10, 31);
        monthToDays.put(11, 30);
        monthToDays.put(12, 31);
        
        
        int totalDays = 0;
        int gapYear = year - 1971;
        totalDays += gapYear * 365;
        // 闰年
        totalDays += (gapYear+3) / 4;
        // days in current year
        for (int i = 1; i < month; ++i) {
            totalDays += monthToDays.get(i);
        }
        totalDays += day;
        System.out.println(totalDays);
        
        if (year % 4 == 0 && month < 3) {
            totalDays -= 1;
        }
        
        totalDays %= 7;
        System.out.println(totalDays);
        // 1970/1/1 Friday
        int initDay = 4;
        
        return weekdays[(initDay + totalDays) % 7];
    }
}