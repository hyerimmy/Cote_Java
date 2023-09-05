package Programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 완주하지 못한 선수
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * @date 2023.09.05
 * @notes
 * - Hash 활용 <br>
 * - HashSet의 가장 큰 특징이사 사용 이유 : 중복을 거른다 <br>
 * */

class Lv1_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String name : participant) {
            int count = map.getOrDefault(name, 0);
            map.put(name, count + 1);
        }
        for (String name : completion) {
            int newCount = map.get(name) - 1;
            if (newCount == 0) map.remove(name);
            else map.put(name, map.get(name) - 1);
        }

        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer = entry.getKey();
            break;
        }
        return answer;
    }

}


