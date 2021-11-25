package string;

public class PlusOne {
    public static int[] solve(int[] k) {

        for (int i = k.length - 1; i > -1; i++) {
            k[i]++;
            if (k[i] < 10) {
                return k;
            }
            k[i] = 0;
        }
        k = new int[k.length + 1];
        k[0] = 1;


        return k;
    }

}
