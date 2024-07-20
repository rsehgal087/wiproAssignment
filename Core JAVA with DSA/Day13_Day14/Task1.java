package Day13_Day14;

public class Task1 {
    
    // Recursive function to solve the Tower of Hanoi puzzle
    public void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        // Move n-1 disks from source to auxiliary, so they are out of the way
        solveTowerOfHanoi(n - 1, source, destination, auxiliary);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move the n-1 disks that we left on auxiliary to destination
        solveTowerOfHanoi(n - 1, auxiliary, source, destination);
    }
    
    public static void main(String[] args) {
        Task1 towerOfHanoi = new Task1();
        int n = 3; // Number of disks
        towerOfHanoi.solveTowerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
    }
}

