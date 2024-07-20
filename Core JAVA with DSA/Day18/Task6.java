package Day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task6 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture<List<Integer>> primeNumbersFuture = CompletableFuture.supplyAsync(() -> {
            return IntStream.range(2, 100)
                .filter(Task6::isPrime)
                .boxed()
                .collect(Collectors.toList());
        }, executor);

        primeNumbersFuture.thenAccept(primeNumbers -> {
            try {
                Files.write(Paths.get("primes.txt"), primeNumbers.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).thenRun(() -> {
            System.out.println("Prime numbers have been written to file.");
        });

        executor.shutdown();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

