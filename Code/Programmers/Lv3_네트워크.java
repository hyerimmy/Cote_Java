package Programmers;

/**
 * @title Lv3_네트워크
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * @date 2023.09.04
 * @notes - DFS활용 <br>
 */

class Lv3_네트워크 {
    public static void main(String[] args) {
//        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        System.out.println(solution(n, computers));

        int n = 5;
        int[][] computers = {{1,1,0,1,0}, {1,1,1,1,0}, {0,1,1,0,0}, {1,1,0,1,0}, {0,0,0,0,1}};
        System.out.println(solution(n, computers));
    }

    static int answer = 0;
    static int N;
    static boolean[] checked;

    public static int solution(int n, int[][] computers) {
        N = n;
        checked = new boolean[n];

        for(int i=0; i<N; i++){
            if(!checked[i]){
                DFS(computers, i);
                answer ++;
            }
        }

        return answer;
    }

    private static void DFS(int[][] computers, int target) {
        checked[target] = true;
        for(int j=0; j<N; j++){
            if (target!=j && computers[target][j]==1){
                if (!checked[j]){
                    DFS(computers, j);
                }

            }
        }
    }
}

