/**
 * Encapsulates all the constants used in the project
 * @author    Pranoti
 * 
 */
public class Constants {
	//Regular expression to match valid zip-code format 
	public static final String ZIPCODEREGEX = "^[0-9]{5}(?:-[0-9]{4})?$";
	
	//Regular expression to match MMDDYYYY date format
	public static final String DATEREGEX = "^(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d\\d$";
	
	//input file record
	public static final String INPUTFILENAME = "itcont.txt";
	
	//output file for recipient and zip-code key combination
	public static final String ZIPFILEOUTPUT = "medianvals_by_zip.txt";

	//output file for recipient and date key combination
	public static final String DATEFILEOUTPUT = "medianvals_by_date.txt";

	//Output file folder
	public static final String OUPUTFOLDER = "output";
	
	//Input file folder
	public static final String INPUTFOLDER = "input";
	
	//Recepient index in the input record
	public static final int CMTEINDEX = 0;
	
	//Zip-code index in the input record
	public static final int ZIPINDEX = 10;
	
	//Date index in the input record
	public static final int DATEINDEX = 13;
	
	//Amount index in the input record
	public static final int AMOUNTINDEX = 14;
	
	//Others Id field index in the input record
	public static final int OTHERINDEX = 15;
	
	//Length of Zip Code
	public static final int ZIPLENGTH = 5;
	
	//Input Record Length
	public static final int INPUTLENGTH = 15;
	


}
