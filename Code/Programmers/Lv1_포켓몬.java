package Programmers;

import java.util.HashSet;

/**
 * @title Lv1 포켓몬
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * @date 2023.09.05
 * @notes
 * - Hash 활용 <br>
 * - HashSet의 가장 큰 특징이사 사용 이유 : 중복을 거른다 <br>
 * */

class Lv1_포켓몬 {
    public static void main(String[] args) {
//        int[] nums = {3,1,2,3};
//        System.out.println(solution(nums));

//        int[] nums = {3,3,3,2,2,4};
//        System.out.println(solution(nums));

        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> type = new HashSet<Integer>();
        for (int num : nums) type.add(num);
        int resultSize = nums.length/2;
        if (type.size() < resultSize) return type.size();
        else return resultSize;
    }

}


