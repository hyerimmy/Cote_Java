package Programmers;

/**
 * @title Lv2 모음사전
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * @date 2024.01.29
 * @notes - 프로그래머스 고득점 kit <br>
 */

class Lv2_모음사전 {
    public static void main(String[] args) {
    }

    public static char[] alphabet = new char[]{'A', 'E', 'I', 'O', 'U'};
    public static int answer = 0;
    public static boolean findTarget = false;
    public static StringBuilder sb = new StringBuilder();
    public static String TARGET;

    public int solution(String word) {
        TARGET = word;

        createWord(0);

        return answer - 1;
    }

    private void createWord(int depth) {
        if (depth > 5)
            return;

        answer++;
        // System.out.println(answer+" : "+sb);

        if (TARGET.equals(sb.toString())) {
            findTarget = true;
            return;
        }

        for (char a : alphabet) {
            sb.append(a);
            createWord(depth + 1);
            sb.deleteCharAt(sb.length() - 1);

            if (findTarget)
                return;
        }
    }
}


