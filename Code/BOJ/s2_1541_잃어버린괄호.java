package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.20.
 * @notes - 에센셜3<br>
 */

public class s2_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String inputNumber = "";
        int tempNumber = 0;
        List<Integer> calculatedNumberL = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '+'){
                tempNumber += Integer.parseInt(inputNumber);
                inputNumber = "";
            }
            else if(input.charAt(i) == '-'){
                tempNumber += Integer.parseInt(inputNumber);
                calculatedNumberL.add(tempNumber);
                tempNumber = 0;
                inputNumber = "";
            }
            else {
                inputNumber += input.charAt(i);
            }
        }
        tempNumber += Integer.parseInt(inputNumber);
        calculatedNumberL.add(tempNumber);

        int result = calculatedNumberL.get(0);
        for (int i = 1; i < calculatedNumberL.size(); i++) {
            result -= calculatedNumberL.get(i);
        }
        System.out.println(result);
    }
}

