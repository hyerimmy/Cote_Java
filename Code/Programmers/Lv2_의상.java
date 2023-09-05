package Programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * @title Lv2 의상
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * @date 2023.09.05
 * @notes
 * - Hash 활용 <br>
 * - HashSet의 가장 큰 특징이사 사용 이유 : 중복을 거른다 <br>
 * */

class Lv2_의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1],clothMap.getOrDefault(cloth[1],0)+1);
        };
        int answer = 1;
        for (Map.Entry<String, Integer> entry : clothMap.entrySet()){
            answer *= (entry.getValue()+1);
        }

        return answer-1;
    }

}


