import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class MedianValsByDateParser implements Parser {

	//Parse the input file and generate record for valid Recepient-Date combination
	public void parse(final String inputFile, final String outputFile) {
		DonationRecord token = null;
		InputValidator validator = new MedianByDateValidator();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("\\|");
				
				//Process record only when valid
				if (validator.isValid(arr)) {
					token = new DonationRecord(arr);
					//update median in map
					MedianValsByDateManager.updateMedianByDateMap(token);
				}
			}
			//Write the computation to output file
			WriteToFileByDate(MedianValsByDateManager.map, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Carry out file output operation
	private void WriteToFileByDate(TreeMap<RecipientDateKey, MapValue> map, String fileName) {
		File f = new File(fileName);
		// If old file already exist, delete it to avoid stale data.
		if (f.exists())
			f.delete();
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			
			// Prepare output string using the updated key and value pair. 
			for (RecipientDateKey key : map.keySet()) {
				MapValue value = map.get(key);
				bw.write(StringHelper.getString(key, value));
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
