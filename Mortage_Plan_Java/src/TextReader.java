
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class TextReader {

    public static File inputCSV(){

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();

        //In response to a button click:
        int result = fc.showOpenDialog(null);

        // This assumes user pressed Open
        // Get the file from the file
        File file = fc.getSelectedFile();

        return file;
    }

    public static void readCSVScanner() throws IOException {


        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(inputCSV());

        sc.useDelimiter(",");   //sets the delimiter pattern


        try {
            while (sc.hasNext()) {
                System.out.print(sc.next());  //find and returns the next complete token from this scanner
            }

            sc.close();  //closes the scanner

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String[] readCSVBufferedReader() throws IOException {

        String line = "";
        String splitBy = ",";
        String delimiter = "\"";


        try {
            BufferedReader br = new BufferedReader(new FileReader(inputCSV()));

            String[] Customer = new String[0];

            //br.readLine(); // this will read the first line
            //String line1=null; //skips the first first line of text which are labels


            while ((line = br.readLine()) != null) {   //returns a Boolean value
                if (line.startsWith("\""))

                Customer = line.split(splitBy);

                System.out.println("Customer [Name=" + Customer[0] + ", Total loan=" + Customer[1] + ", Interest=" + Customer[2] + ", Years=" + Customer[3] + "]");
            }
            return Customer;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}


