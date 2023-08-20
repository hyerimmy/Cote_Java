package Programmers;

import java.util.Arrays;

/**
 * @title Lv2_순위검색
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * @date 2023.08.20
 * @notes
 * - (1차코드) 효율성 테스트 0점 -> 40점 <br>
 */

class failed_Lv2_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int k=0; k<query.length; k++) {
            int count = 0;
            String[] queryData = query[k].split(" ");
            for (String i : info) {
                String[] infoData = i.split(" ");
                if (!queryData[0].equals(infoData[0]) && !queryData[0].equals("-")) continue;
                if (!queryData[2].equals(infoData[1]) && !queryData[2].equals("-")) continue;
                if (!queryData[4].equals(infoData[2]) && !queryData[4].equals("-")) continue;
                if (!queryData[6].equals(infoData[3]) && !queryData[6].equals("-")) continue;
                if (Integer.parseInt(queryData[7]) > Integer.parseInt(infoData[4])) continue;
                count ++;
                }
            answer[k] = count;
            }
        return answer;
        }

    }
