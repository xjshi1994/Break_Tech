import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CSVOperations {

    private final Charset charset;
    private final String inputPath;
    private final String outputPath;
    public CSVOperations(String inputPath, String outputPath, String charset) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.charset = Charset.forName(charset);
    }


    /*
    * @params: int[] display
    *           the numbers of columns to show in the ouput
    * @params: int[] key
    *           the numbers of columns to determine the duplication of the row
    * */
    public void removeDup(int[] display, int[] key) {
        int displayLength = display.length;
        int keyLength = key.length;
        HashMap<Integer, String> prevKeys = new HashMap<>();
        for (int k : key) {
            prevKeys.put(k, null);
        }

        try (Reader reader = Files.newBufferedReader(Paths.get(inputPath), charset);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath), charset);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord: csvParser) {
                boolean notEqual = false;
                String[] toWrited = new String[displayLength];

                for (int k : key) {
                    if (csvRecord.get(k).equals(prevKeys.get(k))) {
                    } else {
                        notEqual = true;
                    }
                    prevKeys.put(k, csvRecord.get(k));
                }

                // get the record
                if (notEqual) {
                    for (int i = 0 ; i < displayLength; i++) {
                        toWrited[i] = csvRecord.get(display[i]);
                    }
                    csvPrinter.printRecord(toWrited);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
