package string;

import java.util.Locale;

public class LicenseKeyFormatting {

    public static String solve(String s, int k) {
        s = s.replace("-", "");
        s = s.toUpperCase();
        int keyLength = s.length();

        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i = keyLength - 1; i > -1; i--) {
            if (index % k == 0 && index != 0) {
                builder.append("-");
            }
            builder.append(s.charAt(i));

            index++;
        }
        builder.reverse();

        return builder.toString();
    }

    public static void main(String[] args) {
        String solve = solve("5F3Z-2e-9-w", 4);
        System.out.println("solve = " + solve);
    }

}
