package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @title Lv1 K번째수
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12198
 * @date 2023.09.06
 * @notes
 * - 정렬 프로그래머스 고득점 kit<br>
 * */

class Lv1_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int j=0; j<commands.length;j++){
            int[] C = commands[j];
            ArrayList<Integer> A = new ArrayList<Integer>();
            for (int i=0; i<(C[1]-C[0]+1);i++){
                A.add(array[C[0]-1+i]);
            }
            Collections.sort(A);
            answer[j] = A.get(C[2]-1);
        }
        return answer;
    }


}


