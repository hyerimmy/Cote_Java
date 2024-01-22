package Programmers;

/**
 * @title Lv2 큰 수 만들기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * @date 2024.01.22
 * @notes
 * - 고득점 kit - 그리디 <br>
 * - 시간초과 : 이진배열을 쓰지 않아도 된다면 쓰지 말것!!! 이진배열은 최대한 지양하기!!!!<br>
 * */

class Lv2_큰수만들기 {

    public static void main(String[] args) {
    }

    public String solution(String number, int k) {
        char[] numberA = number.toCharArray();
        // System.out.println(Arrays.toString(numberA));

        int target = number.length() - k; // 남은 선택 숫자 수

        // 숫자 선택
        StringBuilder sb = new StringBuilder(); // 정답
        int minIdx = 0; // 가능한 최소 인덱스
        while(target > 0){
            int maxIdx = number.length() - target; // 가능한 최대 인덱스

            int resultIdx = minIdx;
            for(int idx = minIdx; idx <= maxIdx; idx++){
                if(numberA[idx] > numberA[resultIdx]){
                    resultIdx = idx;
                }
            }
            minIdx = resultIdx + 1; // 최소 인덱스 업데이트
            sb.append(numberA[resultIdx]); // 정답에 값 추가
            target--;
        }

        return sb.toString();
    }

}


