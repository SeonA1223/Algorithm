//package problem210217;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class ArraySortTest5 {
//
//	private static class Person {
//		private String name;
//		private int age;
//		private String job;
//		private int score;
//
//		public Person() {
//		}
//
//		public Person(String name, int age, String job, int score) {
//			super();
//			this.name = name;
//			this.age = age;
//			this.job = job;
//			this.score = score;
//		}
//
//		@Override
//		public String toString() {
//			StringBuilder builder = new StringBuilder();
//			builder.append("Person [name=");
//			builder.append(name);
//			builder.append(", age=");
//			builder.append(age);
//			builder.append(", job=");
//			builder.append(job);
//			builder.append(", score=");
//			builder.append(score);
//			builder.append("]");
//			return builder.toString();
//		}
//
//	}
//
//	public static void main(String[] args) {
//		ArrayList<Person> list = new ArrayList<>();
//		list.add(new Person("갓용수", 11, "학생", 100));
//		list.add(new Person("갓민권", 15, "학생", 90));
//		list.add(new Person("깡승현", 12, "학생", 76));
//		list.add(new Person("킹나영", 10, "학생", 80));
//		list.add(new Person("황태", 12, "학생", 85));
//
////		Arrays.sort(list); //Arrays클래스의 sort메소드를 통해 Collection(List)의 정렬을 할 수 없음~!!
////      Collections.sort(list); //Comparable일 경우
////      Collections.sort(list,new Person());  //Comparator일 경우 Collections.sort(list, Comparator객체); 
//
//		// 나는 특정인터페이스를 상속받지 않는 Person을 사용하고 싶다~!!
//		Collections.sort(list, (o1, o2) -> o1.age - o2.age);// 익명의 내부클래스
//		System.out.println(list);
//		// 문제) Person을 age오름차순으로 하되 같은 age의 경우 score내림차순으로 정렬하시오.
//		Collections.sort(list, (o1, o2) -> {
//				if (o1.age == o2.age) {
//					return o2.score - o1.score;
//				} // 만약 나이가 같다면 점수를 내림차순 하시오.
//				return o1.age - o2.age;
//			}
//	
//		});// 익명의 내부클래스
//
//		System.out.println(list);
//
//	}// main
//}