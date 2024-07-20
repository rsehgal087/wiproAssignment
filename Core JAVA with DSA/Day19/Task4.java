package Day19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("Sorted by age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}


