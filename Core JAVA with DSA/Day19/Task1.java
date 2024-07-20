package Day19;

public class Task1 {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        System.out.println("Original Pair: " + pair);
        Pair<Integer, String> reversedPair = pair.reverse();
        System.out.println("Reversed Pair: " + reversedPair);
    }
}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public Pair<U, T> reverse() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
