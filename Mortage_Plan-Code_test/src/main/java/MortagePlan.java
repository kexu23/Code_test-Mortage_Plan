import static java.lang.Float.parseFloat;

public class MortagePlan {

    public static void valueAssignment(String[] customerList){

        float total_loan;
        float interest_rate;
        String customer;

        customer = customerList[0];
        total_loan = parseFloat(customerList[1]);
        interest_rate = parseFloat(customerList[2]);

        System.out.println(customer + total_loan + interest_rate);


    }

    public static double monthlyCalc(String[] customerList) {

        String name = customerList[0];
        float total_loan = parseFloat(customerList[1]);
        double interest = 0.01 * parseFloat(customerList[2]);
        int years = Integer.valueOf(customerList[3]);

        double monthlyPayment = total_loan / (12*years);

        monthlyPayment = monthlyPayment * interest;

        return monthlyPayment;
    }

    public static double monthlyCalcTestJuha() {


        String name = "Juha";
        float total_loan = 1000;
        double interest = 0.05;
        int years = 2;

        double monthlyPayment = total_loan / (12*years);

        monthlyPayment = monthlyPayment + (monthlyPayment * interest);

        System.out.println(name + " wants a loan of: " + total_loan + "which comes with " + 5 + "% of interest, which comes out to: " + monthlyPayment + "e a month");

        return monthlyPayment;
    }
}
