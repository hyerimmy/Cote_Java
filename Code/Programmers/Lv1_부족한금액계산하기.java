package Programmers;

/**
 * @title Lv0 홀짝구분하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181944
 * @date 2024.03.14
 * @notes - Java 문법 공부용 <br>
 */

class Lv1_부족한금액계산하기 {

    public static void main(String[] args) {
    }

    public long solution(int price, int money, int count) {
        long priceNeed = 0;

        for (int c = 1; c <= count; c++) {
            priceNeed += c * price;
        }

        return priceNeed > money ? priceNeed - money : 0;
    }

}


