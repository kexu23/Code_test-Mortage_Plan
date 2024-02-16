package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Float.parseFloat;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {

        valueAssignment(readCSV());

    }

    public static List<Double> valueAssignment(List<String[]> customerList){

        List<String[]> finalList = new ArrayList<>();
        String[] customerInfo;
        List<Double> monthlypayments = new ArrayList<Double>();
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for (int i = 1; i < customerList.size(); i++) {

            customerInfo = customerList.get(i);
            if (customerInfo.length > 1) {

                String name = customerInfo[0];
                double total_loan = parseFloat(customerInfo[1]);
                double interest = 0.01 * parseFloat(customerInfo[2]);
                int years = Integer.parseInt(customerInfo[3]);
                double months = 12 * years;
                double interestToThePowerOfMonths = 1 + interest;

                double result = 1;

                //System.out.println(name + ", " + total_loan + ", " + interest + ", " + years);

                // cannot use pow() so have to do it with a for loop
                for (double power = months; power != 0; power-- ) {
                    result = result * interestToThePowerOfMonths;
                }

                double monthlyPayment = (total_loan*(interest * result)) / (result - 1);


                System.out.println(name + " wants a loan of: " + total_loan + " for " + years + " years, which comes with " + 5 + "% of interest, which comes out to: " + numberFormat.format(monthlyPayment) + "e a month");
                System.out.println();

                monthlypayments.add(monthlyPayment);

                JOptionPane.showMessageDialog(null, "Name: " + name + "\n" + "Total Loan: " + total_loan + "\n" + "Years: " + years + "\n" + "Interest: " + interest*100 + "% \n" +"Monthly payment: " + numberFormat.format(monthlyPayment) + "€");


            }
            else {
                //System.out.println("Empty");
                continue;

            }
        }

        return monthlypayments;

    }

    public static String inputCSV(){

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();

        //In response to a button click:
        int result = fc.showOpenDialog(null);

        // This assumes user pressed Open
        // Get the file from the file

        return fc.getSelectedFile().getAbsolutePath();
    }

    public static List<String[]> readCSV() throws IOException, CsvException {

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

}