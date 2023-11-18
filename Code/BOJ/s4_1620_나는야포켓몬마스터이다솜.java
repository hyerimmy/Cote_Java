package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.19.
 * @notes - 에센셜3<br>
 */

public class s4_1620_나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numberKeybook = new HashMap<>();
        HashMap<String, Integer> nameKeybook = new HashMap<>();
        for (int n = 1; n <= N; n++) {
            String name = br.readLine();
            numberKeybook.put(n, name);
            nameKeybook.put(name, n);
        }

        StringBuilder answer = new StringBuilder();
        for (int m = 0; m < M; m++) {
            String input = br.readLine();
            if (input.charAt(0) - '0' <= 9) // 숫자라면
                answer.append(numberKeybook.get(Integer.parseInt(input))).append("\n");
            else // 이름이라면
                answer.append(nameKeybook.get(input)).append("\n");
        }

        System.out.println(answer);
    }
}

