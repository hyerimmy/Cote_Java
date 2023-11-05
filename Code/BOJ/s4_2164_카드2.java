package BOJ;

import java.io.IOException;
import java.util.*;

/**
 * @title s2164_카드2
 * @link https://www.acmicpc.net/problem/2164
 * @date 2023.08.12
 * @notes
- 큐 활용<br>
- 큐의 개념을 정확히 알고 있다면 풀 수 있는 문제<br>
 */

public class s4_2164_카드2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1;i<N+1;i++){
            queue.add(i);
        }

        for (int i=0; i<N-1;i++){
            queue.poll();
            if (queue.size() > 1){
                int poll_number = queue.poll();
                queue.add(poll_number);
            }
        }
        System.out.println(queue.poll());
    }
}

