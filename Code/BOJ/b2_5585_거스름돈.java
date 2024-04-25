package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_5585_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = 1000 - Integer.parseInt(br.readLine());

        int[] type = new int[]{500, 100, 50, 10, 5, 1};

        int count = 0;

        for (int t : type) {
            if (amount >= t) {
                count += amount / t;
                amount %= t;
            }
        }

        System.out.println(count);
    }
}

// 620 = 500 + 100 + 10*19