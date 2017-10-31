import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MedianValsByZipParser implements Parser {
	
	//Parse the input file and generate record for valid Recepient-Zip combination
	public void parse(final String inputFile, final String outputFile) {
		DonationRecord record = null;
		InputValidator validator = new MedianByZipValidator();
		File f = new File(outputFile);
		
		// If old file already exist, delete it to avoid stale data
		if (f.exists())
			f.delete();
		BufferedWriter bw = null;
		FileWriter fw = null;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line;
			fw = new FileWriter(outputFile, true);
			bw = new BufferedWriter(fw);
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("\\|");
				
				//Process record only when valid
				if (validator.isValid(arr)) {
					record = new DonationRecord(arr);
					//update median in map
					String strByZip = MedianValsByZipManager.updateMedianByZipMap(record);
					
					//Write the computation to output file
					bw.write(strByZip);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
