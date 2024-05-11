package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/12018
 * @date 2024.05.12
 * @notes - <br>
 */

public class s3_12018_YonseiTOTO {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 과목 수
        int M = Integer.parseInt(st.nextToken()); // 보유 마일리지

        List<Integer> minMList = new ArrayList<>(); // 수강 위한 최소 마일리지 리스트

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            List<Integer> mList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int p = 0; p < P; p++) {
                mList.add(Integer.parseInt(st.nextToken()));
            }

            // 수강하기 위한 최소 마일리지 계산
            Collections.sort(mList, Collections.reverseOrder());
            if (mList.size() >= L) {
                minMList.add(mList.get(L - 1));
            } else {
                minMList.add(1);
            }
        }

//        System.out.println(minMList);

        Collections.sort(minMList);
        int count = 0;
        int mSum = 0;
        for (int mil : minMList) {
            mSum += mil;
            if (mSum > M) {
                break;
            }

            count++;
        }
        System.out.println(count);
    }
}

/*
1 100
2 20
1 2
 */