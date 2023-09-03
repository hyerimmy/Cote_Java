package Programmers;

/**
 * @title Lv2_타겟넘버
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * @date 2023.09.03
 * @notes
 * - DFS활용, 재귀함수 <br>
 * - 자신만만!해짐 <br>
 */

class Lv2_타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(solution(numbers, target));
    }
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }

    private static void DFS(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length){
            if(target==sum){
                answer++;
            }
        }
        else{
            int number = numbers[idx];
            DFS(numbers, target, idx+1, sum+number);
            DFS(numbers, target, idx+1, sum-number);
        }
    }

    }
