package kosa.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExam02 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person("홍길동", 20));
		list.add(new Person("박길동", 15));
		list.add(new Person("김길동", 40));
		list.add(new Person("원길동", 25));
		list.add(new Person("조길동", 60));
		list.add(new Person("송길동", 55));
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// 이름을 기준으로 오름차순
				// String : 앞쪽문자열.compareTo(뒷쪽문자열)
				// 0 => 앞쪽(AAA) == 뒷쪽(AAA)
				// -1 => 앞쪽(AAA) < 뒷쪽(ABB)
				// 1 => 앞쪽(ABB) > 뒷쪽(AAA)
				if(o1.getName().compareTo(o2.getName()) <0) {
					return -1;
				} else if(o1.getName().compareTo(o2.getName()) >0) {
					return 1;
				}
				return 0;
			}
			
		}); // 기본 정렬
		                                                                                                  
		System.out.print(list);
	}
}
