/**
 * This class represents the unique key for recipient and zip combination
 * @author Pranoti
 * 
 */
public class RecepientZipKey {
	String recepient;
	String zip;

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof RecepientZipKey) {
			RecepientZipKey s = (RecepientZipKey) obj;
			return recepient.equals(s.recepient) && zip.equals(s.zip);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (zip + recepient).hashCode();
	}
	
	RecepientZipKey(DonationRecord record) {
		recepient = record.getCmte_id();
		zip = record.getZip_code();
	}

	public String getRecepient() {
		return recepient;
	}

	public void setRecepient(String recepient) {
		this.recepient = recepient;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
