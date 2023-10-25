package BOJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.25
 * @notes
 * - 골드 따자<br>
 * - 메모리 초과 오류 발생!! 너무 많은 값을 저장하면 안됨.
 * - 옴마갓~ 절대값처리 안해서 틀렸음. 사소한 수식도 주의해서 생각하기
 */

public class g5_9205_맥주마시면서걸어가기 {
    public static int[] startP;
    public static int[] endP;

    public static int[][] storePA;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] answerA = new String[T];
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            startP = new int[]{sc.nextInt(), sc.nextInt()};
            storePA = new int[N][2];
            for(int i=0; i<N; i++){
                storePA[i] = new int[]{sc.nextInt(), sc.nextInt()};
            }
            endP = new int[]{sc.nextInt(), sc.nextInt()};
            answerA[t] = BFS();
        }

        for(String answer : answerA){
            System.out.println(answer);
        }
    }

    public static String BFS(){
        Queue<State> Q = new LinkedList<>();
        boolean[] visitedStore = new boolean[storePA.length];
        Q.add(new State(startP, 20, visitedStore));
        while(!Q.isEmpty()){
            State S = Q.poll();
            if(canGo(S.P, endP, S.bottleCnt)){
                return "happy";
            }
            else{
                for(int i=0; i<storePA.length; i++){
                    if(canGo(S.P, storePA[i], S.bottleCnt) && !S.visitedStore[i]){
                        boolean[] newVisitedStore = S.visitedStore;
                        newVisitedStore[i] = true;
                        Q.add(new State(storePA[i], 20, newVisitedStore));
                    }
                }
            }
        }
        return "sad";
    }

    public static boolean canGo(
            int[] start,
            int[] end,
            int bottleCnt
    ){
        return Math.abs(end[0]-start[0])+Math.abs(end[1]-start[1])<=bottleCnt*50;
    }
}

class State{
    int[] P;
    int bottleCnt;
    boolean[] visitedStore;

    public State(int[] P, int bottleCnt, boolean[] visitedStore){
        this.P=P;
        this.bottleCnt=bottleCnt;
        this.visitedStore =visitedStore;
    }

}
