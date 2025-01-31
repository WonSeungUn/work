package kosa.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExam {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("���¾�", 30),
				new Student("���º�", 50),
				new Student("������", 70),
				new Student("ddd", 80)
				);
		
		int sum2 = list.stream().map(Student :: getScore).reduce(0, (a,b) -> a+b);
		System.out.println(sum2);
		
		Stream<Student> stream = list.stream();
		List<Student> stuList = stream.filter(n -> n.getName().startsWith("��")).collect(Collectors.toList());
		for(Student s : stuList) {
			System.out.println(s.getName());
		}
		IntStream scoreStream = stream.mapToInt(student -> student.getScore());
		double avg = scoreStream.average().getAsDouble();
		double avg2 = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();
		System.out.println(avg + " || " + avg2);
		System.out.println("---------------------------------------------------------");
		list.stream().forEach(s -> System.out.println(s.getName()));
		System.out.println("---------------------------------------------------------");
		list.stream().map(s->s.getName()).forEach(name ->System.out.println(name));
		System.out.println("---------------------------------------------------------");
		list.stream().map(Student:: getName).forEach(name ->System.out.println(name));
		System.out.println("---------------------------------------------------------");
		list.stream().filter(s->s.getName().contains("��")).forEach(s->System.out.println(s.getName()));
		
		List<Student> list2 = new ArrayList<>();
		list2.add(new Student("������", 50));
		list2.add(new Student("ĥ����", 70));
		list2.add(new Student("������", 90));
		list2.stream().mapToInt(s -> s.getScore()).forEach(s -> System.out.println(s));
	}
}
