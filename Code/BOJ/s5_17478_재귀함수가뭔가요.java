package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.23.
 * @notes - 재귀함수 <br>
 */

public class s5_17478_재귀함수가뭔가요 {
    public static int N;
    public static StringBuilder sb = new StringBuilder();
    public static String[] texts = new String[]{
            "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.",
            "\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"",
            "라고 답변하였지."
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //재귀 횟수

        sb.append(texts[0]).append("\n");
        printText(0);
        System.out.println(sb);
    }

    private static void printText(int depth) {
        StringBuilder prev = new StringBuilder();
        prev.append("____".repeat(Math.max(0, depth)));
        sb.append(prev).append(texts[1]).append("\n");
        if (depth == N) {
            sb.append(prev).append(texts[5]).append("\n");
        } else {
            sb.append(prev).append(texts[2]).append("\n");
            sb.append(prev).append(texts[3]).append("\n");
            sb.append(prev).append(texts[4]).append("\n");
            printText(depth + 1);
        }
        sb.append(prev).append(texts[6]).append("\n");
    }
}

