import java.util.Date;

/** 1-1 Lag og implementer en algoritme som finner hvilken kj0ps- og
 * salgstidspunkt som l0nner seg best. Sjekk ta algoritmen virker.
 *
 * L0sning paa gitt staticArray: Kj0p paa dag 3 (-9)/(-7) og selg paa dag 7 (2)/(-1)
 */

public class Oving1_Main {
    public static void main(String[] args) {
        int[] staticArray = {-1, 3, -9, 2, 2, -1, 2, -1, -5};
//        int numberOfElements = 100;
        int maxValue = 10;
        int minValue = -10;

//        int[] minmaxDay = einstein(staticArray, staticArray.length);
//        System.out.println("Buy: day " + minmaxDay[0] + "\n" + "Sell: day " + minmaxDay[1]);

        double time = 1.0;
        int start = 100;

        for (int numberOfElements = start; numberOfElements < 1000*start; numberOfElements *= 2) {
            int[] array = new int[numberOfElements];
            array = makeRandomArray(numberOfElements, maxValue, minValue);

            Date starttid = new Date();
            Date sluttid = new Date();
            int antRunder = 0;

            while (sluttid.getTime()-starttid.getTime()<10) {
                einstein(array, numberOfElements);
                sluttid = new Date();
                antRunder++;
            }
            double forrigeTid = time;
            time = (double)(sluttid.getTime()-starttid.getTime())/antRunder;
            System.out.format("Antall: %6d, tid: %8.2f ms, forholdstall: %6.2f, antall runder: %6d%n",numberOfElements,time,time/forrigeTid, antRunder);
//            int[] minmaxDay = einstein(makeRandomArray(numberOfElements, maxValue, minValue), numberOfElements);

//            System.out.println("Buy: day " + minmaxDay[0] + "\n" + "Sell: day " + minmaxDay[1]);
        }
    }

    /* Inn: int[] tabell med positive & negative integers, int lengde paa tabell.
       Ut: int[] tabell Beste kj0ps- og salgstidspunkt.
    */
    public static int[] einstein(int[] array, int n) {
        int initialValue, tempValue;
        int maxDiff = 0;                                            // Maks. differanse
        int[] minmaxDay = new int[2];                               // Kj0psdag, salgsdag

        for (int i = 1; i < n; i++) {                               // Beregner reell aksjeverdie for hver av dagene og
            array[i] = array[i - 1] + array[i];                     // legger de verdiene tilbake til samme tabell
        }

        for (int i = 0; i < n; i++) {
            initialValue = array[i];                                // Hente f0rste element og finn differansen av de andre elementene
            for (int j = i; j < n; j++) {
                if (array[j] > initialValue) {                      // Hvis et element er st0rre enn det f0rste elementet
                    tempValue = Math.abs(array[j] - initialValue);  // finn differansen (absoluttverdi)
                    if (tempValue > maxDiff) {                      // Hvis abs.verdien er st0rre en maxDiff (maksimal differanse)
                        maxDiff = tempValue;                        // sett ny maxDiff
                        minmaxDay[0] = i+1;                         // 'i' inneholder kj0psdag
                        minmaxDay[1] = j+1;                         // 'j' inneholder salgsdag
                    }
                }
            }
        }
        return minmaxDay;
    }
    /* Inn: int antall elementer i tabell, int max random verdi, int min random verdi
       Ut: int[] tabell med random verdier
     */
    public static int[] makeRandomArray(int numberOfElements, int maxValue, int minValue) {
        java.util.Random random = new java.util.Random();
        int[] array = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
//            System.out.print(array[i] + ", ");                                // skriv ut random array til out
        }
//        System.out.println("\n");
        return array;
    }
}