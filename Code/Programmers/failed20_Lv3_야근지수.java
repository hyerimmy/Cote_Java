package Programmers;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @title Lv3 아이템 줍기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * @date 2023.09.30
 * @notes
 * - 합이 일정한 두 값의 제곱의 합이 최소가 되는 조건은, 두 값이 동일할 때이며, 이는 값의 수가 늘어나더라도 동일합니다. 따라서 최대한 모든 값이 동일해지도록 처리해야하는 방향으로 접근해야 합니다. <br>
 */

class failed20_Lv3_야근지수 {
    public static void main(String[] args) {
    }

    public static long solution(int n, int[] works) {
        int sum = -n;
        for(int i=0; i<works.length; i++){
            sum+=works[i];
        }
        if(sum<0) return 0;

        int a = sum/works.length;
        int b = sum%works.length;
        long answer = 0;

        for(int i=0; i<works.length; i++){
            long number = (long)a;
            if(b>0) {
                number+=1;
                b--;
            }
            answer += number*number;
        }


        return answer;
    }

}

