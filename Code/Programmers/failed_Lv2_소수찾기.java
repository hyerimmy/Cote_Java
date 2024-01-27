package Programmers;

import java.util.*;

/**
 * @title Lv2 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * @date 2023.10.09
 * @notes
 * - BFS 활용 <br>
 * */

class failed_Lv2_소수찾기 {
    public static int maxN = 10_000_000;
    public static boolean[] isPrime = new boolean[maxN];
    public static int answer = 0;
    public static String N;

    public static void main(String[] args) {
    }

    public int solution(String numbers) {
        N = numbers;

        // 소수 여부 미리 저장해두기
        Arrays.fill(isPrime, true);
        for(int n = 2; n <= Math.sqrt(maxN); n++){
            checkPrime(n);
        }

        // 숫자 만들기
        setNumber(0, 0);

        return answer;
    }

    public void setNumber(int result){
        System.out.println(result);

        for(int i = startIdx; i < N.length(); i++){
            setNumber(i+1, result*10 + N.charAt(i) - '0');
        }
    }

    public void checkPrime(int n){
        int target = n;

        while(target < maxN){
            isPrime[target] = false;
            target += n;
        }
    }
}


