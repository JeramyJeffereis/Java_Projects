import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DB_Connect {
	//Data is assigned as a class method so it can be returned and assigned in two
	// seperate methods.
	private static ObservableList<Hospital> data = null;
    public static void main(String[] args) {
    	DB_Connect.getResults();
    }

    //getResults() pulls the table values for a given csv file. It takes a given csv filepath and opens it up using a buffered reader.
    // It reads through once to get the number of entries and then reads through again to retrieve the entry values. It then goes back
    // through the retrieved values and formats them into an ObservarbleList of Hospital objects.
    public static String getResults(){
        String csvFile = "/Users/Primary/Downloads/HospitalGeneralInformation.csv";
        BufferedReader br = null;
        BufferedReader ch = null;
        String line = "";
        String cvsSplitBy = ",";
        
        int f = 0;
        try {
            ch = new BufferedReader(new FileReader(csvFile));
            while ((line = ch.readLine()) != null) {
                // use comma as separator
                f = f + 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ch != null) {
                try {
                    ch.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        String[][] country = new String[f][];
        int i = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                country[i] = line.split(cvsSplitBy);
                i = i + 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      
        String[] str = new String[i];
		Hospital[] HSList = new Hospital[i];
		int x = 1;
		int y;
		for(y = 0; y < (i-1); y++) {
			HSList[y] = new Hospital(country[x]);
			x++;
		}
		data = FXCollections.observableArrayList(HSList);
		String result = String.join(System.lineSeparator(), str);
		
        return result;
    }
    
    public static ObservableList returnData() {
    	return data;
    }
}