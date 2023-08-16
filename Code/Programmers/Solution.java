package Programmers;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[] info = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int k=0; k<query.length; k++) {
            int count = 0;
            String[] queryData = query[k].split(" ");
            for (String i : info) {
                String[] infoData = i.split(" ");
                if (!queryData[0].equals(infoData[0]) && !queryData[0].equals("-")) break;
                if (!queryData[2].equals(infoData[2]) && !queryData[2].equals("-")) break;
                if (!queryData[4].equals(infoData[4]) && !queryData[4].equals("-")) break;
                if (!queryData[6].equals(infoData[6]) && !queryData[6].equals("-")) break;
                if (Integer.parseInt(queryData[7]) > Integer.parseInt(infoData[7])) break;
                count ++;
                }
            answer[k] = count;
            }
        return answer;
        }

    }
