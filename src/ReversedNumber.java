/**
 * @author Pavel Peskov
 */
public class ReversedNumber {
    public static void main(String[] args) {

        int N = 235684729;
        int res = reversedNumber(N);
        System.out.println(res);

    }

    public static int reversedNumber(int n) {

        int result = 0;
        int residual = 0;

        while (n > 0) {
            residual = n % 10;
            result = result * 10 + residual;
            n /= 10;
        }

        return result;
    }
}
