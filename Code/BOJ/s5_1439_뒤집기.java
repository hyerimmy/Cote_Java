package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem/1439
 * @date 2024.04.24
 * @notes - <br>
 */

public class s5_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char prev = input.charAt(0);
        int count = 0;

        for (int i = 1; i < input.length(); i++) {
            char type = input.charAt(i);
            if (type != prev) count++;
            prev = type;
        }

        System.out.println((count + 1) / 2);
    }
}

/*
10101010
 */