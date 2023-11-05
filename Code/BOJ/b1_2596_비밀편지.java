package BOJ;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @title 2596 비밀편지
 * @link https://www.acmicpc.net/problem/2596
 * @date 2023.10.11
 * @notes
 * - 수학식을 미리 손으로 적어 최대한 간단한 식을 도출 (코딩하기 쉬워짐) <br>
 * - 문법 익히기 위해 배열로 저장해서 풀이함. 효율을 높이기<br>
 */

public class b1_2596_비밀편지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();

        HashMap<String, String> H = new HashMap<>();
        for(String [] D : new String[][]{
                {"000000","A"}, {"001111","B"}, {"010011","C"},
                {"011100","D"}, {"100110","E"}, {"101001","F"},
                {"110101","G"}, {"111010","H"}}){
            H.put(D[0], D[1]);
            for(int i=0; i<6; i++){
                if(D[0].charAt(i)=='0'){
                    H.put(D[0].substring(0,i)+"1"+D[0].substring(i+1), D[1]);
                }
                else{
                    H.put(D[0].substring(0,i)+"0"+D[0].substring(i+1), D[1]);
                }
            }
        }
//        System.out.println(H);

        String answer = "";
        for(int k=0; k<N; k++){
            String result = H.getOrDefault(S.substring(6*k,6*k+6),"");
            if(result.equals("")){
                answer = Integer.toString(k+1);
                break;
            }
            else{
                answer += result;
            }
        }


        System.out.println(answer);
    }
}