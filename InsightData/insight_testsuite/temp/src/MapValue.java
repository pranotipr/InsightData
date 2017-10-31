/**
 * This class represents the fields corresponding to unique key combination in the Maps 
 * @author Pranoti
 * 
 */
class MapValue {
	double totalContribution;
	int numOfTrasactions;
	double median;
	MedianFinder medianFinder;

	MapValue(double transaction_amt, int newNumberTrasactions, MedianFinder m) {
		totalContribution = transaction_amt;
		numOfTrasactions = newNumberTrasactions;
		medianFinder = m;
	}

	public double getTotalContribution() {
		return totalContribution;
	}

	public void setTotalContribution(double totalContribution) {
		this.totalContribution = totalContribution;
	}

	public int getNumOfTrasactions() {
		return numOfTrasactions;
	}

	public void setNumOfTrasactions(int numOfTrasactions) {
		this.numOfTrasactions = numOfTrasactions;
	}

	public double getMedian() {
		return median;
	}

	public void setMedian(double newAmount) {
		medianFinder.addNum(newAmount);
		this.median = medianFinder.findMedian();
	}

	public MedianFinder getMedianFinder() {
		return medianFinder;
	}

	public void setMedianFinder(MedianFinder medianFinder) {
		this.medianFinder = medianFinder;
	}

}