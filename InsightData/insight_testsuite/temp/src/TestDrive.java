import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Driver class for medianvals_by_zip and medianvals_by_date parsing logic.
 * @author Pranoti
 *
 */
public class TestDrive {
	public static void main(String[] args) {
		Parser medianByZipParser = new MedianValsByZipParser();
		Parser medianByDateparser = new MedianValsByDateParser();
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		Path filePath = Paths.get(currentPath.toString(), Constants.INPUTFOLDER, Constants.INPUTFILENAME);
		String inputFile = filePath.toString();
		filePath = Paths.get(currentPath.toString(), Constants.OUPUTFOLDER, Constants.ZIPFILEOUTPUT);
		String outFileZip = filePath.toString();
		filePath = Paths.get(currentPath.toString(), Constants.OUPUTFOLDER, Constants.DATEFILEOUTPUT);
		String outFileDate = filePath.toString();
		medianByZipParser.parse(inputFile, outFileZip);
		medianByDateparser.parse(inputFile, outFileDate);
	}

}
