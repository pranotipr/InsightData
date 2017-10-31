import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedianByDateValidator implements InputValidator {
	static final Pattern regex = Pattern.compile(Constants.DATEREGEX);
	
	// Checks if the date is received in valid format using regular expression.
	public boolean isValid(String[] token) {
		try {
			if (token != null && token.length > Constants.INPUTLENGTH && token[Constants.OTHERINDEX] != null 
					&& token[Constants.OTHERINDEX].equals("") && token[Constants.CMTEINDEX] != null && !token[Constants.CMTEINDEX].equals("")
					&& token[Constants.DATEINDEX] != null && !token[Constants.DATEINDEX].equals("")) {
				Double.valueOf(token[Constants.AMOUNTINDEX]);
				String date = token[Constants.DATEINDEX];
				//Regular Expression for MMDDYYYY date format
				Matcher m = regex.matcher(date);
				//Checks if the input date has a valid format MMDDYYYY
				if (m != null)
					return m.matches();
				return false;
				
			}
		} catch (Exception ex) {
		}
		return false;
	}
}
