package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @title s11286_절대값힙
 * @link https://www.acmicpc.net/problem/11286
 * @date 2023.08.12
 * @notes
- 스택/큐 활용<br>
 */

public class s1_11286_절대값힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) < Math.abs(o2)) return -1;
                else if (Math.abs(o1) > Math.abs(o2)) return 1;
                else return o1.compareTo(o2);
            }
        });

        int inputN;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            inputN = Integer.parseInt(st.nextToken());
            if (inputN == 0){
                if (queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
            else {
                queue.add(inputN);
            }
        }
    }
}

