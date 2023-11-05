package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @title s1920_원하는정수찾기
 * @link https://www.acmicpc.net/problem/1920
 * @date 2023.08.11
 * @notes
- 이진탐색 활용 (정렬이 되어 있는 상태여야 함.) <br>
- 자바의 기본 정렬 함수는 nlogn 시간복잡도를 가짐. -> 2nlogn -> nlogn <br>
 */

public class s4_1920_원하는정수찾기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int targetN;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            targetN = Integer.parseInt(st.nextToken());
            boolean find = false;
            int start = 0;
            int end = A.length-1;
            while(start<=end){
                int index = (start+end)/2;

                if(A[index]<targetN){
                    start = index+1;
                }
                else if(A[index]>targetN){
                    end = index-1;
                }
                else{
                    find = true;
                    break;
                }
            }
            if (find)System.out.println(1);
            else System.out.println(0);

        }

    }


}

