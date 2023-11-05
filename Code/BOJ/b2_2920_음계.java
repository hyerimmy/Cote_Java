package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 * - 에센셜1++
 */

public class b2_2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isAscending = false;
        boolean isDescending = false;

        int inputN = Integer.parseInt(st.nextToken());
        if(inputN == 1)
            isAscending = true;
        if(inputN == 8)
            isDescending = true;

        for(int i=2; i<=8; i++){
            inputN = Integer.parseInt(st.nextToken());
            if(isAscending && inputN == i)
                continue;
            if(isDescending && inputN == 9-i)
                continue;
            isAscending = false;
            isDescending = false;
            break;
        }

        if(isAscending)
            System.out.println("ascending");
        if(isDescending)
            System.out.println("descending");
        if(!isAscending && !isDescending)
            System.out.println("mixed");
    }
}