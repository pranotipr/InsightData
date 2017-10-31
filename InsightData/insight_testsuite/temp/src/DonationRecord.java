/**
 * Encapsulates the relevant extracted information from the
 * each input line.
 * @author Pranoti
 * 
 */
public class DonationRecord {
	String cmte_id;
	String zip_code;
	String transaction_dt;
	double transaction_amt;
	String other_id;
	
	 /**
	   * Extracts relevant fields from input line 
	   * @param arg list string array containing the input fields
	   */
	public DonationRecord(String[] list) {
		this.setCmte_id(list[Constants.CMTEINDEX].toString());
		this.setZip_code(list[Constants.ZIPINDEX].toString().substring(0, Constants.ZIPLENGTH));
		this.setTransaction_dt(list[Constants.DATEINDEX].toString());
		this.setTransaction_amt(Double.valueOf(list[Constants.AMOUNTINDEX]));
		this.setOther_id(list[Constants.OTHERINDEX].toString());
	}

	public String getCmte_id() {
		return cmte_id;
	}

	public void setCmte_id(String cmte_id) {
		this.cmte_id = cmte_id;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getTransaction_dt() {
		return transaction_dt;
	}

	public void setTransaction_dt(String transaction_dt) {
		this.transaction_dt = transaction_dt;
	}

	public double getTransaction_amt() {
		return transaction_amt;
	}

	public void setTransaction_amt(Double double1) {
		this.transaction_amt = double1;
	}

	public String getOther_id() {
		return other_id;
	}

	public void setOther_id(String other_id) {
		this.other_id = other_id;
	}
}
