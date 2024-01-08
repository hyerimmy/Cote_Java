package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.01.08.
 * @notes - 삼성 SW 역량 테스트 기출 문제 <br>
 */

public class s3_14501_퇴사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 상담 입력받기
        List<Meeting> meetings = new ArrayList<>();
        for (int startTime = 1; startTime <= N; startTime++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            if (startTime + time <= N + 1)
                meetings.add(new Meeting(startTime, startTime + time, price));
        }

        // 상담 종료 시간별 오름차순 정렬
        Collections.sort(meetings);

        // 최대 이익 계산
        int[] profits = new int[N + 2];
        for (Meeting meeting : meetings) {
            int middleProfit = profits[meeting.startTime];
            for (int targetTime = meeting.startTime; targetTime >= 1; targetTime--) {
                middleProfit = Math.max(middleProfit, profits[targetTime]);
            }

            int profit = meeting.price + middleProfit;
            profits[meeting.endTime] = Math.max(profit, profits[meeting.endTime]);

//            System.out.println("start:" + meeting.startTime + " / end:" + meeting.endTime + " / price:" + meeting.price);
//            System.out.println(">>> "+profit);
//            System.out.println(Arrays.toString(profits));
        }

        // 결과 출력
        int result = 0;
        for (int time = 1; time <= N+1; time++) {
            result = Math.max(result, profits[time]);
        }
        System.out.println(result);
    }

    private static class Meeting implements Comparable<Meeting> {
        public int startTime;
        public int endTime;
        public int price;

        public Meeting(int startTime, int endTime, int price) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        @Override
        public int compareTo(Meeting m) {
            return this.endTime - m.endTime;
        }
    }
}
