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

        Assertions.assertEquals("C:\\Users\\Kevin\\Documents\\GitHub\\Code_test-Mortage_Plan\\prospects.txt", Main.inputCSV());
    }

    @Test
    void readCSV() throws IOException, CsvException {
/*
        List<String[]> testList = new ArrayList<String[]>();

        String[] testArray0 = {"Customer","Total loan","Interest","Years"};
        String[] testArray1 = {"Juha", "1000", "5", "2"};
        String[] testArray2 = {"Karvinen","4356","1.27","6"};
        String[] testArray3 = {"Claes Månsson","1300.55","8.67","2"};
        String[] testArray4 = {"\"Clarencé,Andersson\"","2000","6","4"};
        String[] testArray5 = {"\n"};
        String[] testArray6 = {"\n"};
        String[] testArray7 = {"\n"};
        String[] testArray8 = {"\n"};
        String[] testArray9 = {"\n"};
        String[] testArray10 = {"\n"};
        String[] testArray11 = {"\n"};
        String[] testArray12 = {"\n"};
        String[] testArray13 = {"\n"};
        String[] testArray14 = {"\n"};
        String[] testArray15 = {"."};

        testList.addAll(Arrays.asList(testArray0, testArray1, testArray2, testArray3, testArray4, testArray5, testArray6, testArray7, testArray8, testArray9, testArray10, testArray11, testArray12, testArray13, testArray14, testArray15));

        Assertions.assertArrayEquals(testList, Main.readCSV());

 */
    }
}