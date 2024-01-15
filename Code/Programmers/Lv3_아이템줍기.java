package Programmers;

import java.util.*;


/**
 * @title Lv3 아이템 줍기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87694
 * @date 2023.09.12
 * @notes
 * - BFS활용 <br>
 * - 예제 1번에 (3,5) -> (3,6)으로 가는 문제 때문에 점수 깎임. (길이 아닌 것 구분 못함) <br>
 * - 0.5 단위 좌표로 만들면 위의 예외를 해결할 수 있음. (좌표를 2배로 처리) <br>
 */

class Lv3_아이템줍기 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
//        System.out.println(Arrays.toString(solution(tickets)));

        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        System.out.println(solution(rectangle, 1, 3, 7, 8));
    }

    public static int[][] map = new int[101][101];
    public static int answer = 0;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 사각형 좌표 설정하기
        for(int[] R : rectangle){
            setRectangle(R[0] * 2, R[1] * 2, R[2] * 2, R[3] * 2);
        }

        // BFS 탐색 실행
        searchRoot(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        // 테스트용 출력
        // for(int y = 20; y >= 0; y--){
        //     System.out.println(Arrays.toString(map[y]));
        // }

        return answer / 4;
    }

    private static void setRectangle(int minX, int minY, int maxX, int maxY){
        // 1 : 내부, 2 : 테두리
        for(int y = minY; y <= maxY; y++){
            for(int x = minX; x <= maxX; x++){
                // 다른 사각형의 내부라면 테두리 처리하지 않는다.
                if(map[y][x] == 1)
                    continue;

                if(y == minY || y == maxY || x == minX || x == maxX){
                    // 테두리 부분이라면
                    map[y][x] = 2;
                } else {
                    // 내부라면
                    map[y][x] = 1;
                }
            }
        }
    }

    private static void searchRoot(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{characterY, characterX});

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        while(!Q.isEmpty()){
            int[] point = Q.poll();

            if(point[0] == itemY && point[1] == itemX)
                break;

            for(int t = 0; t < 4; t++){
                if(point[0] + dy[t] >= 101 || point[1] + dx[t] >= 101)
                    continue;

                if(map[point[0] + dy[t]][point[1] + dx[t]] == 2){
                    Q.add(new int[]{point[0] + dy[t], point[1] + dx[t]});
                    map[point[0] + dy[t]][point[1] + dx[t]] = 1;
                    answer++;
                }
            }
        }
    }

}

