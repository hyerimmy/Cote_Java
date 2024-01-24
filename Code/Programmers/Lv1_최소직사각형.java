package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @title Lv1 최소직사각형
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * @date 2024.01.24.
 * @notes
 * - 프로그래머스 고득점 kit - 완전탐색<br>
 * */

class Lv1_최소직사각형 {
    public static void main(String[] args) {
    }

    public int solution(int[][] sizes) {
        List<Integer> bigSizeL = new ArrayList<>();
        List<Integer> smallSizeL = new ArrayList<>();

        for(int[] size : sizes){
            bigSizeL.add(Math.max(size[0], size[1]));
            smallSizeL.add(Math.min(size[0], size[1]));
        }

        // System.out.println(bigSizeL);
        // System.out.println(smallSizeL);

        return Collections.max(bigSizeL) * Collections.max(smallSizeL);
    }
}


