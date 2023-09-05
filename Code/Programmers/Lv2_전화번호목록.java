package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @title Lv2 전화번호 목록
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * @date 2023.09.05
 * @notes
 * - Hash 활용 <br>
 * - HashSet의 가장 큰 특징이사 사용 이유 : 중복을 거른다 <br>
 * */

class Lv2_전화번호목록 {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123", "456", "789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> numberMap = new HashMap<String, Integer>();
        HashMap<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
        for (String number : phone_book) {
            lengthMap.put(number.length(), 0);
            numberMap.put(number, 0);
        };

        boolean answer = true;
        for (Map.Entry<Integer, Integer> length : lengthMap.entrySet()){
            for (String number : phone_book) {
                if (number.length() > length.getKey()){
                    String header = number.substring(0,length.getKey());
                    if(numberMap.containsKey(header)){
                        answer = false;
                        break;
                    }
                }
            }
            if (!answer) break;
        }

        return answer;
    }

}


