package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 * - 에센셜2 <br>
 */

public class s3_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수의 개수

        double sum = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();

        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            int inputN = Integer.parseInt(br.readLine());
            numList.add(inputN);
            sum += inputN;

            int count = counter.getOrDefault(inputN, 0);
            counter.put(inputN, count+1);
        }

        Collections.sort(numList);

        // 1. 산술평균
        String ans1 = String.format("%.0f",sum/numList.size());
        if(ans1.equals("-0"))
            System.out.println(0);
        else
            System.out.println(ans1);

        // 2. 중앙값
        System.out.println(numList.get(numList.size() / 2));

        // 3. 최빈값 (두 번쨰로 작은 값)
        int maxCount = 0;
        List<Integer> modeList = new ArrayList<>();
        for(int num : counter.keySet()){
            if(maxCount < counter.get(num)){
                modeList.clear();
                maxCount = counter.get(num);
            }
            if(maxCount <= counter.get(num)){
                modeList.add(num);
            }
        }
        if(modeList.size() >= 2){
            Collections.sort(modeList);
            System.out.println(modeList.get(1));
        }
        else{
            System.out.println(modeList.get(0));
        }

        // 4. 범위
        System.out.println(numList.get(numList.size()-1) - numList.get(0));

    }
}