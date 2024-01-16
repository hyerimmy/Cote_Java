package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * @title Lv3 입국심사
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * @date 2024.01.16
 * @notes
 * - 이분탐색 활용 문제!! 익혀두기 <br>
 * - long으로 계산할 때 int 그대로 쓰면 큰 값 계산할 때 오류 발생한다. 계산식 곳곳에 (long) 넣어서 형변환 시켜 계산하도록 한다!! <br>
 */

class Lv3_입국심사__이분탐색 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7,10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 1;
        long max = (long)times[times.length-1] * n;
        long answer = max;

        while(min <= max){
            long target = (min + max) / 2;
            // System.out.println(min+" "+max+" -> "+target);

            // 최대 심사수 계산
            long count = 0;
            for(int time : times){
                count += target / time;
                if (count > n) {
                    break;
                }
            }

            // 최대 심사수에 따라 범위 조정
            if (count < n) {
                min = target + 1;
            } else if (count >= n) {
                answer = target;
                max = target - 1;
            }
        }

        return answer;
    }

}

