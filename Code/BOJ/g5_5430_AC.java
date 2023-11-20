package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.20.
 * @notes - 에센셜3<br>
 */

public class g5_5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String numbers = br.readLine();
            Deque<Integer> D = new LinkedList<>();
            String tempN = "";
            for (int i = 1; i < numbers.length()-1; i++) {
                if(numbers.charAt(i) == ',') {
                    D.add(Integer.parseInt(tempN));
                    tempN = "";
                }
                else
                    tempN += numbers.charAt(i);
            }
            if(!tempN.isEmpty())
                D.add(Integer.parseInt(tempN));

            boolean reverse = false;
            boolean isError = false;
            for (int i = 0; i < p.length(); i++) {
                char funcType = p.charAt(i);
                if (funcType == 'R') {
                    reverse = !reverse;
                }
                if (funcType == 'D') {
                    if (D.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (!reverse) {
                        D.pollFirst();
                    } else {
                        D.pollLast();
                    }
                }
            }

            if (isError)
                sb.append("error").append("\n");
            else {
                sb.append("[");
                while(!D.isEmpty()){
                    if(!reverse)
                        sb.append(D.pollFirst());
                    else
                        sb.append(D.pollLast());

                    if(!D.isEmpty())
                        sb.append(",");
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
