package mk;

public class SchoolPlay {

    public static void main(String[] args) {
        int sum;
        int i;
        for (int k = 1; k <= 100; k++) {
            i = 1;
            sum = 0;
            while (i <= k / 2) {
                if (k % i == 0) {
                    sum = sum + i;
                }
                i++;
            }
            if (sum == k) {
                System.out.println(sum);
            }
        }
    }
}
