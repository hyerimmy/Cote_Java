package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/10431
 * @date 2024.04.17
 * @notes - 14:05 ~ 15:09 (수업중풀이) 망할 3트..^^<br>
 * - 반례를 매번 생각해낼 수 없으니 로그 찍어서 내가 생각한 로직이 맞는지 검증하는건 꼭 해보기 귀찮아도!!! <br>
 */

/*
항상 20, 같은 키 없음
아무나 한 명 맨 앞,
키 큰 학생 없다면 맨 뒤에
키 큰 학생 있다면 그 중 첫 번째 학생 앞에 서기 -> counting

901 902 903 904 905 906 907 908 909 910 911 912 913 914 915 916 917 918 919 900
 1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  0
 0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19

918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900 919
 0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  0 -> 앞에 나보다 큰 것부터 지금까지의 개수
19*9 = 171

20 * 20 * 1000 = 200,000

 */
public class s5_10431_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int p = 0; p < P; p++) {
            int count = 0;
            long[] height = new long[20];

//            String test = "918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900 919";
//            st = new StringTokenizer(test);
//            sb.append(p + 1).append(" ");
            st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");

            for (int idx = 0; idx < 20; idx++) {
                int current = Integer.parseInt(st.nextToken());

                long[] newHeight = new long[20];
                boolean useCurrent = false;
                int prevIdx = 0;

                for (int i = 0; i <= idx; i++) {
                    if (idx == 0) {
                        newHeight[0] = current;
                        break;
                    }

                    // 아직 current를 세우지 못했는데 큰 사람 발견했다면
                    if (!useCurrent && current < height[prevIdx]) {
                        count += idx - prevIdx;
                        newHeight[i] = current;
                        useCurrent = true;
                    } else {
                        newHeight[i] = height[prevIdx++];
                    }
                }

                if (!useCurrent) {
                    newHeight[idx] = current;
                }

                height = newHeight;
//                System.out.println(Arrays.toString(height));
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}

/*
1
2 919 918 917 916 915 914 913 912 911 910 909 908 907 906 905 904 903 902 901 900

1
1 19 20 17 18 15 16 13 14 11 12 9 10 7 8 5 6 3 4 1 2
 */