import java.util.*;

/**
 * Manager class for keeping the medianvals_by_zip map updated
 * @author Pranoti
 *
 */
public class MedianValsByZipManager {
	// Map to store total amount, total transaction and running median calculations 
	static HashMap<RecepientZipKey, MapValue> map = new HashMap<RecepientZipKey, MapValue>();;

	/**
	 * Updates the map to store past calculations stored to avoid recalculating total amount, number of transactions
	 * @param record an object of DonationRecord
	 */
	public static String updateMedianByZipMap(DonationRecord record) {
		RecepientZipKey key = new RecepientZipKey(record);
		if (map.containsKey(key)) {
			// If Recepient-Zip key combination already exists, update the old record
			MapValue value = map.get(key);
			double newtotalContribution = value.getTotalContribution() + record.getTransaction_amt();
			int newnumOfTrasactions = value.getNumOfTrasactions() + 1;
			MedianFinder medianFinder = value.getMedianFinder();
			MapValue newValue = new MapValue(newtotalContribution, newnumOfTrasactions, medianFinder);
			// Update new median
			newValue.setMedian(record.getTransaction_amt());
			map.put(key, newValue);
			return StringHelper.getString(key, newValue);
		} else {
			// If Recepient-Zip key combination doesn't exist, insert new record
			MapValue newValue = new MapValue(record.transaction_amt, 1, new MedianFinder());
			newValue.setMedian(record.getTransaction_amt());
			map.put(key, newValue);
			return StringHelper.getString(key, newValue);
		}
	}

}
