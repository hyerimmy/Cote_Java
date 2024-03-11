package Programmers;

import java.util.HashMap;

/**
 * @title Lv2 혼자서 하는 틱택토
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/160585
 * @date 2024.03.11
 * @notes - 한번에 풀었다 <br>
 */

class Lv2_혼자서하는틱택토 {

    public static char[][] B = new char[3][3];
    public static HashMap<Character, Integer> counter = new HashMap<>();

    public static void main(String[] args) {
    }

    public int solution(String[] board) {
        counter.put('O', 0);
        counter.put('X', 0);

        // O, X 개수 세기
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                B[row][col] = board[row].charAt(col);
                if (B[row][col] == '.')
                    continue;
                counter.put(B[row][col], counter.get(B[row][col]) + 1);
            }
        }
        // System.out.println("counter "+counter);

        // 우승자
        HashMap<Character, Boolean> isWin = getWinner();
        // System.out.println("isWin "+isWin);

        // 현재 플레이 유저
        char playUser = 'O';
        if (counter.get('O') == counter.get('X')) {
            playUser = 'X';
        }
        // System.out.println("playUser "+playUser);

        // 1. "O"를 표시할 차례인데 "X"를 표시 ...
        int gap = counter.get('O') - counter.get('X');
        // System.out.println("gap "+gap);
        if (gap != 0 && gap != 1) {
            // System.out.println("O를 표시할 차례인데 X를 표시 ...");
            return 0;
        }

        // 2. 승리해서 게임이 종료되었음에도 그 게임을 진행
        // 아무도 이기지 않았다면 가능
        if (!isWin.get('O') && !isWin.get('X')) {
            // System.out.println("아무도 이기지 않았다면 가능");
            return 1;
        }

        // 둘 다 이겼다면 불가능
        if (isWin.get('O') && isWin.get('X')) {
            // System.out.println("둘 다 이겼다면 불가능");
            return 0;
        }

        // O가 이겼는데 O 순서라면 가능
        if (isWin.get('O') && playUser == 'O') {
            // System.out.println("O가 이겼는데 O 순서라면 가능");
            return 1;
        }

        // X가 이겼는데 X 순서라면 가능
        if (isWin.get('X') && playUser == 'X') {
            // System.out.println("X가 이겼는데 X 순서라면 가능");
            return 1;
        }

        return 0;
    }

    private HashMap<Character, Boolean> getWinner() {
        HashMap<Character, Boolean> isWin = new HashMap<>();
        isWin.put('O', false);
        isWin.put('X', false);

        // 가로, 세로 확인
        for (int n = 0; n < 3; n++) {
            if (B[n][0] != '.' && B[n][0] == B[n][1] && B[n][1] == B[n][2]) {
                isWin.put(B[n][0], true);
            }
            if (B[0][n] != '.' && B[0][n] == B[1][n] && B[1][n] == B[2][n]) {
                isWin.put(B[0][n], true);
            }
        }

        // 대각선 확인
        if (B[0][0] != '.' && B[0][0] == B[1][1] && B[1][1] == B[2][2])
            isWin.put(B[0][0], true);

        if (B[0][2] != '.' && B[0][2] == B[1][1] && B[1][1] == B[2][0])
            isWin.put(B[0][2], true);

        return isWin;
    }

}


