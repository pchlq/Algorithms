import java.util.Arrays;
import java.util.Collections;

/**
 * @author Pavel Peskov
 */
public class GreedyAlgorithms {

    public static void main(String[] args) {

        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(Arrays.toString(digits));
        System.out.println(maxNumberFromDigits2(digits));
        System.out.println(maxNumberFromDigits(digits).equals(maxNumberFromDigits2(digits)));

        // min stops
        int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println(minStops(stations, 400));

    }

    public static String maxNumberFromDigits(int[] digits) {
        /*
         * O( n log(n) )
         */

        Arrays.sort(digits);
        String res = "";

        for (int i= digits.length - 1; i >=0; i--) {
            res += digits[i];
        }

        return res;
    }

    public static String maxNumberFromDigits2(int[] digits) {
        /*
         * O( n log(n) )
         */
        return String.join("", Arrays.stream(digits)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    public static int minStops(int[] stations, int capacity) {
        int res = 0;
        int currentStop = 0;

        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stations.length - 1 &&
                    stations[nextStop + 1] - stations[currentStop] <= capacity) {

                nextStop++;
            }

            if (currentStop == nextStop) {
                return -1;
            }

            if (nextStop < stations.length - 1) {
                res++;
            }

            currentStop = nextStop;
        }
        return res;
    }

}
