package BOJ;

import java.io.*;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.02.
 * @notes - 에센셜3++<br>
 */

public class g5_1107_리모컨 {
    public static boolean[] numberBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Nstring = br.readLine();

        int M = Integer.parseInt(br.readLine());
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                String input = st.nextToken();
                numberBroken[Integer.parseInt(input)] = true;
            }
        }


        // 1. 숫자키 사용하지 않는 경우
        int N = Integer.parseInt(Nstring);
        int answer = getPlusMinusButtonCnt(100, N);
//        System.out.println(answer);

        // 2. 숫자키 사용하는 경우
        List<Integer> nearestNumbers = new ArrayList<>();
        if(M != 10){
            nearestNumbers = getNearestNumbers(N);
        }
//        System.out.println(nearestNumbers);

        for (int nearestN : nearestNumbers) {
            int numberCnt = Integer.toString(nearestN).length();
            int plusMinusCnt = getPlusMinusButtonCnt(nearestN, N);
            answer = Math.min(answer, numberCnt + plusMinusCnt);
//            System.out.println("jumpN : " + nearestN);
//            System.out.println("- numberCnt : " + numberCnt);
//            System.out.println("- plusMinusCnt : " + plusMinusCnt);
        }
        System.out.println(answer);

    }

    public static int getPlusMinusButtonCnt(int prev, int target) {
        return Math.min(Math.abs(prev - target), Math.abs(target - prev));
    }

    public static List<Integer> getNearestNumbers(int N) {
        List<Integer> nearestNumbers = new ArrayList<>();
        int k = 0;
        while(nearestNumbers.isEmpty()){
            if(N-k >= 0 && isAvailableNumber(N-k)) {
                nearestNumbers.add(N-k);
            }
            if(isAvailableNumber(N+k)) {
                nearestNumbers.add(N+k);
            }
            k++;
        }
        return nearestNumbers;
    }
    public static boolean isAvailableNumber(int number){
        if(number == 0 && numberBroken[0]){
            return false;
        }
        while (number != 0){
            if(numberBroken[number % 10]) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}