package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Lv3_단어변환
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * @date 2023.09.04
 * @notes
 * - BFS활용 <br>
 */

class Lv3_단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"cog", "log", "lot", "dog", "dot", "hot"};
        System.out.println(solution(begin, target, words));
    }

    static boolean[] visited;
    static String[] W;
    static String T;
    static int answer = 0;
    static Queue<int[]> queue = new LinkedList<>();

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        W = words;
        T = target;
        for (int i = 0; i < W.length; i++) { // 후보 단어 하나씩 검사
            if(!visited[i]){
                int diffCnt = 0;
                for (int t = 0; t < W[0].length(); t++) {
                    if (begin.charAt(t) != W[i].charAt(t)) diffCnt++;
                }
                if (diffCnt == 1) {
                    queue.add(new int[] {i,1});
                    visited[i] = true;
                }
                else if (diffCnt == 0) {
                    visited[i] = true;
                }
            }
        }
        BFS();
        return answer;
    }
    private static void BFS(){
        while(!queue.isEmpty()){
            int[] data = queue.poll();
            String newBegin = W[data[0]];
            int count = data[1];
            if (newBegin.equals(T)){
                answer = count;
                break;
            }
            for (int i = 0; i < W.length; i++) { // 후보 단어 하나씩 검사
                if(!visited[i]){
                    int diffCnt = 0;
                    for (int t = 0; t < W[0].length(); t++) {
                        if (newBegin.charAt(t) != W[i].charAt(t)) diffCnt++;
                    }
                    if (diffCnt == 1) {
                        queue.add(new int[] {i,count+1});
                        visited[i] = true;
                    }
                }
            }
        }
    }


}

