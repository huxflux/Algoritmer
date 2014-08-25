import java.util.Date;

/**
 * x*n kan defineres ved x^n = { 1 naar n = 0
 *                             { x * (x^2)^(n-1)/2 naar n er et oddetall
 *                             { (x^2)^n/2 naar n er et partall.
 *
 * Programmer dette, og sammenlikn tidsforbruket ved stor n med den fra oppgave
 * 2.1-1. Kan du forklare forskjellen?
 */

public class Oving2_main_221 {
    public static void main(String[] args) {

        double number = 1.001;
        int exponent = 14000;

        double myPowSolution, mathPowSolution;

        double tid;
        Date sluttid;
        Date starttid = new Date();


        myPowSolution = (myPow(number, exponent));

        sluttid = new Date();
        tid = (double)(sluttid.getTime()-starttid.getTime());

        System.out.println("myPow(" + number +", " + exponent + ")" + " = " + myPowSolution);
        System.out.println(tid + " ms");
    }

    /**
     * En rekursiv algoritme som regner ut et tall med eksponent.
     * Inn: double tall, integer eksponent.
     * Ut: double tall.
     */

    public static double myPow(double number, int n) {
        if (n == 0) {                               // basis
            return 1;
        }
        if (n % 2 == 0) {                           // partall hvis sant
            return myPow(number * number, n / 2);
        } else {                                    // oddetall hvis ikke
            return (number * myPow(number * number, (n - 1) / 2));
        }
    }
}
