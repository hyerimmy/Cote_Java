package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.28
 * @notes
 * - 골드 따자<br>
 * - 9명인데 4번타자 고정, 8명 정렬 경우의 수는 40320, N이닝이니까 -> 40320N
 * - 모든 경우의 수 계산해서 최대값 찾아야 한다.
 * - 왜 에러나는지 모르겠다~ 아~
 * - 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정 -> 1번 사람을 4번째로 (문제 해석 잘못해서 오류났었던)
 * - ㅎㅎ 시간초과? 장난하나..
 * - 시간초과의 이유!!!!!! -> Queue는 시간복잡도가 큰 편이니까 가능하면 배열이나 배열리스트 사용하기!!!!! <-
 */

public class g4_17281_야구공이모지 {
    public static int N;
    public static int[][] S;
    public static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        S = new int[N][9];
        for(int[] sUnit : S){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++){
                sUnit[i] = Integer.parseInt(st.nextToken());
            }
        }

        // player setting
        Queue<PlayerSetting> Q = new LinkedList<>();
        Q.add(new PlayerSetting());
        while(!Q.isEmpty()){
            PlayerSetting ps = Q.poll();
            if(ps.completeCnt==9){
                // play and update maxScore
                calculatePlayScore(ps.playerOrder);
            }
            else{
                for(int playerIdx=0; playerIdx<9; playerIdx++){
                    if(!ps.playerUsed[playerIdx]){
                        Q.add(ps.setPlayerOrder(playerIdx));
                    }
                }
            }
        }

        System.out.println(maxScore);
    }

    public static void calculatePlayScore(int[] P){
        int scoreSum = 0;
        int playerIdx = 0;
        boolean[] ru;
        for(int ining=0; ining<N; ining++){
            if(maxScore>scoreSum+(N-ining)*24) break;
            int outCnt = 0;
            ru = new boolean[3];
            while(outCnt<3){
                int player = P[playerIdx];
                int score = S[ining][player];

                if (score == 0) { //아웃
                    outCnt++;
                }else {
                    for(int i=2; i>=0; i--){
                        if(ru[i]){
                            if(i+score > 2){
                                scoreSum++;
                            }
                            else{
                                ru[i+score]=true;
                            }
                            ru[i]=false;
                        }
                    }
                    if(score==4) scoreSum++;
                    else ru[score-1]=true;
                }
                playerIdx++;
                if(playerIdx==9) playerIdx=0;
            }
        }
        if(maxScore < scoreSum) maxScore=scoreSum;
    }
}

class PlayerSetting{
    boolean[] playerUsed;
    int[] playerOrder;
    int completeCnt;

    public PlayerSetting(){
        playerUsed = new boolean[9];
        playerOrder = new int[9];
        completeCnt = 0;

        //1번 사람을 4번째로
        playerUsed[0] = true;
        playerOrder[3] = 0;
        ++completeCnt;
    }

    public PlayerSetting(boolean[] playerUsed, int[] playerOrder, int completeCnt){
        this.playerUsed = playerUsed;
        this.playerOrder = playerOrder;
        this.completeCnt = completeCnt;
    }

    public PlayerSetting setPlayerOrder(int playerIdx){
        boolean[] newPlayerUsed = playerUsed.clone();
        int[] newPlayerOrder = playerOrder.clone();
        newPlayerUsed[playerIdx] = true;
        if(completeCnt<4) newPlayerOrder[completeCnt-1]=playerIdx;
        else newPlayerOrder[completeCnt]=playerIdx;
        return new PlayerSetting(newPlayerUsed, newPlayerOrder, completeCnt+1);
    }
}
