package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
    public void printMenu(){
        // +-----------------+
        // | 1. 일정 등록
        // | 2. 일정 검색
        // | 3. 달력 보기
        // | h. 도움말 q. 종료
        // +-----------------+

        System.out.println("+-----------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+-----------------+");
    }

    /**
     *
     * @param week 요일명
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public int parseDay(String week){
//        if(week.equals("su")) return 0;
//        else if(week.equals("mo")) return 1;
//        else if(week.equals("tu")) return 2;
//        else if(week.equals("we")) return 3;
//        else if(week.equals("th")) return 4;
//        else if(week.equals("fr")) return 5;
//        else if(week.equals("sa")) return 6;
//        else return 0;

        switch (week){
            case "su":
                return 0;
            case "mo":
                return 1;
            case "tu":
                return 2;
            case "we":
                return 3;
            case "th":
                return 4;
            case "fr":
                return 5;
            case "sa":
                return 6;
            default:
                return 0;
        }
    }

// 명령(1, 2, 3, h, q)
    public void runPrompt() throws ParseException {
        printMenu();
        Scanner scn = new Scanner(System.in);
        Calendar cal = new Calendar();


        //String cmd = scn.next();

        boolean isLoop = true;
        while (isLoop){

            System.out.println("명령(1, 2, 3, h, q)");
            String cmd = scn.next();
            switch (cmd){
                case "1":
                    cmdRegister(scn, cal);
                    break;
                case "2":
                    cmdSearch(scn, cal);
                    break;
                case "3":
                    cmdCal(scn, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    isLoop = false;
                    break;
            }
//            if(cmd.equals("1")) cmdRegister(scn, cal);
//            else if(cmd.equals("2")) cmdSearch(scn, cal);
//            else if(cmd.equals("3")) cmdCal(scn, cal);
//            else if(cmd.equals("h")) printMenu();
//            else if(cmd.equals("q")) break;


        }
        System.out.println("Thank you. Bye!!!");
        scn.close();
    }

    private void cmdCal(Scanner scn, Calendar c) {
        int year = 2017;
        int month = 1;

        System.out.println("연도를 입력하세요.");
        System.out.print("YEAR> ");
        year = scn.nextInt();

        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        month = scn.nextInt();

        if(month > 12 || month < 1){
            System.out.println("잘못된 입력입니다.");
            return;
        }

        c.printCalender(year, month);

    }

    private void cmdSearch(Scanner s, Calendar c) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해주세요(yyyy-MM-dd).");
        String date = s.next();
//        String plan;
//        try {
//            plan = c.searchPlan(date);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        PlanItem plan;
        plan = c.searchPlan(date);
        if(plan != null){
            System.out.println(plan.detail);
        }else {
            System.out.println("일정이 없습니다.");
        }
    }

    private void cmdRegister(Scanner s, Calendar c) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해주세요(yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        System.out.println("일정을 입력해주세요.(문자의 끝에 ;을 입력해주세요.)");
//        while (true){
//            String word = s.next();
//            text += word + " ";
//            if(word.endsWith(";")){
//                break;
//            }
//        }
        String word;
        while(!(word = s.next()).endsWith(";")){
            text += word + " ";
        }
        word = word.replace(";","");
        text += word;

        c.registerPlan(date, text);
    }

    public static void main(String[] args) throws ParseException {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
