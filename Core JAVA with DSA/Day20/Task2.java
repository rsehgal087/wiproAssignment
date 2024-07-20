package Day20;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        String filePath = "object.ser";
        CustomObject originalObject = new CustomObject("Example", 42);

        // Serialize object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(originalObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            CustomObject deserializedObject = (CustomObject) in.readObject();
            System.out.println("Deserialized Object: " + deserializedObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class CustomObject implements Serializable {
    private String name;
    private int value;

    public CustomObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomObject{name='" + name + "', value=" + value + "}";
    }
}

