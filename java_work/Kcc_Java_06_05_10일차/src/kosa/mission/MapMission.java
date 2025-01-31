package kosa.mission;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMission {
	public static void main(String[] args) {
		// 이름, 점수를 한쌍으로 Map 자료구조로 구현하시오. ex) 김자바 : 90 / 박자바 : 60
		// 1. 시험 응시자만 출력
		// 2. 총점, 평균, 최고점수, 최저점수 출력  // Collections => max(), min()
		
		Map<String, Integer> test = new HashMap<String, Integer>();
		
		test.put("김자바", 90);
		test.put("박자바", 80);
		test.put("이자바", 70);
		test.put("원자바", 60);
		test.put("조자바", 50);
		
		// map -> key 추출
		Set<String> set = test.keySet();
		System.out.println("응시자 명단 : " + set);
		Collection<Integer> values = test.values();
		Iterator<Integer> iter = values.iterator();

		int t = 0;
		while(iter.hasNext()) {
			t += iter.next();
		}
		double a = 0;
			a = t/test.size();
		System.out.println("총점 : " + t + "\t" + "평균 : " + a + "\t" + "최고점수 : " + Collections.min(values) + "\t" + "최저점수 : " +Collections.max(values));
	}
}
