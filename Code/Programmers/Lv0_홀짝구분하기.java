package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @title Lv0 홀짝구분하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181944
 * @date 2023.09.15
 * @notes
 * - Java 문법 공부용 <br>
 * */

class Lv0_홀짝구분하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0) System.out.println(n+" is even");
        else System.out.println(n+" is odd");
    }

}


