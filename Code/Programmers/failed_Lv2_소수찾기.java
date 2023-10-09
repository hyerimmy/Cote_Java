package Programmers;

import java.util.*;

/**
 * @title Lv2 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * @date 2023.10.09
 * @notes
 * - BFS 활용 <br>
 * */

class failed_Lv2_소수찾기 {
    public static void main(String[] args) {
    }

    static ArrayList<Integer> answer = new ArrayList<>();

    public static int solution(String numbers) {
        BFS(numbers);
        return answer.size();
    }

    public static void BFS(String numbers){
        Queue<String[]> Q = new LinkedList<>();
        for(int i=0; i<numbers.length(); i++){
            Q.add(new String[] {
                    numbers.substring(i,i+1),
                    numbers.substring(0,i)+numbers.substring(i+1)
            });
            System.out.println(numbers.substring(i,i+1)+"/"+numbers.substring(0,i)+numbers.substring(i+1));
        }

        while(!Q.isEmpty()){
            String[] N = Q.poll();
            if(N[1].length()==0){
                int resultN = Integer.parseInt(N[0]);
                if(!answer.contains(resultN)){
                    answer.add(resultN);
                }
            }
            else{
                for(int i=0; i<N[1].length(); i++){
                    Q.add(new String[] {
                            N[0]+N[1].charAt(i),
                            N[1].substring(0,i)+N[1].substring(i+1)
                    });
                    System.out.println(N[0]+N[1].charAt(i)+"/"+N[1].substring(0,i)+N[1].substring(i+1));
                }
            }
        }

    }
}


