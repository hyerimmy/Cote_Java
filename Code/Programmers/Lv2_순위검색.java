package Programmers;

import java.util.*;

/**
 * @title Lv2_순위검색
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * @date 2023.08.20
 * @notes - (1차코드) 시간초과 : 효율성 테스트 0점 <br>
 * - (2차코드) 모든 경우의 수를 map에 저장해서 지원자를 매번 반복구문 돌지 않도록 <br>
 * - (3차코드) 점수 탐색 시 이분탐색을 활용해 효율3,4번의 시간초과를 해결 <br>
 */

class Lv2_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static HashMap<String, List<Integer>> infoMap = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        // 사람 정보 map에 저장
        for (String infoS : info) {
            String[] data = infoS.split(" ");
            updateInfoMap(data, "", 0);
        }
//        System.out.println(infoMap);

        // 점수 정렬
        for (List<Integer> scores : infoMap.values()) {
            Collections.sort(scores);
        }

        // 결과 저장 배열 정의
        int[] answers = new int[query.length];

        // 쿼리에 맞게 결과 저장
        for (int k = 0; k < query.length; k++) {
            String[] queryA = query[k].replace(" and ", " ").split(" ");

            String key = queryA[0] + queryA[1] + queryA[2] + queryA[3];
            int targetScore = Integer.parseInt(queryA[4]);
            List<Integer> scores = infoMap.getOrDefault(key, new ArrayList<>());

            int count = getCorrectScoreCount(scores, targetScore);
            answers[k] = count;
        }

        // 결과 반환
        return answers;
    }

    private static int getCorrectScoreCount(List<Integer> scores, int targetScore) {
        int left = 0;
        int right = scores.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) < targetScore) {
                left = mid + 1;
            } else if (scores.get(mid) >= targetScore) {
                right = mid - 1;
            }
        }

        return scores.size() - left;
    }

    private static void updateInfoMap(String[] data, String result, int idx) {
        if (idx == 4) {
            int value = Integer.parseInt(data[4]);
            List<Integer> scores = infoMap.getOrDefault(result, new ArrayList<>());
            scores.add(value);
            infoMap.put(result, scores);
            return;
        }

        updateInfoMap(data, result + data[idx], idx + 1);
        updateInfoMap(data, result + "-", idx + 1);
    }
}
