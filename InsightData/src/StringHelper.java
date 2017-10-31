
public class StringHelper {
	
	// Build String required in medianvals_by_zip output format
	public static String getString(RecepientZipKey key, MapValue value) {
		return "" + key.getRecepient() + "|" + key.getZip() + "|" + (long) Math.round(value.getMedian()) + "|"
				+ value.getNumOfTrasactions() + "|" + (long) Math.round(value.getTotalContribution()) + "\n";
	}
	
	// Build String required in medianvals_by_date output format
	public static String getString(RecipientDateKey key, MapValue value) {
		return "" + key.getRecepient() + "|" + key.getDate() + "|" + (long) Math.round(value.getMedian()) + "|"
				+ value.getNumOfTrasactions() + "|" + (long) Math.round(value.getTotalContribution()) + "\n";
	}
}
