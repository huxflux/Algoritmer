import java.util.Date;

/** Benytt shellsort og ta tid paa forskjellige arrays. Sjekk om tabellen er sortert.
 *  Pr0v flere deletall. Weeeeeeeeee..
 */

public class Oving3_main_shellsort {
    public static void main(String[] args) {
        final int MAGIC = 50000;
        int numberOfElements = MAGIC;
        int maxValue = 500000;
        int minValue = -500000;
        double gap = 2.4;
        int numberOf = 6;
        double[] tidsVerdier = new double[numberOf];

        System.out.println("Gap: " + gap + "\nElements: " + numberOfElements + "\nElements *= 2");
        for (int i = 0; i < numberOf; i++) {
            System.out.print(numberOfElements + "       ");
            numberOfElements *=2;
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");

        for (int j = 0; j < 10; j++) {
            numberOfElements = MAGIC;

            for (int i = 0; i < numberOf; i++) {
                int[] array = makeRandomArray(numberOfElements, maxValue, minValue);
                double tid;
                Date starttid = new Date();
                Date sluttid = new Date();
                int antRunder = 0;
                while (sluttid.getTime() - starttid.getTime() < 10) {
                    shellsort(array, gap);
                    sluttid = new Date();
                    antRunder++;
                }

                tid = (double) (sluttid.getTime() - starttid.getTime()) / antRunder;

//            System.out.println("Elements: " + numberOfElements + "\nMin/max: " + minValue + "/" + maxValue);
//            System.out.println("Gap: " + gap + "\nShellsort: " + tid + "ms" + "\nSorted: " + isSorted(array) + "\n");

                tidsVerdier[i] = tid;
                numberOfElements *= 2;
            }
            for (int i = 0; i < tidsVerdier.length; i++) {
                System.out.print(tidsVerdier[i] + "ms      ");
            }
            System.out.println();
        }
    }

    public static int[] shellsort(int[] array, double gap) {
        int s = array.length /2;
        while (s > 0) {
            for (int i = s; i < array.length; ++i) {
                int j = i, move = array[i];
                while (j >= s && move < array[j - s]) {
                    array[j] = array[j - s];
                    j -= s;
                }
                array[j] = move;
            }
            s = (s == 2) ? 1 : (int) (s / gap);
        }
        return array;
    }

    /* Inn: int antall elementer i tabell, int max random verdi, int min random verdi
       Ut: int[] tabell med random verdier
     */
    public static int[] makeRandomArray(int numberOfElements, int maxValue, int minValue) {
        java.util.Random random = new java.util.Random();
        int[] array = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }
        return array;
    }

    /* Inn: int[] array
       Ut: true hvis sortert, false hvis ikke
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /* Inn: [] array
       Ut: void
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n");
    }

    /* Inn: [] array
       Ut: [] newArray
     */
    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}