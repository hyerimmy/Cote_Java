package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 */

public class s2_18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자 개수

        HashMap<Integer, ArrayList<Integer>> numIndexMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            ArrayList<Integer> indexList = numIndexMap.getOrDefault(num, new ArrayList<>());
            indexList.add(i);

            numIndexMap.put(num, indexList);
        }

        List<Integer> numList = new ArrayList<>(numIndexMap.keySet());
        Collections.sort(numList);

        int[] answerA = new int[N];
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            ArrayList<Integer> indexList = numIndexMap.get(num);
            for (int index : indexList)
                answerA[index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int answer : answerA) {
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}

