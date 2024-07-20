package Day23;

interface SecretKeyProvider {
    String getSecretKey(String password);
}

class RealSecretKeyProvider implements SecretKeyProvider {
    private String secretKey = "SECRET123";

    @Override
    public String getSecretKey(String password) {
        return secretKey;
    }
}

public class Task3 implements SecretKeyProvider {
    private RealSecretKeyProvider realSecretKeyProvider;
    private String correctPassword;

    public Task3(String correctPassword) {
        this.realSecretKeyProvider = new RealSecretKeyProvider();
        this.correctPassword = correctPassword;
    }

    @Override
    public String getSecretKey(String password) {
        if (password.equals(correctPassword)) {
            return realSecretKeyProvider.getSecretKey(password);
        } else {
            throw new SecurityException("Access Denied: Incorrect Password");
        }
    }

    public static void main(String[] args) {
        Task3 proxy = new Task3("password123");
        try {
            System.out.println("Secret Key: " + proxy.getSecretKey("password123"));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}

