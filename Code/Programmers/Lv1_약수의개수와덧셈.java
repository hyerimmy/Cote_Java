package Programmers;

/**
 * @title Lv1 약수의 개수와 덧셈
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * @date 2024.03.17
 * @notes - 쉬운문제 <br>
 */

class Lv1_약수의개수와덧셈 {
    public static void main(String[] args) {
    }

    public int solution(int left, int right) {
        int[] count = new int[1001];

        for (int n = 1; n <= right; n++) {
            for (int target = left; target <= right; target++) {
                if (target % n == 0) {
                    count[target]++;
                }
            }
        }

        int answer = 0;
        for (int target = left; target <= right; target++) {
            // System.out.println(target+" "+count[target]);
            if (count[target] % 2 == 0) {
                answer += target;
            } else {
                answer -= target;
            }
        }
        return answer;
    }

}


