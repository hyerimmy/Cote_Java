package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.01
 * @notes - 현대 기출<br>
 */

public class s5_3699_주차빌딩 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int T = 0; T < testCase; T++) {
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] B = new int[H][L];
            HashMap<Integer, Car> carHashMap = new HashMap<>();
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < L; l++) {
                    B[h][l] = Integer.parseInt(st.nextToken());
                    if (B[h][l] != -1) {
                        carHashMap.put(B[h][l], new Car(h, l));
                    }
                }
            }

            int[] lState = new int[H];
            for (int i : carHashMap.keySet()) {
                Car car = carHashMap.get(i);
                // 층수 이동 시간
                answer += car.h * 2 * 10;
                // 회전 시간
                int rotationCnt = 0;
                if (lState[car.h] > car.l) {
                    rotationCnt = Math.min(L + car.l - lState[car.h], lState[car.h] - car.l);
                }
                if (lState[car.h] < car.l) {
                    rotationCnt = Math.min(L + lState[car.h] - car.l, car.l - lState[car.h]);
                }
                if(lState[car.h] == car.l){
                    continue;
                }
                answer += rotationCnt * 5;
                lState[car.h] = car.l;
            }

            System.out.println(answer);
        }
    }
}

class Car {
    int h;
    int l;

    public Car(int h, int l) {
        this.h = h;
        this.l = l;
    }
}
