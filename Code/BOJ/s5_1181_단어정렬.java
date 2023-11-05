package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06
 * @notes - 에센셜2<br>
 */

public class s5_1181_단어정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> wordList = new ArrayList<>();
        for(int n=0; n<N; n++){
            String inputWord = br.readLine();
            if(!wordList.contains(inputWord))
                wordList.add(inputWord);
        }

        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length())
                    return -1;
                if(o1.length() > o2.length())
                    return 1;
                return o1.compareTo(o2);
            }
        });
        for(String word : wordList)
            System.out.println(word);
    }
}

