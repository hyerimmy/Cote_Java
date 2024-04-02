package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.04.02
 * @notes - <br>
 */

public class g2_1766_문제집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> nextProblems = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            nextProblems.add(new ArrayList<>());
        }

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int[] prevSolveCount = new int[N + 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nextProblems.get(A).add(B);
            prevSolveCount[B]++;
        }

        for (int n = 1; n <= N; n++) {
            if (prevSolveCount[n] == 0)
                PQ.add(n);
        }

        StringBuilder sb = new StringBuilder();
        while (!PQ.isEmpty()) {
            int p = PQ.poll();

            sb.append(p).append(" ");

            for (int next : nextProblems.get(p)) {
                prevSolveCount[next]--;
                if (prevSolveCount[next] == 0)
                    PQ.add(next);
            }
        }
        System.out.println(sb);

        br.close();
    }
}

/*
7 7
7 4
4 2
2 1
7 3
3 1
3 6
6 5
 */

/*
6 7
5 6
5 2
2 4
4 3
2 1
6 1
1 3
 */

/*
5 4
4 1
5 1
2 5
3 5
 */