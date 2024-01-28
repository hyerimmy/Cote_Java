package Programmers;

import java.util.*;

/**
 * @title Lv2 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * @date 2023.10.09 / 2024.01.27
 * @notes - BFS 활용 (x) <br>
 * - 완전탐색 <br>
 */

class Lv2_소수찾기 {
    public static void main(String[] args) {
    }

    public static int maxN = 10_000_000;
    public static boolean[] isPrime = new boolean[maxN];
    public static int answer = 0;
    public static String N;

    // BT
    public static boolean[] visited;
    public static int resultN = 0;

    public int solution(String numbers) {
        N = numbers;

        visited = new boolean[numbers.length()];

        // 소수 여부 미리 저장해두기
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int n = 2; n <= Math.sqrt(maxN); n++) {
            checkPrime(n);
        }

        // System.out.println(Arrays.toString(isPrime));

        // 숫자 만들기
        setNumber();

        return answer;
    }

    public void setNumber() {
        if (isPrime[resultN]) {
            // System.out.println(resultN+" : "+isPrime[resultN]);
            isPrime[resultN] = false; // 소수 중복 카운팅 제거 위함
            answer++;
        }

        for (int i = 0; i < N.length(); i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true;
            resultN = resultN * 10 + (N.charAt(i) - '0');
            setNumber();
            visited[i] = false;
            resultN = resultN / 10;
        }
    }

    public void checkPrime(int n) {
        int target = n * 2;

        while (target < maxN) {
            isPrime[target] = false;
            target += n;
        }
    }
}


