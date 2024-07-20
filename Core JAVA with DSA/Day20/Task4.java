package Day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task4 {
    public static void main(String[] args) {
        String urlString = "http://www.google.com";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Headers:");
            connection.getHeaderFields().forEach((key, value) -> System.out.println(key + ": " + value));

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response Body:");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

