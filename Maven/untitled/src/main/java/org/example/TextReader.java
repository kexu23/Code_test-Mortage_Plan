package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class TextReader {

    public static String inputCSV(){

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();

        //In response to a button click:
        int result = fc.showOpenDialog(null);

        // This assumes user pressed Open
        // Get the file from the file

        return fc.getSelectedFile().getAbsolutePath();
    }

    public static List<String[]> readCSVopencsv() throws IOException, CsvException {

        List<String[]> r;
        try (CSVReader reader = new CSVReader(new FileReader(inputCSV()))) {
            r = reader.readAll();
        }

        int listIndex = 0;
        for (String[] arrays : r) {
            System.out.println("\nString[" + listIndex++ + "] : " + Arrays.toString(arrays));

            int index = 0;
            for (String array : arrays) {
                System.out.println(index++ + " : " + array);
            }
        }
        return r;
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



