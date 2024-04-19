package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/25757
 * @date 2024.04.19
 * @notes - 1트, 20분 <br>
 */

/*
Y = 2, F = 3, O = 4

12 F(3)
lms0806 **
powergee **
skeep194 **
lms0806
tony9402 **
lms0806
wider93 **
lms0806
mageek2guanaah **
lms0806
jthis **
lms0806

HashSet<String> history 이름 넣기
HashMap<Character, Integer> targetCount
반복문돌며 계산, memberCount == target 완료하면 playCount++
 */

public class s5_25757_임스와함께하는미니게임 {
    public static HashMap<Character, Integer> targetCountMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        targetCountMap.put('Y', 2);
        targetCountMap.put('F', 3);
        targetCountMap.put('O', 4);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char gameType = st.nextToken().charAt(0);

        int targetCount = targetCountMap.get(gameType) - 1;
        HashSet<String> playedMembers = new HashSet<>();

        for (int n = 0; n < N; n++) {
            String member = br.readLine();
            playedMembers.add(member);
        }

        int playCount = playedMembers.size() / targetCount;
        System.out.println(playCount);


    }
}

