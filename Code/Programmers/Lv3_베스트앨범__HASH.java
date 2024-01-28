package Programmers;

import java.util.*;

/**
 * @title Lv3 베스트앨범
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * @date 2023.09.05
 * @notes - Hash 활용 <br>
 */

class Lv3_베스트앨범__HASH {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        // genres sorting
        HashMap<String, Integer> genreCntMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> genreSongMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int playSum = genreCntMap.getOrDefault(genres[i], 0);
            genreCntMap.put(genres[i], playSum + plays[i]);

            ArrayList<Integer> songList = genreSongMap.getOrDefault(genres[i], new ArrayList<>());
            songList.add(i);
            genreSongMap.put(genres[i], songList);
        }
        ArrayList<String> genresArray = new ArrayList<String>(genreCntMap.keySet());
        genresArray.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genreCntMap.get(o2).compareTo(genreCntMap.get(o1));
            }
        });

        // songs sorting
        ArrayList<Integer> answer = new ArrayList<>();
        for (String genre : genresArray) {
            ArrayList<Integer> songArrays = genreSongMap.get(genre);
            songArrays.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (plays[o1] == plays[o2]) return o1.compareTo(o2);
                    else if (plays[o1] < plays[o2]) return 1;
                    else return -1;
                }
            });
            if (songArrays.size() > 0) answer.add(songArrays.get(0));
            if (songArrays.size() > 1) answer.add(songArrays.get(1));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}


