package Day19;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task3 {
    public static void main(String[] args) {
        try {
            MyClass myClass = new MyClass();

            // Inspect methods
            System.out.println("Methods:");
            Method[] methods = MyClass.class.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            // Inspect fields and modify private field
            Field privateField = MyClass.class.getDeclaredField("privateField");
            privateField.setAccessible(true); // Allow access to private field
            System.out.println("Original privateField: " + privateField.get(myClass));

            privateField.set(myClass, "Modified Value");
            System.out.println("Modified privateField: " + privateField.get(myClass));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyClass {
    private String privateField = "Initial Value";

    public void publicMethod() {}
    private void privateMethod() {}
}

