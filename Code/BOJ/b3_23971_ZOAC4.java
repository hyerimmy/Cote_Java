package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/23971
 * @date 2024.05.01
 * @notes - <br>
 */

public class b3_23971_ZOAC4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 가로 : W개씩 - M칸 : Math.ceil(W/(M+1))
        // 세로 : H행 - N칸 : Math.ceil(H/(N+1))

        int result = (int) (Math.ceil((double) W / (M + 1)) * Math.ceil((double) H / (N + 1)));
        System.out.println(result);
    }
}

