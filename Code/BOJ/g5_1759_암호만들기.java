package BOJ;

import java.io.IOException;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.25
 * @notes
 * - 골드 따자<br>

 */

public class g5_1759_암호만들기 {

    static int L;
    static int C;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        int moCnt=0;
        int jaCnt=0;
        Character[] A = new Character[C];
        for(int i=0; i<C; i++){
            A[i] = sc.next().charAt(0);
            if(isMoum(A[i])){
                moCnt++;
            }
            else jaCnt++;
        }
        Arrays.sort(A);
        String poolS = "";
        for(int i=0; i<A.length; i++) poolS += A[i];

        ArrayList<String> answerA = BFS(poolS, moCnt, jaCnt);
        Collections.sort(answerA);
        for (String s : answerA) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> BFS(String poolS, int moCnt, int jaCnt){
        ArrayList<String> answerA = new ArrayList<>();

        Queue<pwSet> Q = new LinkedList<>();
        Q.add(new pwSet(poolS, moCnt, jaCnt));

        while(!Q.isEmpty()){
            pwSet P = Q.poll();
            if(P.pwS.length()==L){
                if(P.moCnt>=1 && P.jaCnt>=2 && !answerA.contains(P.pwS)) {
                    answerA.add(P.pwS);
                }
            }
            else{
                for(int i=0; i<P.pwS.length(); i++){
                    String newPwS = P.pwS.substring(0,i)+P.pwS.substring(i+1);
                    if(isMoum(P.pwS.charAt(i))){
                        Q.add(new pwSet(newPwS, P.moCnt-1, P.jaCnt));
                    }
                    else{
                        Q.add(new pwSet(newPwS, P.moCnt, P.jaCnt-1));
                    }
                }
            }

        }
        return answerA;
    }

    public static boolean isMoum(char C){
        return (C=='a' || C=='e' || C=='i' || C=='o' || C=='u');
    }
}

class pwSet{
    String pwS;
    int moCnt;
    int jaCnt;

    public pwSet(String pwS, int moCnt, int jaCnt){
        this.pwS = pwS;
        this.moCnt = moCnt;
        this.jaCnt = jaCnt;
    }
}

