package problem210213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String job;
	private int score;

	public Person(String name, int age, String job, int score) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.score = score;
	}

	@Override
	public int compareTo(Person o) {// 정렬의 기준을 정의~!!
		// this(Person)의 속성과 o(Person)의 속성을 비교
		// 비교방법 this.속성 - o.속성
		// 결과: 음수, 0, 양수 ==> 음수의 경우 swap을 해줌 ==> 오름차순 정렬

		return age - o.age; // this.age-o.age;
		// 만약 내림차순 정렬을 하고 싶다!!
//		return o.age-age;  
//		return -(age-o.age);  //this.age-o.age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", job=");
		builder.append(job);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

}

public class ArraySortTest2 {
	public static void main(String[] args) {
		int[] su = { 13, 8, 7, 10, 100, 5 };
		// 위의 배열을 오름차순 정렬하시오. (선택정렬)

		char[] ch = { 'J', 'a', 'v', 'A' };

		String[] names = { "홍길동", "길라임", "김주원" };

		// API를 통해 배열을 오름차순 정렬하자~!!
		Arrays.sort(su);
		Arrays.sort(ch);
		Arrays.sort(names);

		System.out.println(Arrays.toString(su));
		System.out.println(Arrays.toString(ch));
		System.out.println(Arrays.toString(names));

		Integer[] su2 = { 13, 8, 7, 10, 100, 5 };
		// su배열을 내림차순 정렬하자!!
		Arrays.sort(su2, Collections.reverseOrder());
		System.out.println(Arrays.toString(su2));

		Person[] persons = { new Person("갓용수", 11, "학생", 100), new Person("갓민권", 15, "학생", 90),
				new Person("깡승현", 12, "학생", 76), new Person("킹나영", 10, "학생", 80), new Person("황태", 12, "학생", 85) };

		// persons배열을 정렬하세요~!!
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));

		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("갓용수", 11, "학생", 100));
		list.add(new Person("갓민권", 15, "학생", 90));
		list.add(new Person("깡승현", 12, "학생", 76));
		list.add(new Person("킹나영", 10, "학생", 80));
		list.add(new Person("황태", 12, "학생", 85));

//		Arrays.sort(list); //Arrays클래스의 sort메소드를 통해 Collection(List)의 정렬을 할 수 없음~!!
		Collections.sort(list);

	}// main
}