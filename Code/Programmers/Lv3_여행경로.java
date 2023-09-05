package Programmers;

import java.util.*;


/**
 * @title Lv3_여행경로
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * @date 2023.09.04
 * @notes
 * - BFS활용 <br>
 * - 자바 변수 형식 선언, 리스트 활용 등에 애먹은 문제..^.ㅠ <br>
 */

class Lv3_여행경로 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
//        System.out.println(Arrays.toString(solution(tickets)));

        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    static String[][] T;
    static ArrayList<String> answer = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        T = tickets;
        boolean[] used = new boolean[tickets.length];
        BFS("ICN", "ICN", used);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    public static void BFS(String history, String target, boolean[] used){
        if (history.split(" ").length==T.length+1){
            answer.add(history);
        }
        else{
            for (int i=0; i<T.length; i++){
                if (T[i][0].equals(target) && !used[i]){
                    boolean[] newUsed = used.clone();
                    newUsed[i] = true;
                    BFS(history+" "+T[i][1], T[i][1], newUsed);
                }
            }
        }
    }

}

