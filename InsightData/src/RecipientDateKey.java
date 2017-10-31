/**
 * This class represents the unique key for recipient and date combination
 * @author Pranoti
 * 
 */
class RecipientDateKey implements Comparable<RecipientDateKey> {

	String recipient;
	String date;

	RecipientDateKey(DonationRecord record) {
		recipient = record.getCmte_id();
		date = record.getTransaction_dt();
	}

	@Override
	public int compareTo(RecipientDateKey key) {
		if (this.getRecepient().equals(key.getRecepient()))
			return this.getDate().compareTo(key.getDate());
		else
			return this.getRecepient().compareTo(key.getRecepient());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof RecipientDateKey) {
			RecipientDateKey s = (RecipientDateKey) obj;
			return recipient.equals(s.recipient) && date.equals(s.date);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (date + recipient).hashCode();
	}
	
	public String getRecepient() {
		return recipient;
	}

	public void setRecepient(String recepient) {
		this.recipient = recepient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}