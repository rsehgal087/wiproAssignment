package Day22;

public class Task3 {
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

