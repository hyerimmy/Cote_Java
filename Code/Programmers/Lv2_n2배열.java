package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 n^2배열
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * @date 2023.09.25
 * @notes
 * - long형으로 입력받는 문제일 때는 int형 변환 잘 하기!!!<br>
 * - 어디서 int로 형변환 하느냐에 따라서 반올림때문에 정확도 실패가 될 수 있음!!<br>
 * */

class Lv2_n2배열 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }

    public static int N;
    public static int[] solution(int n, long left, long right) {
        N = n;

        int[] answer = new int[(int)right-(int)left+1];
        int n1 = (int)(left/N);
        int n2 = (int)(left%N)-1;
        for(int i=0; i<answer.length;i++){
            if(++n2>=N){
                n2%=N;
                n1+=1;
            }
            answer[i] = getValue(n1,n2);
        }
        return answer;
    }

    public static int getValue(int i, int j){
        if(i==N || j==N) return N;
        else if(j<=i) return i+1;
        else return j+1;
    }


}


