package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1021
 * @date 2024.04.08
 * @notes - 1시간 걸림 실화냐</br>
 */

public class s3_1021_회전하는큐 {
    public static int N;
    public static int start = 1;
    public static int length;
    public static boolean[] deleted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 뽑아내려는 수 입력받기
        st = new StringTokenizer(br.readLine());

        // 뽑기 위한 변수 정의
        deleted = new boolean[N + 1];
        int result = 0;
        length = N;

        // 뽑기 프로세스 진행
        for (int m = 0; m < M; m++) {
            int target = Integer.parseInt(st.nextToken());

            int leftCnt = getCount(target, -1);
            int rightCnt = length - leftCnt;
            result += Math.min(leftCnt, rightCnt);

            deleted[target] = true;

            start = getCorrectNumber(target + 1);
            length--;


//            System.out.println("==" + target + "==");
//            System.out.println("leftCnt : " + leftCnt);
//            System.out.println("rightCnt : " + rightCnt);
//            System.out.println("result : " + result);
//            System.out.println("deleted : " + Arrays.toString(deleted));
//            System.out.println("start : " + start);
        }

        // 결과 출력
        System.out.println(result);
    }

    private static int getCount(int target, int direction) {
        int count = 0;
        int number = target;

        while (number != start) {
            number = getCorrectNumber(number + direction);

            if (!deleted[number])
                count++;
        }
        return count;
    }

    private static int getCorrectNumber(int number) {
        if (number < 1)
            number += N;
        else if (number > N)
            number -= N;

        return number;
    }
}

/*
6 5
6 5 3 4 2
 */