package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lv2_장애물인식프로그램 {
    public static int N;
    public static boolean[][] map;
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String rowData = st.nextToken();
            for (int j = 0; j < N; j++) {
                if (rowData.charAt(j) == '1')
                    map[i][j] = true;
            }
        }

        ArrayList<Integer> answerL = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 0;
                if (map[i][j]) {
                    DFS(i, j);
                    answerL.add(cnt);
                }
            }
        }

        System.out.println(answerL.size());
        Collections.sort(answerL);
        for (int count : answerL)
            System.out.println(count);
    }

    public static void DFS(int i, int j) {
        map[i][j] = false;
        cnt++;
        for (int t = 0; t < 4; t++) {
            int newX = i + dx[t];
            int newY = j + dy[t];
            if (newX >= 0 && newX < N && newY >= 0 && newY < N && map[newX][newY])
                DFS(newX, newY);
        }
    }
}
