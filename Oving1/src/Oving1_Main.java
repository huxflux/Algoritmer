/** 1-1 Lag og implementer en algoritme som finner hvilken kj0ps- og
 * salgstidspunkt som l0nner seg best. Sjekk ta algoritmen virker.
 *
 * L0sning paa gitt staticArray: Kj0p paa dag 3 (-9)/(-7) og selg paa dag 7 (2)/(-1)
 */

public class Oving1_Main {
    public static void main(String[] args) {
        int[] staticArray = {-1, 3, -9, 2, 2, -1, 2, -1, -5};

        int[] minmaxDay = einstein(staticArray, staticArray.length);
        System.out.println("Buy: day " + minmaxDay[0] + "\n" + "Sell: day " + minmaxDay[1]);

    }

    /* Inn: int[] tabell med positive & negative integers, int lengde paa tabell.
       Ut: Beste kj0ps- og salgstidspunkt.
    */
    public static int[] einstein(int[] valuesArray, int n) {
        int initialValue, tempValue;
        int maxDiff = 0;                                            // Maks. differanse
        int[] minmaxDay = new int[2];                               // Kj0psdag, salgsdag

        int[] array = new int[n];                                   // Beregn riktig kurs og legg disse til 'array'
        array[0] = valuesArray[0];
        for (int i = 1; i < n; i++) {
            array[i] = array[i - 1] + valuesArray[i];
        }


        for (int i = 0; i < n; i++) {
            initialValue = array[i];                                // Hente f0rste element og finn differansen av de andre elementene
            for (int j = i; j != n; j++) {                          //
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
}
