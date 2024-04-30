package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1037
 * @date 2024.04.30
 * @notes - <br>
 */

public class b1_1037_약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        if (list.size() == 1) {
            System.out.println((long) list.get(0) * list.get(0));
        } else {
            System.out.println((long) list.get(0) * list.get(list.size() - 1));
        }
    }
}

