package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.25
 * @notes - 에센셜3++<br>
 * - 시간복잡도 까다로웠던 문제, Queue.remove() 사용하면 시간복잡도 터짐.
 */

public class g4_7662_이중우선순위큐 {
    public static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    public static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    public static HashMap<Integer,Integer> numberCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            minQ.clear();
            maxQ.clear();
            numberCount.clear();

            int K = Integer.parseInt(br.readLine()); // 연산 수
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                // I 연산일 경우
                if (type.equals("I")) {
                    minQ.add(number);
                    maxQ.add(number);
                    numberCount.put(number, numberCount.getOrDefault(number, 0)+1);
                    continue;
                }

                // D 연산일 경우
                if (number == -1) {
                    pollMinNumber();
                } else {
                    pollMaxNumber();
                }
            }

            pollBeforeMinNumber();
            pollBeforeMaxNumber();

            if(minQ.isEmpty())
                sb.append("EMPTY").append("\n");
            else
                sb.append(maxQ.poll()).append(" ").append(minQ.poll()).append("\n");
        }
        System.out.println(sb);
    }

    public static void pollBeforeMinNumber(){
        while(!minQ.isEmpty() && numberCount.get(minQ.peek()) == 0){
            minQ.poll();
        }
    }

    public static void pollMinNumber(){
        pollBeforeMinNumber();
        if(!minQ.isEmpty()) {
            numberCount.put(minQ.peek(), numberCount.get(minQ.peek())-1);
            minQ.poll();
        }
    }
    public static void pollBeforeMaxNumber(){
        while(!maxQ.isEmpty() && numberCount.get(maxQ.peek()) == 0){
            maxQ.poll();
        }
    }

    public static void pollMaxNumber(){
        pollBeforeMaxNumber();
        if(!maxQ.isEmpty()) {
            numberCount.put(maxQ.peek(), numberCount.get(maxQ.peek())-1);
            maxQ.poll();
        }
    }

}

