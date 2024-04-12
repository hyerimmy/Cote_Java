package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2623
 * @date 2024.04.12
 * @notes - <br>
 */

public class _failed_g3_2623_음악프로그램 {
    public static int N;
    public static boolean[] selected;
    public static List<HashSet<Integer>> prevList = new ArrayList<>();
    public static List<Integer> results = new ArrayList<>();
    public static HashSet<Integer> history = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        selected = new boolean[N + 1];

        // 가수 순서 리스트 크기 지정
        for (int n = 0; n <= N; n++) {
            prevList.add(new HashSet<>());
        }

        // 순서 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for (int s = 1; s < size; s++) {
                int current = Integer.parseInt(st.nextToken());
                prevList.get(current).add(prev);
                prev = current;
            }
        }

        // 탐색 진행
        boolean canOrder = false;
        for (int singer = 1; singer <= N; singer++) {
            if (!selected[singer]) {
                history = new HashSet<>();
                canOrder = select(singer);
            }

            if (!canOrder) break;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        if (!canOrder) {
            sb.append(0);
        } else {
            for (int singer : results) {
                sb.append(singer).append("\n");
            }
        }
        System.out.println(sb);
        System.out.println(results);
    }

    private static boolean select(int n) {
        history.add(n);
        selected[n] = true;

        for (int prev : prevList.get(n)) {
            if (history.contains(prev))
                return false;

            if (!selected[prev]) {
                boolean canSelect = select(prev);
                if (!canSelect) return false;
            }
        }

        results.add(n);
        return true;
    }
}

/*
5 3
3 3 1 2
4 3 1 4 5
2 4 3


5 2
5 3 1 2 5 2
4 3 1 4 5


5 2
5 3 1 2 5 2
4 3 1 4 5


2 1
1 1


4 2
2 4 2
3 4 2 1

4 2
3 2 3 4
2 4 2
-> 0

 */

