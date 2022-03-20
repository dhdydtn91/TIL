package programmer;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.SimpleFormatter;

public class FirstExam {
  public int solution(String[] ledgers) throws ParseException {
    int answer = 0;
    //구해야 하는 것은 이자의 총합
    //2/29 이나 형식이 맞춰지지 않은 날짜는 거래일이 주어지지 않는다. ex 01/29 12/31 도 안된
    int totalMoney =0;
    List<Integer> interest =  new ArrayList<>();
    // 거래내역과 잔액을 나타내는 맵
    Map<String,Integer> map= new HashMap<>();
    Stack<String> stack =new Stack<>();
    for (String ledger : ledgers) {
      String[] led = ledger.split(" ");
      String day = led[0];
      boolean isDate = validationDate(day);
      String rate = led[1];
      int money = Integer.parseInt(led[2]);
      if(isDate ||  money != 0) {
        if (money > 0) {
          // 입금
          map.put(ledger, money);
          totalMoney += money;
          stack.push(ledger);
        } else {
          // 출금
          money = -money;
          int balance = totalMoney - money;
          if(balance > 0){
            //출금처리가 정상적으로 됨
            totalMoney = balance;
            //최근 입금 날짜 부터 출금
            // 입금앱이 잔액보다 크다면 다음꺼
            while(money > 0 && !stack.isEmpty()){
              String peek = stack.peek();
              int depositMoney = map.get(peek);
              int calcMoney = depositMoney;
              // 출금액이 예금 보다 클 경우 출금액- 예금액
              if(money - depositMoney >0){
                calcMoney = depositMoney;
                money =money-depositMoney;
              }else{
                calcMoney = money;
                money = 0;
              }
              int value = depositMoney - calcMoney;
              map.put(peek, value);
              String pop = "";
              if(value== 0) {
                pop = stack.pop();
              }else {
                pop = peek;
              }
              int result = calcMoney(pop, calcMoney,day);
              interest.add(result);
            }
          }
        }
      }
    }
    //12/31 일 정산
    while(!stack.isEmpty()){
      String log = stack.pop();
      Integer calcMoney = map.get(log);
      int result = calcMoney(log, calcMoney,"12/31");
      interest.add(result);
    }

    for(int i= 0 ; i< interest.size(); i++){
      answer+=interest.get(i);
    }
    return answer;
  }

  public int calcMoney(String log , int calMoney, String day) throws ParseException {
    String [] s =log.split(" ");
    int rate = Integer.parseInt(s[1]);

    Date withdrawDay = new SimpleDateFormat("MM/dd").parse(day);
    Date depositDay = new SimpleDateFormat("MM/dd").parse(s[0]);
    long days = (withdrawDay.getTime() - depositDay.getTime()) / (24*60*60*1000);
    double i = calMoney * (rate / 100.0);
    double l = days / 365.0;
    int floor = (int) Math.floor(i * l);
    return floor;
  }

  private boolean validationDate(String day) {
    boolean isDate = true;
    String[] days = day.split("/");
    if(days.length != 2 || days[0].length()!=2 || days[0].length() !=2){
      return false;
    }
    Calendar calendar =  Calendar.getInstance();
    int month = Integer.parseInt(days[0]);
    if(month > 12){
      return false;
    }
    calendar.set(Calendar.MONTH, month -1);
    int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    if(Integer.parseInt(days[1]) > dayOfMonth){
      return false;
    }
    return isDate;
  }

  public static void main(String[] args) throws ParseException {
    String ledgers [] ={"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
    FirstExam firstExam = new FirstExam();
    int solution = firstExam.solution(ledgers);

    System.out.println(solution);
  }
}




class TreeNode{
  int val;
  TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
  }
}