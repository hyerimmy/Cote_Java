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
 */

public class g4_17281_야구공이모지 {
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
            if(ps.playerResult.size()==9){
                // play and update maxScore
                int playScore = getPlayScore(ps.playerResult);
                if(maxScore < getPlayScore(ps.playerResult)) maxScore=playScore;
            }
            else{
                for(int playerIdx=0; playerIdx<9; playerIdx++){
                    if(!ps.playerUsed[playerIdx]){
                        Q.add(ps.setPlayer(playerIdx));
                    }
                }
            }
        }

        System.out.println(maxScore);
    }

    public static int getPlayScore(ArrayList<Integer> P){
        int scoreSum = 0;
        int playerIdx = 0;
        for(int ining=0; ining<N; ining++){
            int outCnt = 0;
            playerIdx = 0;
            HashMap<Integer, Integer> ru = new HashMap<>();
            while(outCnt<3){
                int player = P.get(playerIdx);
                int score = S[ining][player];

                if (score == 0) { //아웃
                    outCnt++;
                } else if(score == 4){
                    scoreSum+=ru.size()+1;
                    ru.clear();
                }else {
                    for (int ruPlayer : ru.keySet()) {
                        if (ru.get(ruPlayer) + score > 3) {
                            ru.remove(ruPlayer);
                            scoreSum++;
                        } else {
                            ru.put(ru.get(ruPlayer), ru.get(ruPlayer) + score);
                        }
                    }
                    ru.put(player, score);
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
    ArrayList<Integer> playerResult;

    public PlayerSetting(){
        playerUsed = new boolean[9];
        playerResult = new ArrayList<>();

        playerUsed[3] = true;
        playerResult.add(3);
    }

    public PlayerSetting(boolean[] playerUsed, ArrayList<Integer> playerResult){
        this.playerUsed = playerUsed;
        this.playerResult = playerResult;
    }

    public PlayerSetting setPlayer(int playerIdx){
        boolean[] newPlayerUsed = playerUsed.clone();
        ArrayList<Integer> newPlayerResult = new ArrayList<>(playerResult);
        newPlayerUsed[playerIdx] = true;
        newPlayerResult.add(playerIdx);
        return new PlayerSetting(newPlayerUsed, newPlayerResult);
    }
}
