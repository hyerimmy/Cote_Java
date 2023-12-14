package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.14.
 * @notes - 이진트리 예제<br>
 */
public class s1_1991_트리순회__이진트리 {
    public static int N;
    public static int[][] tree = new int[2][27];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 그래프 입력받기
        for (int k = 0; k < N; k++) {
            st = new StringTokenizer(br.readLine());
            char parentNode = st.nextToken().charAt(0);
            char leftChildNode = st.nextToken().charAt(0);
            char rightChildNode = st.nextToken().charAt(0);

            if (leftChildNode != '.') {
                tree[0][(int) parentNode - 64] = (int) leftChildNode - 64;
            }

            if (rightChildNode != '.') {
                tree[1][(int) parentNode - 64] = (int) rightChildNode - 64;
            }
        }

        prevSearch(1); // 전위순회
        sb.append("\n");

        middleSearch(1); // 중위순회
        sb.append("\n");

        afterSearch(1); // 후위순회

        System.out.println(sb);
    }

    public static void prevSearch(int rootNode){
        // 루트
        sb.append((char) (rootNode + 64));

        // 왼쪽
        if(tree[0][rootNode] != 0)
            prevSearch(tree[0][rootNode]);

        // 오른쪽
        if(tree[1][rootNode] != 0)
            prevSearch(tree[1][rootNode]);
    }

    public static void middleSearch(int rootNode){
        // 왼쪽
        if(tree[0][rootNode] != 0)
            middleSearch(tree[0][rootNode]);

        // 루트
        sb.append((char) (rootNode + 64));


        // 오른쪽
        if(tree[1][rootNode] != 0)
            middleSearch(tree[1][rootNode]);
    }

    public static void afterSearch(int rootNode){
        // 왼쪽
        if(tree[0][rootNode] != 0)
            afterSearch(tree[0][rootNode]);

        // 오른쪽
        if(tree[1][rootNode] != 0)
            afterSearch(tree[1][rootNode]);

        // 루트
        sb.append((char) (rootNode + 64));
    }
}
