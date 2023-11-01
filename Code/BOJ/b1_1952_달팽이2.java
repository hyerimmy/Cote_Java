package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.01
 * @notes - 현대 기출<br>
 */

public class b1_1952_달팽이2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        int x = 0;
        int y = 0;
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{1, 0});
        Q.add(new int[]{0, 1});
        Q.add(new int[]{-1, 0});
        Q.add(new int[]{0, -1});
        int cnt = 0;
        int answer = 0;

        while(cnt<M*N-1) {
            int newX = x + Q.peek()[0];
            int newY = y + Q.peek()[1];
            if (newX>=0 && newX<N && newY>=0 && newY<M && !visited[newY][newX]){
                visited[newY][newX] = true;
                x = newX;
                y = newY;
                cnt++;
                continue;
            }
            answer++;
            Q.add(Q.poll());
        }
        System.out.println(answer);

    }
}

