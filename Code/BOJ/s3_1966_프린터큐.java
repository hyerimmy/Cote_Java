package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++ <br>
 */

public class s3_1966_프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            // 문서 개수, 타겟 인덱스
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // 중요도
            Queue<Paper> printQ = new LinkedList<>();
            ArrayList<Integer> valueList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                printQ.add(new Paper(i, value));
                valueList.add(value);
            }
            Collections.sort(valueList, Collections.reverseOrder());

            int answer = 0;
            int valueIdx = 0;
            while (!printQ.isEmpty()) {
                Paper P = printQ.poll();

                // 가장 높은 중요도일 경우
                if(P.value == valueList.get(valueIdx)){
                    answer++; // 출력 인쇄 카운팅
                    valueIdx++; // 중요도 갱신
                    if(P.index == target){
                        break;
                    }
                    continue;
                }

                // 더 중요도 높은 문서가 있다면
                printQ.add(P);


            }
            System.out.println(answer);

        }

    }
}

class Paper {
    int index;
    int value;

    public Paper(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(Paper p){
        if(this.value < p.value)
            return 1;
        if(this.value > p.value)
            return -1;
        return 0;
    }
}
