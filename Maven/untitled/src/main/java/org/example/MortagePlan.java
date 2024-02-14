package org.example;

import java.util.Arrays;
import java.util.List;

import static java.lang.Float.parseFloat;

public class MortagePlan {

    public static void valueAssignment(List<String[]> customerList){

        String[] customerInfo;
        String customer;
        String customerDetails;

        for (int i = 1; i < customerList.size(); i++) {

            customerInfo = customerList.get(i);
            if (customerInfo.length > 1) {

                String name = customerInfo[0];
                double total_loan = Float.parseFloat(customerInfo[1]);
                double interest = 0.01 * parseFloat(customerInfo[2]);
                int years = Integer.parseInt(customerInfo[3]);

                //System.out.println(name + ", " + total_loan + ", " + interest + ", " + years);

                double monthlyPayment = total_loan / (12*years);

                monthlyPayment = monthlyPayment + (monthlyPayment * interest);

                System.out.println(name + " wants a loan of: " + total_loan + " which comes with " + 5 + "% of interest, which comes out to: " + monthlyPayment + "e a month");
                System.out.println("");
            }
            else {
                //System.out.println("Empty");
                continue;
            }
        }


    }

//    public double monthlyCalc(List<String[]> customerList) {
//
//        String[] customerInfo;
//        String customer;
//
//       customerInfo = customerList.get(1);
//
//        String name = customerList.get(0);
//        float total_loan = parseFloat(customerList[1]);
//        double interest = 0.01 * parseFloat(customerList[2]);
//        int years = Integer.parseInt(customerList[3]);
//
//        double monthlyPayment = total_loan / (12*years);
//
//        monthlyPayment = monthlyPayment * interest;
//
//        return monthlyPayment;
//    }

    public double monthlyCalcTestJuha() {


        String name = "Juha";
        float total_loan = 1000;
        double interest = 0.05;
        int years = 2;

        double monthlyPayment = total_loan / (12*years);

        monthlyPayment = monthlyPayment + (monthlyPayment * interest);

        System.out.println(name + " wants a loan of: " + total_loan + " which comes with " + 5 + "% of interest, which comes out to: " + monthlyPayment + "e a month");

        return monthlyPayment;
    }
}
