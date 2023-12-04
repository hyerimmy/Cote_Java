package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.05
 * @notes - 에센셜4 <br>
 * - 문제 풀기 전에 메모장에 충분한 검증하는 연습! <br>
 * - 나머지 연산 주의!! 순서대로 계산했을 때 범위 벗어나면 이미 -값으로 계산되니까 사이사이 싹 나머지연산 하기 -> (temp * temp  % C) * A % C;
 * - 왜 A,B,C를 long으로 선언해야 하는가? https://st-lab.tistory.com/237
 */

public class s1_1629_곱셈 {
    public static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }

    public static long pow(long A, long upN){
        if(upN == 1)
            return A % C;

        long temp = pow(A, upN / 2);

        if(upN % 2 != 0)
            return (temp * temp  % C) * A % C;
        return temp * temp % C;
    }
}