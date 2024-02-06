package Programmers;

/**
 * @title Lv3 억억단을 외우자
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/138475
 * @date 2024.02.06
 * @notes - 약수 구하는 알고리즘 개선으로 시간 초과 해결! <br>
 * - sqrt 대신 n1(1~e), n2(1~e/n1)의 곱을 통한 약수 카운팅!!!
 */

class Lv3_억억단을외우자 {

    public static void main(String[] args) {
    }

    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1]; // (1~e까지의) 약수 개수
        int[] max = new int[e + 1]; // 각 범위의 최대값

        // (1~e까지의) 약수 개수 계산
        for (int n1 = 1; n1 <= e; n1++) {
            for (int n2 = 1; n2 <= e / n1; n2++) {
                count[n1 * n2]++;
            }
        }

        // 최대값 구하기
        max[e] = e;
        for (int n = e - 1; n >= 1; n--) {
            max[n] = max[n + 1];
            if (count[n] >= count[max[n]])
                max[n] = n;
        }

        // System.out.println(Arrays.toString(count));
        // System.out.println(Arrays.toString(max));

        // 결과 저장
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = max[starts[i]];
        }

        return answer;
    }

}


