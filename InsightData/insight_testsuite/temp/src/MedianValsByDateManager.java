import java.util.TreeMap;

/**
 * Manager class for keeping the medianvals_by_date sorted map updated
 * @author Pranoti
 *
 */
public class MedianValsByDateManager {
	//TreeMap to store data in sorted order
	static TreeMap<RecipientDateKey, MapValue> map = new TreeMap<RecipientDateKey, MapValue>();
	
	/**
	 * Updates the sorted map to keep data sorted sorted alphabetical by recipient and then chronologically by date.
	 * @param record an object of DonationRecord
	 */
	public static void updateMedianByDateMap(DonationRecord record) {
		RecipientDateKey key = new RecipientDateKey(record);
		if(map.containsKey(key)) {
			// If Recepient-Date key combination already exists, update the old record
			MapValue value = map.get(key);
			double newtotalContribution = value.getTotalContribution() + record.getTransaction_amt();
			int newnumOfTrasactions = value.getNumOfTrasactions() + 1;
			MedianFinder medianFinder = value.getMedianFinder();
			MapValue newValue = new MapValue(newtotalContribution, newnumOfTrasactions, medianFinder);
			// Update new median
			newValue.setMedian(record.getTransaction_amt());
			map.put(key, newValue);

		} else {
			// If Recepient-Date key combination doesn't exist, insert new record
			MapValue newValue = new MapValue(record.transaction_amt, 1, new MedianFinder());
			newValue.setMedian(record.getTransaction_amt());
			map.put(key, newValue);
		}
	}
}
