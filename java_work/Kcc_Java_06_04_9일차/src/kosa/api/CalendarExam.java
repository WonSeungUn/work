package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
		Calendar gc = Calendar.getInstance();
		
		String now = gc.get(Calendar.YEAR) + "년"
					+ (gc.get(Calendar.MONTH)+1) +"월" 
					+ gc.get(Calendar.DATE) +"일"
					+ gc.get(Calendar.HOUR) + "시"
					+ gc.get(Calendar.MINUTE) + "분"
					+ gc.get(Calendar.SECOND) +"초";
		System.out.println("현재시간 : " + now );
		
		gc.add(Calendar.DATE,100);
		
		String future = gc.get(Calendar.YEAR) + "년"
				+ (gc.get(Calendar.MONTH)+1) +"월" 
				+ gc.get(Calendar.DATE) +"일"
				+ gc.get(Calendar.HOUR) + "시"
				+ gc.get(Calendar.MINUTE) + "분"
				+ gc.get(Calendar.SECOND) +"초";
		System.out.println("100일 후: " + future );
		
		
		gc.set(2021,12,18);
		gc.add(Calendar.DATE, 1000);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(gc.getTime());
		System.out.println(str);
		
		
		
		// 퀴즈 > 2024년 ~ 2030년까지 자신의 생일이 무슨 요일인지 찾기
//		Calendar.DAY_OF_WEEK // 요일 <- <일(1) 월(2) 화(3) 수(4) 목(5) 금(6) 토(7)>
		
		char week[] =  {'일','월','화','수','목','금','토'};
		
		for(int i = 2024 ; i <= 2030 ; i++) {
			gc.set(i, 2, 6);
			char c = week[gc.get(Calendar.DAY_OF_WEEK)-1];
			System.out.println(i + "년의 생일은 " + c + "요일입니다");
		}
		
		
	}
}
