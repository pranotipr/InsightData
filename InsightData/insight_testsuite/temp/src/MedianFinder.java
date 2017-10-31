import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implements logic for calculating the running median.
 * @author Pranoti
 * 
 */
class MedianFinder {
	private Queue<Double> small = new PriorityQueue<Double>(), large = new PriorityQueue<Double>();
	
	/**
	 * Inserts the amount to the PriorityQueue
	 * @param num a double containing trasaction amount
	 */
	public void addNum(double num) {
		large.add(num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	/**
	 * Calculates the running median 
	 */
	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}
}