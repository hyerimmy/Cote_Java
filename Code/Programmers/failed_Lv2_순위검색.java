package Programmers;

import java.util.Arrays;

/**
 * @title Lv2_순위검색
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * @date 2023.08.20
 * @notes - (1차코드) 시간초과 : 효율성 테스트 0점 <br>
 */

class failed_Lv2_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answers = new int[query.length];
        Arrays.sort(info);

        for (int k = 0; k < query.length; k++) {
            int answer = 0;
            int equalCount = 0;
            String[] queryData = query[k].split(" and ");
            System.out.println(Arrays.toString(queryData));

            for (String i : info) {
                String[] infoData = i.split(" ");
                if (equalCount == 0 && (queryData[0].equals(infoData[0]) || queryData[0].equals("-"))) {
                    equalCount++;
                }
                if (equalCount == 1 && (queryData[1].equals(infoData[1]) || queryData[1].equals("-"))) {
                    equalCount++;
                }
                if (equalCount == 2 && (queryData[2].equals(infoData[2]) || queryData[2].equals("-"))) {
                    equalCount++;
                }
                if (equalCount == 3 && (queryData[3].equals(infoData[3]) || queryData[3].equals("-"))) {
                    equalCount++;
                }
                if (equalCount == 4 && (Integer.parseInt(queryData[4]) > Integer.parseInt(infoData[4]))) {
                    answer++;
                }
            }
            answers[k] = answer;
        }

        return answers;
    }
}
