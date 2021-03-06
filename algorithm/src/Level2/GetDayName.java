package Level2;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
 2016년 1월 1일은 금요일입니다. 2016년 A월 B일은 무슨 요일일까요? 
 두 수 A,B를 입력받아 A월 B일이 무슨 요일인지 출력하는 getDayName 함수를 완성하세요. 
 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT를 출력해주면 됩니다. 
 예를 들어 A=5, B=24가 입력된다면 5월 24일은 화요일이므로 TUE를 반환하면 됩니다.
 */
public class GetDayName {	
	 public String getDayName(int a, int b)
	    {
		 LocalDate date = LocalDate.of(2017, a, b);
		 DayOfWeek dayOfWeek = date.getDayOfWeek();
		 dayOfWeek.getValue();
		 System.out.println(dayOfWeek.getValue());
		 String[] dayName = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		 String answer = dayName[dayOfWeek.getValue() - 1];
	     return answer;
	     
		// Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, month - 1, day).build();
		// return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
	    }
	    public static void main(String[] args)
	    {
	    	GetDayName test = new GetDayName();
	        int a=5, b=8;
	        System.out.println(test.getDayName(a,b));
	    }
}
