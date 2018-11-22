

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CSVReader {

    private File csv;
    
    public CSVReader(String location) {
        this.csv = new File(location);
    }
    
    public String readValue() throws FileNotFoundException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:00");
        String currentTime = sdf.format(cal.getTime());

        Scanner scanner = new Scanner(this.csv);
        scanner.useDelimiter("\n");
        String tempData;
        String tempTime;
        String tempValue;
        while (scanner.hasNext()) {
            tempData = scanner.next();
            tempTime = this.seperateData(tempData)[0];
            tempValue = this.seperateData(tempData)[1];
            if (tempTime.equals(currentTime)) {
                scanner.close();
                return tempValue;
            }
        }
        scanner.close();
        return null;
    }
    
    private String[] seperateData(String toSeperate) throws FileNotFoundException {
        String[] result = new String[2];
        result[0] = toSeperate.substring(0, 8);
        result[1] = toSeperate.substring(9, toSeperate.length() - 1);
        return result;
    }
    
    
}
