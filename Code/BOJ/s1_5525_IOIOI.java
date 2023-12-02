package BOJ;

import java.io.*;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.03
 * @notes
 * - 내가 직접 반례 만들어서 풀어본 거의 첫 문제인듯!!! 반례 만드는 연습 계속 해보자!! <br>
 */

public class s1_5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        List<Long> countList = getCountList(S);
//        System.out.println(countList);

        long result = 0;
        for (long c : countList) {
            if (c >= N)
                result += c - N + 1;
        }
        System.out.println(result);
    }

    public static List<Long> getCountList(String S) {
        char target = 'I';
        long count = 0;
        List<Long> countList = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == target) {
                count++;
                target = target == 'I' ? 'O' : 'I';
            } else {
                if (count >= 3) {
                    countList.add((count - 1) / 2);
                }
                count = 0;
                target = 'I';
                if (S.charAt(i) == 'I') {
                    i--;
                }
            }
        }
        if (count >= 3) {
            countList.add((count - 1) / 2);
        }
        return countList;
    }
}

