package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title s12891_DNA비밀번호
 * @link https://www.acmicpc.net/problem/12891
 * @date 2023.08.11
 * @notes
- 슬라이딩 윈도우 알고리즘 활용<br>
 */

public class s2_12891_DNA비밀번호 {

    static int[] current_cnt = new int[4];
    static int[] min_cnt = new int[4];
    static int correct_cnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] A = (st.nextToken()).toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++){
            min_cnt[i] = Integer.parseInt(st.nextToken());
            if (min_cnt[i] == 0){
                correct_cnt++;
            }
        }

        // 첫 번쨰 세트
        for(int i=0;i<M;i++){
            Add(A[i]);
        }
        if (correct_cnt == 4){
            result++;
        }

        // 두 번째 세트 ~ 마지막
        int start_idx = 0;
        int end_idx = M-1;
        for(int i=0;i<N-M;i++){
            Remove(A[start_idx++]);
            Add(A[++end_idx]);
            if (correct_cnt == 4){
                result++;
            }
        }
        System.out.println(result);
    }

    public static void Add(char c){
        switch (c){
            case 'A':
                current_cnt[0]++;
                if (current_cnt[0] == min_cnt[0]){
                    correct_cnt++;
                }
                break;
            case 'C':
                current_cnt[1]++;
                if (current_cnt[1] == min_cnt[1]){
                    correct_cnt++;
                }
                break;
            case 'G':
                current_cnt[2]++;
                if (current_cnt[2] == min_cnt[2]){
                    correct_cnt++;
                }
                break;
            case 'T':
                current_cnt[3]++;
                if (current_cnt[3] == min_cnt[3]){
                    correct_cnt++;
                }
                break;
        }
    }

    public static void Remove(char c){
        switch (c){
            case 'A':
                current_cnt[0]--;
                if (current_cnt[0] == min_cnt[0]-1){
                    correct_cnt--;
                }
                break;
            case 'C':
                current_cnt[1]--;
                if (current_cnt[1] == min_cnt[1]-1){
                    correct_cnt--;
                }
                break;
            case 'G':
                current_cnt[2]--;
                if (current_cnt[2] == min_cnt[2]-1){
                    correct_cnt--;
                }
                break;
            case 'T':
                current_cnt[3]--;
                if (current_cnt[3] == min_cnt[3]-1){
                    correct_cnt--;
                }
                break;
        }
    }
}

