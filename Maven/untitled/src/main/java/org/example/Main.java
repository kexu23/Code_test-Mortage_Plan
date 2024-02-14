package org.example;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {

        //TextReader.readCSVopencsv();

        MortagePlan.valueAssignment(TextReader.readCSVopencsv());

        //MortagePlan.monthlyCalcTestJuha();

        

    }
}