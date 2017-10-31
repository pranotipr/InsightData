import org.junit.Test;
import junit.framework.TestCase;

/**
 * Unit tests for the project
 * @author Pranoti
 *
 */
public class UnitTests extends TestCase {
	@Test
	public void testMedianByDateValidator() {
		InputValidator validator = new MedianByDateValidator();
		String invalidInput = "C00629618|N|TER|P|201701230300133512|15C|IND|PEREZ, "
				+ "JOHN A|LOS ANGELES|CA|90017|PRINCIPAL|DOUBLE NICKEL ADVISORS|01032017|40|"
				+ "H6CA34245|SA01251735122|1141239|||2012520171368850783";
		String[] invalidToken = invalidInput.split("\\|");
		String validInput = "C00177436|N|M2|P|201702039042410894|15|IND|DEEHAN, "
				+ "WILLIAM N|ALPHARETTA|GA|300047357|UNUM|SVP, SALES, CL|01312017|384"
				+ "||PR2283873845050|1147350||P/R DEDUCTION ($192.00 BI-WEEKLY)|4020820171370029337";
		String[] validToken = validInput.split("\\|");
		
		String inValidDate = "C00177436|N|M2|P|201702039042410894|15|IND|DEEHAN, "
				+ "WILLIAM N|ALPHARETTA|GA|300047357|UNUM|SVP, SALES, CL||384||"
				+ "PR2283873845050|1147350||P/R DEDUCTION ($192.00 BI-WEEKLY)|4020820171370029337";
		String[] inValidDateToken = inValidDate.split("\\|");

		assertEquals("Other ID Empty", false, validator.isValid(invalidToken));
		assertEquals("Valid Input", true, validator.isValid(validToken));
		assertEquals("Invalid Date", false, validator.isValid(inValidDateToken));
	}

	@Test
	public void testMedianByZipValidator() {
		InputValidator validator = new MedianByZipValidator();
		String amountEmpty = "C00629618|N|TER|P|201701230300133512|15C|IND|PEREZ,JOHN A|"
				+ "LOS ANGELES|CA|90017|PRINCIPAL|DOUBLE NICKEL ADVISORS|01032017||"
				+ "H6CA34245|SA01251735122|1141239|||2012520171368850783";
		String[] amountEmptyToken = amountEmpty.split("\\|");
		String validInput = "C00177436|N|M2|P|201702039042410894|15|IND|DEEHAN, "
				+ "WILLIAM N|ALPHARETTA|GA|300047357|UNUM|SVP, SALES, CL|01312017|384||"
				+ "PR2283873845050|1147350||P/R DEDUCTION ($192.00 BI-WEEKLY)|4020820171370029337";
		String[] validToken = validInput.split("\\|");
		String zipInvalid = "C00177436|N|M2|P|201702039042410894|15|IND|DEEHAN, WILLIAM N|"
				+ "ALPHARETTA|GA||UNUM|SVP, SALES, CL|01312017|384||"
				+ "PR2283873845050|1147350||P/R DEDUCTION ($192.00 BI-WEEKLY)|4020820171370029337";
		String[] zipInvalidToken = zipInvalid.split("\\|");

		assertEquals("Amount Empty", false, validator.isValid(amountEmptyToken));
		assertEquals("Valid Input", true, validator.isValid(validToken));
		assertEquals("Invalid Zicode", false, validator.isValid(zipInvalidToken));
	}

	@Test
	public void testMedianFinder() {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(230.7);
		assertEquals("Test first median", 230.7, medianFinder.findMedian());
		medianFinder.addNum(220);
		assertEquals("Test Rounding off when decimal lesser than 0.5", 225.35, medianFinder.findMedian());
		medianFinder.addNum(225);
		assertEquals("Test adding thrid number", 225.0, medianFinder.findMedian());
		medianFinder.addNum(240);
		assertEquals("Test round anything from $.50 and up to the next dollar", 227.85, medianFinder.findMedian());
	}
}
