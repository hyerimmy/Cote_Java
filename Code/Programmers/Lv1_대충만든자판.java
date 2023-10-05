package Programmers;

import java.util.HashMap;
import java.util.Stack;

/**
 * @title Lv1 대충 만든 자판
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * @date 2023.10.05
 * @notes
 * */

class Lv1_대충만든자판 {
    public static void main(String[] args) {
    }

    public static int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> H = new HashMap<>();
        for(int t=0; t<keymap.length; t++){
            for(int j=0; j<keymap[t].length(); j++){
                char key = keymap[t].charAt(j);
                if(H.containsKey(key) && H.get(key)<=j+1) continue;
                else H.put(key, j+1);
            }
        }
        System.out.println(H);

        int[] answer = new int[targets.length];
        for(int k=0; k<targets.length; k++){
            String T = targets[k];
            int count = 0;
            for(int i=0; i<T.length(); i++){
                if(H.containsKey(T.charAt(i))) answer[k]+=H.get(T.charAt(i));
                else {
                    answer[k]=-1;
                    break;
                }
            }
        }

        return answer;
    }

}


