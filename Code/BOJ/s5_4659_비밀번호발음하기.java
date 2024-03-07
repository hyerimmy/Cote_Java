package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.07
 * @notes - 문자열 다순 구현<br>
 */

public class s5_4659_비밀번호발음하기 {
    public static HashSet<Character> moums = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        moums.add('a');
        moums.add('e');
        moums.add('i');
        moums.add('o');
        moums.add('u');

        StringBuilder answer = new StringBuilder();

        String word = br.readLine();
        while (!word.equals("end")) {
            boolean acceptable = true;

            boolean existMo = false; // 1. 모음(a,e,i,o,u) 하나를 반드시 포함
            int moCount = 0, jaCount = 0; // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.

            for (int i = 0; i < word.length(); i++) {

                if (moums.contains(word.charAt(i))) {
                    moCount++;
                    jaCount = 0;
                    existMo = true;
                } else {
                    moCount = 0;
                    jaCount++;
                }

                if (jaCount >= 3 || moCount >= 3) {
                    acceptable = false;
                    break;
                }

                // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
                if (i > 0 && word.charAt(i) == word.charAt(i - 1) && word.charAt(i) != 'e' && word.charAt(i) != 'o') {
                    acceptable = false;
                    break;
                }
            }

            if (!existMo || !acceptable) {
                answer.append("<").append(word).append("> is not acceptable.").append("\n");
            } else {
                answer.append("<").append(word).append("> is acceptable.").append("\n");
            }

            word = br.readLine();
        }

        System.out.println(answer);
    }
}