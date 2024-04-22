package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/22866
 * @date 2024.04.22
 * @notes - <br>
 */

/**
 * 3 7 1 6 3 5 1 7
 * 좌측에 보이는 것 세기
 * 3[1]                  : 0 (1-1)
 * 7[2]                  : 0
 * 7[2] 1[3]             : 1
 * 7[2] 6[4]             : 1
 * 7[2] 6[4] 3[5]        : 2
 * 7[2] 6[4] 5[6]        : 2
 * 7[2] 6[4] 5[6] 1[7]   : 3
 * 7[8]                  : 0
 * <p>
 * 우측에 보이는 것 세기
 * 7[8]                     : 0
 * 7[8] 1[7]                : 1
 * 7[8] 5[6]                : 1
 * 7[8] 5[6] 3[5]           : 2
 * 7[8] 6[4]                : 1
 * 7[8] 6[4] 1[3]           : 2
 * 7[2]                     : 0
 * 7[2] 3[1]                : 1
 */

public class g3_22866_탑보기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] heights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] resultCount = new int[N + 1];
        int[] nearIdx = new int[N + 1];
        Arrays.fill(nearIdx, -100001);

        // 왼쪽에서 보이는 것 개수 세기
        Stack<Integer> leftCountStack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!leftCountStack.isEmpty()
                    && heights[leftCountStack.peek()] <= heights[i]) {
                leftCountStack.pop();
            }

            resultCount[i] += leftCountStack.size();

            if (!leftCountStack.isEmpty())
                nearIdx[i] = leftCountStack.peek();

            leftCountStack.push(i);
        }

        // 오른쪽에서 보이는 것 개수 세기
        Stack<Integer> rightCountStack = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!rightCountStack.isEmpty()
                    && heights[rightCountStack.peek()] <= heights[i]) {
                rightCountStack.pop();
            }
            resultCount[i] += rightCountStack.size();

            if (!rightCountStack.isEmpty() && rightCountStack.peek() - i < i - nearIdx[i]) {
                nearIdx[i] = rightCountStack.peek();
            }

            rightCountStack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(resultCount[i]);
            if (resultCount[i] > 0)
                sb.append(" ").append(nearIdx[i]);
            sb.append("\n");
        }
        System.out.println(sb);


    }
}

