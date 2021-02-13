package problem210213;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



public class ArraySortTest3 {
	private static class Person  implements Comparator<Person>{ //Comparable<Person>{
		private String name;
		private int age;
		private String job;
		private int score;
		
		public Person() {
			// TODO Auto-generated constructor stub
		}

		public Person(String name, int age, String job, int score) {
			super();
			this.name = name;
			this.age = age;
			this.job = job;
			this.score = score;
		}

//		@Override
//		public int compareTo(Person o) {//정렬의 기준을 정의~!!		Comparable의 추상메소드	
//			return age-o.age;  //this.age-o.age;
//		}
		
		@Override
		public int compare(Person o1, Person o2) {//Comparator의 추상메소드
			return o1.age-o2.age;//오름차순
//			return -(o1.age-o2.age);//내림차순
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
	
	
	
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("갓용수", 11, "학생", 100));
		list.add(new Person("갓민권", 15, "학생", 90));
		list.add(new Person("깡승현", 12, "학생", 76));
		list.add(new Person("킹나영", 10, "학생", 80));
		list.add(new Person("황태", 12, "학생", 85));
		
//		Arrays.sort(list); //Arrays클래스의 sort메소드를 통해 Collection(List)의 정렬을 할 수 없음~!!
//      Collections.sort(list); //Comparable일 경우
        Collections.sort(list,new Person("박선아", 25, "학생", 100));  //Comparator일 경우 Collections.sort(list, Comparator객체); 
        
        System.out.println(list);
		
	}// main
}