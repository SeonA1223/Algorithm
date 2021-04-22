package Day210422;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 제네릭 {
    static class Person implements Comparable<Person>{
        String name;
        int age;
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
		@Override
		public int compareTo(Person o) {
			
			return this.age - o.age;
		}

    }
    public static void main(String[] args) {
        PriorityQueue<Person> personList = new PriorityQueue<>();
        personList.add(new Person("Hong", 23));
        personList.add(new Person("Lee", 28));
        personList.add(new Person("Kim", 24));

        while(!personList.isEmpty())
            System.out.println(personList.poll());
    }
}