package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 */

public class s3_2606_바이러스 {
    public static ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
    public static boolean[] visited;
    public static int virusComputerCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터수
        visited = new boolean[N + 1];

        int L = Integer.parseInt(br.readLine()); // 라인수

        for (int i = 0; i < N + 1; i++) {
            lines.add(new ArrayList<>());
        }

        for (int l = 0; l < L; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            lines.get(c1).add(c2);
            lines.get(c2).add(c1);
        }

        countVirusComputers(1);
        System.out.println(virusComputerCount-1);
    }

    public static void countVirusComputers(int computerIdx){
        if(visited[computerIdx]){
            return;
        }

        visited[computerIdx] = true;
        virusComputerCount++;
        for(int linkedComputerIdx : lines.get(computerIdx)){
            countVirusComputers(linkedComputerIdx);
        }
    }
}

