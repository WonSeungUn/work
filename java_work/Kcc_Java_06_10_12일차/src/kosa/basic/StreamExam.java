package kosa.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExam {
	public static void main(String[] args) {
		
	Set<String> set = new HashSet<>();
	set.add("김자바");
	set.add("박자바");
	set.add("이자바");
	
	Stream<String> stream = set.stream();
	stream.forEach(name -> System.out.println(name));
	
	}
}
