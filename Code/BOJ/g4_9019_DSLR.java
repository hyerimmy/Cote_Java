package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.26.
 * @notes - 에센셜3++ <br>
 * - 오른쪽 0123 -R->  1230 인 경우를 제대로 처리하지 못했음. <br>
 */

public class g4_9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(getMinFuncList(A, B)).append("\n");
        }
        System.out.println(sb);
    }

    public static String getMinFuncList(int A, int B) {
        Queue<Integer> Q = new LinkedList<>();
        String[] funcResult = new String[10000];
        Q.add(A);
        funcResult[A] = "";

        while (!Q.isEmpty()) {
            int number = Q.poll();

            int resultD = funcD(number);
            if (funcResult[resultD] == null) {
                funcResult[resultD] = funcResult[number] + "D";
                Q.add(resultD);
            }

            int resultS = funcS(number);
            if (funcResult[resultS] == null) {
                funcResult[resultS] = funcResult[number] + "S";
                Q.add(resultS);
            }

            int resultL = funcL(number);
            if (funcResult[resultL] == null) {
                funcResult[resultL] = funcResult[number] + "L";
                Q.add(resultL);
            }

            int resultR = funcR(number);
            if (funcResult[resultR] == null) {
                funcResult[resultR] = funcResult[number] + "R";
                Q.add(resultR);
            }

            if (funcResult[B] != null)
                break;

        }
        return funcResult[B];
    }

    public static int funcD(int n) {
        return (2 * n) % 10000;
    }

    public static int funcS(int n) {
        if (n == 0)
            return 9999;
        return n - 1;
    }

    public static int funcL(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    public static int funcR(int n) {
        return (n % 10) * 1000 + n / 10;
    }
}
