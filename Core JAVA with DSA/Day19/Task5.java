package Day19;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Task5 {
    public static void main(String[] args) {
        Person person = new Person("John", 40);

        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        Function<Person, String> getDescription = p -> p.getName() + " is " + p.getAge() + " years old.";
        Consumer<Person> printPerson = p -> System.out.println(p);

        Supplier<String> welcomeMessage = () -> "Welcome to the system";

        System.out.println(welcomeMessage.get());
        System.out.println("Is adult: " + isAdult.test(person));
        System.out.println("Description: " + getDescription.apply(person));
        printPerson.accept(person);
    }
}



