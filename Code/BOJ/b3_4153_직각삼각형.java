package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2+ <br>
 */

public class b3_4153_직각삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0 && z == 0){
                break;
            }

            if(x*x == (y*y + z*z) || y*y == (x*x + z*z) || z*z == (y*y + x*x))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}