import java.util.Arrays;

public class GreedyAlgSimple {

    public static void main(String[] args) {

        int[] n = {3, 1, 7, 9, 9, 5};
        System.out.println(Arrays.toString(n));
        int[] res = greedyAlg(n);
        System.out.println( Arrays.toString(n) );
        System.out.println( Arrays.toString(res) );
    }

    private static int[] greedyAlg(int[] n) {
        int[] el = new int[n.length];
        int idx = 0;

        int[] pos = new int[el.length];
        Arrays.fill(pos, -1);

        for (int i = 0; i < n.length; i++) {
            int max = 0;

            for (int j = 0; j < n.length; j++) {
                if (n[j] > max && !isContainsIdx(pos, j)) {
                    max = n[j];
                    idx = j;
                }
            }
            pos[i] = idx;
            el[i] = max;
        }
        return el;
    }

    static boolean isContainsIdx(int[] arr, int key) {
        return Arrays.stream(arr).anyMatch(e -> e == key);
    }

}
