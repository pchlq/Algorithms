import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pavel Peskov
 */
public class FractionalKnapsack {

    public static void main(String[] args) {

        // discrete Knapsack
        int[] values = {20, 18, 14};
        int[] weights = {4, 3, 2};
        int CAPACITY = 7;

        int res = discreteKnapsack(values, weights, CAPACITY);
        System.out.println(res);


        // fractional Knapsack
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);
        final int W = 7;

        final Item[] items = {item1, item2, item3};

        // O(N log N)
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());
        System.out.println(Arrays.toString(items));

        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) *
                        items[currentItem].getValue();

                weightSoFar = W;
            }

            currentItem++;
        }
        System.out.println(valueSoFar);

    }

    public static int discreteKnapsack(int[] values, int[] weights, int capacity) {
        int[] specificWeights = new int[weights.length];
        int result = 0;

        for (int i = 0; i < weights.length; i++) {
            specificWeights[i] = values[i] / weights[i];
        }

        int[] idx = new int[weights.length];
        int pos = 0;
        Arrays.fill(idx, -1);
        int[] maxValues = new int[weights.length];

        for (int i = 0; i < specificWeights.length; i++) {
            int max = 0;
            for (int j = 0; j < specificWeights.length; j++) {
                if (specificWeights[j] > max && !isContainsIdx(idx, j)) {
                    max = specificWeights[j];
                    pos = j;
                }
            }
            idx[i] = pos; // [2, 1, 0]
            maxValues[i] = max; //[7, 6, 5]
        }

        for (int i = 0; i < idx.length; i++) {
            int index = idx[i];
            if (weights[index] <= capacity) {
                result += values[index];
                capacity -= weights[index];
            } else {
                result += (weights[index] - capacity) * values[index] / weights[index];
                break;
            }
        }
        return result;
    }

    static boolean isContainsIdx(int[] arr, int key) {
        return Arrays.stream(arr).anyMatch(e -> e == key);
    }
}

class Item {
    /*
     * Class for fractional way implementation
     */
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
