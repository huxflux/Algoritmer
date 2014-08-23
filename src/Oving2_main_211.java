/** x^n kan defineres ved x^n = { 1 naar  n=0
 *                              { x * x^n-1 naar n > 0.
 *
 *  Programmer dette ved hjelp av rekursjon, og kontroller at svarene blir riktige.
 *
 */

import java.util.Date;

public class Oving2_main_211 {
    public static void main(String[] args) {
        double number = 1.001;
        int exponent = 7000;
        double myPowSolution, mathPowSolution;

        double tid, tid2;
        Date sluttid;
        Date starttid = new Date();

        myPowSolution = myPow(number, exponent);

        sluttid = new Date();
        tid = (double)(sluttid.getTime()-starttid.getTime());

        starttid = new Date();

        mathPowSolution = Math.pow(number, exponent);

        sluttid = new Date();
        tid2 = (double)(sluttid.getTime()-starttid.getTime());


        System.out.println("myPow(" + number +", " + exponent + ")" + " = " + myPowSolution);
        System.out.println("Time: " + tid + " ms");
        System.out.println("Math.pow(" + number + ", " + exponent + ")" + " = " + mathPowSolution);
        System.out.println("Time: " + tid2 + " ms");
    }
    /**
     * En rekursiv algoritme som regner ut et tall med eksponent.
     * Inn: double tall, integer eksponent.
     * Ut: double tall.
     */

    public static double myPow (double number, int n) {
        if (n == 0) {                                       // basis
            return 1;
        }
        return number * myPow(number, n - 1);               // rekursiv algoritme, kaller seg selv.
    }
}
