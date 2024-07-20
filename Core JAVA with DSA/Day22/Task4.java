package Day22;

public class Task4 {
//	1. Serial Garbage Collector
//	Description: Uses a single thread for garbage collection. Suitable for single-threaded environments.
//	Advantages: Simple and efficient for small applications.
//	Disadvantages: Pauses all application threads during GC, causing noticeable latency in larger applications.
	
	
//	2. Parallel Garbage Collector
//	Description: Uses multiple threads for garbage collection. Suitable for multi-threaded environments.
//	Advantages: Reduces GC pause times by performing GC in parallel.
//	Disadvantages: Can still cause significant pause times in large applications.
	
	
//	3. Concurrent Mark-Sweep (CMS) Garbage Collector
//	Description: Attempts to minimize pause times by doing most of the work concurrently with the application threads.
//	Advantages: Reduces long pauses caused by garbage collection.
//	Disadvantages: Higher CPU usage due to concurrent operations, can cause fragmentation.
	
	
//	4. G1 Garbage Collector
//	Description: Designed for multi-processor machines with large memory. Splits the heap into regions and performs GC incrementally.
//	Advantages: Provides predictable pause times and can handle large heaps more efficiently.
//	Disadvantages: More complex and can have overhead in tracking regions and maintaining the pause time goal.
	
	
//	5. Z Garbage Collector (ZGC)
//	Description: Scalable low-latency garbage collector designed to handle large heaps (multi-terabyte) with very short pause times.
//	Advantages: Very low pause times (sub-millisecond), scalable to large heaps.
//	Disadvantages: Experimental in older JDK versions, can be complex to tune.
}
