package Programmers;

import java.util.Stack;

/**
 * @title Lv1 햄버거 만들기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * @date 2023.10.02
 * @notes
 * */

class Lv1_햄버거만들기 {
    public static void main(String[] args) {
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> S = new Stack<>();
        int state = 0;

        for(int value : ingredient){
            if(value==1){ //빵이라면
                Stack<Integer> tempS = new Stack<>();
                boolean avaliable = true;
                for(int k=3;k>0;k--){
                    if(!S.empty()){
                        int tempV = S.pop();
                        tempS.push(tempV);
                        if(k==tempV) continue;
                    }
                    avaliable=false; break;
                }
                if(!avaliable){
                    while(!tempS.empty()) {S.push(tempS.pop());}
                    S.push(value);
                }
                else{
                    answer += 1;
                }
            }
            else{ // 빵이 아니라면
                S.push(value);
            }

            // System.out.println("*");
            // System.out.println("value : "+value);
            // System.out.println("answer : "+answer);
            // System.out.println(S);

        }
        return answer;
    }


}


