import java.math.BigDecimal;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by mpalavelli on 03-10-2017.
 */
public class Ramanujan_PI {
    static BigDecimal finalValue = new BigDecimal(1);
    private static final BigDecimal TWO = new BigDecimal(2);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*System.out.println("Enter number of iterations");
        long rounds = scan.nextLong();
        System.out.println(findBigFact(rounds));*/
        System.out.println(sqrt(new BigDecimal(6),10000));
    }
    public static BigDecimal ramanujanSeries(int k) {
        BigDecimal equationRight = new BigDecimal(0);
        BigDecimal result = new BigDecimal(0);
        for(long i = 0; i < k; i++){
            //equationRight.addAtEnd((findBigFact(4*i).multiply(BigDecimal.valueOf(1103+26390*i))).divide(()));
        }
        return result;
    }
    private static BigDecimal findBigFact(long sourceInteger) {
        if (sourceInteger != 0) {
            finalValue = finalValue.multiply(BigDecimal.valueOf(sourceInteger));
            findBigFact(sourceInteger-1);
        }
        return finalValue;
    }
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);
        }
        return x1;
    }





    /*public static void main(String[] args) {
        //System.out.println(Factorial.calculate(4));

        int input = 0;
        args = new String[1];
        args[0] = "13";

        if(args.length ==1) {
            input = Integer.parseInt(args[0]);
            System.out.println("Pi according to Ramanujan series: " + ramanujanSeries(input));
            System.out.println("This differs from Java’s value by " + percentageDifference(ramanujanSeries(input)) + " percent.");
        }
        else {
            System.out.println("Please enter an int as an argument.");
            System.exit(0);
        }
    }

    public static double percentageDifference(double approx) {
        return (100 - ((approx / Math.PI) * 100));
    }

    public static double ramanujanSeries(int k) {
        double equationRight = 0;
        double result = 0;

        for(int i = 0; i < k; i++){
            equationRight += ((Factorial.findIntFact(4 * i)) * (1103 + (26390 * i))) / (Math.pow(Factorial.findIntFact(i), 4) * Math.pow(396, (4 * i)));
        }
        equationRight *= ((2 * Math.sqrt(2)) / 9801);
        result = 1 / equationRight;

        return result;
    }*/
}
