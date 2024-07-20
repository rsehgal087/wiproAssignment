package Day13_Day14;

import java.util.*;

class Task3 {

    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Function to perform Job Sequencing with maximum profit using Greedy approach
    public static List<Job> JobSequencing(List<Job> jobs) {
        // Sort jobs based on profit in descending order
        jobs.sort((j1, j2) -> Integer.compare(j2.profit, j1.profit));

        // Find maximum deadline to determine size of result array
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Array to store the result of selected jobs
        List<Job> result = new ArrayList<>(maxDeadline);

        // Array to track occupied time slots
        boolean[] slotOccupied = new boolean[maxDeadline];

        // Iterate through sorted jobs and add to result if a slot is available
        for (Job job : jobs) {
            // Find a free slot for this job starting from its deadline
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slotOccupied[j]) {
                    result.add(job);
                    slotOccupied[j] = true;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        System.out.println("Jobs:");
        for (Job job : jobs) {
            System.out.println("Job " + job.id + ": Deadline=" + job.deadline + ", Profit=" + job.profit);
        }

        List<Job> result = JobSequencing(jobs);

        System.out.println("\nJob Sequence for Maximum Profit:");
        for (Job job : result) {
            System.out.println("Job " + job.id + ": Deadline=" + job.deadline + ", Profit=" + job.profit);
        }
    }
}

