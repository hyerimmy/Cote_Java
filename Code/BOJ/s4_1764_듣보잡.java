package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.21.
 * @notes - 에센셜3 <br>
 * - 정직하게 리스트로 구현했더니 시간 초과.. 어떻게 해야 할꽈~ <br>
 * - 이유가 contains 함수를 매번 쓰면 탐색을 해야하니까 시간복잡도 O(n^2)일 것 같음 <br>
 * - 그냥 해시에 넣은다음에 한 번 도는게 낫겠다.<br>
 * - **HashSet의 contains()는 O(1), ArrayList의 contains()는 O(n)이다.
 * HashSet은 map을 기반으로 구현되고, ArrayList는 indexOf()를 사용해서 contain여부를 결정한다고 한다.
 * 처음에 ArrayList를 사용해서 시간초과가 났는데, 효율성이 필요한 문제라면 HashSet을 사용해야겠다.
 */

public class s4_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수


        HashSet<String> H = new HashSet<>();
        for (int n = 0; n < N; n++) {
            H.add(br.readLine());
        }

        List<String> nameList = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            String name = br.readLine();
            if(H.contains(name))
                nameList.add(name);
        }

        Collections.sort(nameList);
        System.out.println(nameList.size());
        System.out.println(String.join("\n", nameList));
    }

}