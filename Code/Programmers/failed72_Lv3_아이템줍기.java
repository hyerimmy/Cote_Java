package Programmers;

import java.util.*;


/**
 * @title Lv3 아이템 줍기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87694
 * @date 2023.09.12
 * @notes
 * - BFS활용 <br>
 * - 예제 1번에 (3,5) -> (3,6)으로 가는 문제 때문에 점수 깎임. (길이 아닌 것 구분 못함) <br>
 */

class failed72_Lv3_아이템줍기 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
//        System.out.println(Arrays.toString(solution(tickets)));

        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        System.out.println(solution(rectangle, 1, 3, 7, 8));
    }

    static int[][] M;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        M = new int[51][51];
        for(int[] R : rectangle){
            Merge(R);
        }
        // for(int i=0; i<M.length;i++) System.out.println(Arrays.toString(M[i]));
        return BFS(characterX, characterY, itemX, itemY);
    }

    public static void Merge(int[] R){
        for(int i=R[0];i<R[2]+1;i++){
            for(int j=R[1];j<R[3]+1;j++){
                if(i == R[0] && M[i][j]!=1) M[i][j] = 2;
                else if(i == R[2] && M[i][j]!=1) M[i][j] = 2;
                else if(j == R[1] && M[i][j]!=1) M[i][j] = 2;
                else if(j == R[3] && M[i][j]!=1) M[i][j] = 2;
                else M[i][j] = 1;
            }
        }
    }

    public static int BFS(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> dataQ = new LinkedList<>();
        Queue<int[][]> mapQ = new LinkedList<>();
        dataQ.offer(new int[]{characterX, characterY, 0});
        M[characterX][characterY] = 3;
        mapQ.offer(M);
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        int answer = 0;
        while(!dataQ.isEmpty()){
            System.out.println(dataQ.size());
            int[] P = dataQ.poll();
            int[][] map = mapQ.poll();
            if(P[0]==itemX && P[1]==itemY){
                answer = P[2];
                break;
            }
            System.out.println("--x"+P[0]+" y"+P[1]+" /cnt"+P[2]);
            for(int t=0; t<4; t++){
                int x = P[0]+dx[t];
                int y = P[1]+dy[t];
                if(x>=1 && x<=50 && y>=1 && y<=50){
                    // System.out.println("x"+x+" y"+y+" /map"+map[x][y]);
                    if(map[x][y]==2){
                        dataQ.offer(new int[]{x,y,P[2]+1});
                        map[x][y]=3;
                        mapQ.offer(map);
                        // System.out.println(dataQ.size());
                    }
                }

            }
        }
        return answer;
    }

}

