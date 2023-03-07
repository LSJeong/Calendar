package calendar;

public class Calendar {
    private static final int[] end = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final int[] LEAP_end = {31,29,31,30,31,30,31,31,30,31,30,31};


    public boolean isLeapYear(int year){
        if(year % 4 ==0 && (year % 100 !=0 || year % 400 == 0)){
            return true;
        }
        return false;
    }
    public int getMonth(int year, int month){
        if(isLeapYear(year)){
            return LEAP_end[month-1];
        }else {
            return end[month-1];
        }
    }

    public void printCalender(int year, int month){
        System.out.printf("    <<%d년 %d월>>\n",year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        int weekday = getWeekDay(year,month,1);

        for(int i=0; i <weekday; i++){
            System.out.print("   ");
        }
        int max = getMonth(year, month);
        int count = 7 - weekday;
        int delim = (count < 7) ? count : 0;

        //print first line
        for(int i = 1; i <= count; i++) {
            System.out.printf("%3d",i);
        }
        System.out.println();

        //print from second line to last

        count++;
        for(int i = count; i <= max; i++) {
            System.out.printf("%3d",i);
            if (i % 7 == delim)
                System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private int getWeekDay(int year, int month, int day){
        int syear = 1970;
        final int STANDARD_WEEKDAY = 4;  //1970.1.1 = Thursday

        int count = 0;

        for(int i = syear; i < year;i++){
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }
        //System.out.println(count);

        for(int i= 1;i<month;i++){
            int delta = getMonth(year, i);
            count += delta;
        }

        count += day - 1;
        int weekday = (count + STANDARD_WEEKDAY) % 7;
        return weekday;
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
