
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes - 에센셜2<br>
 * - 런타임 에러 발생 : Comparator 정의 실수 -> 등록순은 0으로 반환해야 한다!!<br>
 */

public class s5_10814_나이순정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회원 수

        StringBuilder sb = new StringBuilder();

        String[] membersA = new String[N];
        for (int n = 0; n < N; n++) {
            membersA[n] = br.readLine();
        }

        Arrays.sort(membersA, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Age = o1.split(" ")[0];
                String o2Age = o2.split(" ")[0];
                // 나이순
                if(Integer.parseInt(o1Age) < Integer.parseInt(o2Age))
                    return -1;
                if(Integer.parseInt(o1Age) > Integer.parseInt(o2Age))
                    return 1;
                // 동륵순
                return 0;
            }
        });

        for(String member : membersA){
            sb.append(member).append("\n");
        }
        System.out.println(sb);
    }
}

