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
 */

public class failed_g4_17281_야구공이모지 {
    public static int N;
    public static int[][] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        S = new int[N][9];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++){
                S[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        // player setting
        int maxScore = 0;
        Queue<PlayerSetting> Q = new LinkedList<>();
        Q.add(new PlayerSetting());
        while(!Q.isEmpty()){
            PlayerSetting ps = Q.poll();
            if(ps.playerOrder.size()==9){
                // play and update maxScore
                int playScore = getPlayScore(ps.playerOrder);
                if(playScore==48){
                    getPlayScore(ps.playerOrder);
                }
                if(maxScore < getPlayScore(ps.playerOrder)) maxScore=playScore;
            }
            else{
                //1번 사람을 4번째로
                if(ps.playerOrder.size()==3){
                    Q.add(ps.setPlayerOrder(0));
                }
                else{
                    for(int playerIdx=0; playerIdx<9; playerIdx++){
                        if(!ps.playerUsed[playerIdx]){
                            Q.add(ps.setPlayerOrder(playerIdx));
                        }
                    }
                }
            }
        }

        System.out.println(maxScore);
    }

    public static int getPlayScore(ArrayList<Integer> P){
        int scoreSum = 0;
        int playerIdx = 0;
        Queue<Integer> ru = new LinkedList<>();
        for(int ining=0; ining<N; ining++){
            int outCnt = 0;
            ru.clear();
            while(outCnt<3){
                int player = P.get(playerIdx);
                int score = S[ining][player];

                if (score == 0) { //아웃
                    outCnt++;
                } else if(score == 4){ //홈런
                    scoreSum+=ru.size()+1;
                    ru.clear();
                }else {
                    int ruSize = ru.size();
                    for (int i=0; i<ruSize; i++) {
                        int ruScore = ru.poll();
                        if (ruScore + score > 3) {
                            scoreSum++;
                        }
                        else {
                            ru.add(ruScore + score);
                        }
                    }
                    ru.add(score);
                }
                playerIdx++;
                if(playerIdx==9) playerIdx=0;
            }
        }
        return scoreSum;
    }
}

class PlayerSetting{
    boolean[] playerUsed;
    ArrayList<Integer> playerOrder;

    public PlayerSetting(){
        playerUsed = new boolean[9];
        playerOrder = new ArrayList<>();

        //1번 사람을 4번째로
        playerUsed[0] = true;
    }

    public PlayerSetting(boolean[] playerUsed, ArrayList<Integer> playerOrder){
        this.playerUsed = playerUsed;
        this.playerOrder = playerOrder;
    }

    public PlayerSetting setPlayerOrder(int playerIdx){
        boolean[] newPlayerUsed = playerUsed.clone();
        ArrayList<Integer> newPlayerOrder = new ArrayList<>(playerOrder);
        newPlayerUsed[playerIdx] = true;
        newPlayerOrder.add(playerIdx);
        return new PlayerSetting(newPlayerUsed, newPlayerOrder);
    }
}
