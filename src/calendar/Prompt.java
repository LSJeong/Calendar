package calendar;

import java.util.Scanner;

public class Prompt {
    /**
     *
     * @param week 요일명
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String week){
        if(week.equals("su")) return 0;
        else if(week.equals("mo")) return 1;
        else if(week.equals("tu")) return 2;
        else if(week.equals("we")) return 3;
        else if(week.equals("th")) return 4;
        else if(week.equals("fr")) return 5;
        else if(week.equals("sa")) return 6;
        else return 0;
    }

    public void runPrompt(){
        Scanner scn = new Scanner(System.in);
        Calendar cal = new Calendar();
        int year = 2017;
        int month = 1;
        while (true){
            System.out.println("연도를 입력하세요.");
            System.out.print("YEAR> ");
            year = scn.nextInt();
            if(year == -1) break;

            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            month = scn.nextInt();

            if(month > 12 || month < 1){
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            cal.printCalender(year, month);

        }
        scn.close();
    }


}
