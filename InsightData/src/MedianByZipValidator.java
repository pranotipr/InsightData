import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedianByZipValidator implements InputValidator {
	static Pattern regex = Pattern.compile(Constants.ZIPCODEREGEX);

	// Checks if the date is received in valid format using regular expression.
	public boolean isValid(String[] token) {
		try {
			//Check that OTHER_ID, CMTE_ID or TRANSACTION_AMT is in valid format
			if (token != null && token.length > Constants.INPUTLENGTH && token[Constants.OTHERINDEX].toString().equals("") && !token[Constants.CMTEINDEX].equals("")) {
				Double.valueOf(token[Constants.AMOUNTINDEX]);
				String zip = token[Constants.ZIPINDEX];
				if (zip.length() < Constants.ZIPLENGTH)
					return false;
				String zipCode = zip.substring(0, Constants.ZIPLENGTH);
				//Regular Expression for zip-code format
				Matcher m = regex.matcher(zipCode);
				//Checks if the input zip has a valid format
				if (m != null)
					return m.matches();
				return false;
			}
		} catch (Exception ex) {
		}
		return false;
	}
}
