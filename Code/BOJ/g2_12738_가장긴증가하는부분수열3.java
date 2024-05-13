package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/12738
 * @date 2024.05.13
 * @notes - DP말고 이분탐색으로 바꿔보자!! <br>
 * - 잘 모르겠구요.. 졸리구요.. 어렵구요 <br>
 */

public class g2_12738_가장긴증가하는부분수열3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
//        int[] lts = new int[N];
        List<Integer> lts = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
//        numbers[0] = Integer.parseInt(st.nextToken());
//        lts.add(numbers[0]);
//        System.out.println(lts);

        lts.add(Integer.MIN_VALUE);

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            int number = numbers[i];

            if (lts.get(lts.size() - 1) < number) {
                lts.add(number);
                continue;
            }

            // 적절한 위치 찾기
            int left = 1;
            int right = lts.size() - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (number <= lts.get(mid)) {
                    right = mid - 1;
                } else if (number > lts.get(mid)) {
                    left = mid + 1;
                }
            }

            // 인덱스 넣기
            lts.set(right, number);

//            System.out.println(lts);
        }

        System.out.println(lts.size() - 1);

    }
}

