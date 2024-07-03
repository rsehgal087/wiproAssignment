package Day12;

class Task1 {
    // Method to count the number of set bits in the binary representation of an integer
    public int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1; // Add the least significant bit to count
            num >>= 1; // Right shift the number by 1
        }
        return count;
    }

    // Method to count the total number of set bits in all integers from 1 to n
    public int totalSetBits(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += countSetBits(i);
        }
        return total;
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        int n = 5;
        int result = task.totalSetBits(n);
        System.out.println("Total number of set bits from 1 to " + n + " is: " + result); // Output: 7
    }
}

