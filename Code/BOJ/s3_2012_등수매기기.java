package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title 2012 등수 매기기
 * @link https://www.acmicpc.net/problem/2012
 * @date 2024.04.05
 * @notes - 음
 */

public class s3_2012_등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numbers);

        long result = 0;
        for (int rank = 1; rank <= N; rank++) {
            result += Math.abs(numbers.get(rank - 1) - rank);
        }

        System.out.println(result);
        br.close();
    }
}