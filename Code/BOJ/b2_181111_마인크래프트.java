package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.11.
 * @notes - 에센셜2++ <br>
 */

public class b2_181111_마인크래프트 {

    public static int[][] map;
    public static int N;
    public static int M;
    public static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 수

        map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int answerTime = -1;
        int answerHeight = 0;

        for(int targetH = 0; targetH <= 256; targetH++){
            int time = getTime(targetH);
            if(time == -1)
                continue;
            if(time <= answerTime || answerTime == -1){
                answerTime = time;
                answerHeight = targetH;
            }
        }

        System.out.println(answerTime+" "+answerHeight);
    }

    public static int getTime(int targetH){
        int time = 0;
        long block = B;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(map[n][m] > targetH){ // 제거
                    time += (map[n][m] - targetH) * 2;
                    block += map[n][m] - targetH;
                }
                if(map[n][m] < targetH) { // 추가
                    time += (targetH - map[n][m]);
                    block -= targetH - map[n][m];
                }
            }
        }
        if(block < 0)
            return -1;
        return time;
    }
}