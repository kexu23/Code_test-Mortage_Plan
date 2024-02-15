package org.example;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {

    private Main main;

    @BeforeEach
    void setUp(){
        main = new Main();

    }

    @Test
    void valueAssignment() throws IOException, CsvException {

        List<String[]> testList = new ArrayList<String[]>();

        String[] testArray0 = {"Customer","Total loan","Interest","Years"};
        String[] testArray1 = {"Juha", "1000", "5", "2"};
        String[] testArray2 = {"Karvinen","4356","1.27","6"};
        String[] testArray3 = {"Claes Månsson","1300.55","8.67","2"};
        String[] testArray4 = {"\"Clarencé,Andersson\"","2000","6","4"};

        testList.addAll(Arrays.asList(testArray0, testArray1, testArray2, testArray3, testArray4));

        List<Double> result = Main.valueAssignment(testList);

        Assertions.assertEquals(Main.valueAssignment(Main.readCSV()), result);

    }

    @Test
    void inputCSV() {
    }

    @Test
    void readCSV() {
    }
}