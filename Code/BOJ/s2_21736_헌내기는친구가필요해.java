package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_21736_헌내기는친구가필요해 {
    public static char[][] campus;
    public static boolean[][] visited;
    public static int N;
    public static int M;

    public static int[] dM = new int[]{1, -1, 0, 0};
    public static int[] dN = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int iN = 0;
        int iM = 0;

        // 캠퍼스 정보 입력받기
        for (int n = 0; n < N; n++) {
            String rowData = br.readLine();
            for (int m = 0; m < M; m++) {
                campus[n][m] = rowData.charAt(m);
                if (campus[n][m] == 'I') {
                    iN = n;
                    iM = m;
                }
            }
        }

        visited[iN][iM] = true;
        int pCount = BFS(iN, iM);
        System.out.println(pCount==0?"TT":pCount);
    }

    public static int BFS(int iN, int iM) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{iN, iM});

        int pCount = 0;
        while (!Q.isEmpty()) {
            int[] position = Q.poll();

            for(int t=0; t<4; t++){
                int newN = position[0] + dN[t];
                int newM = position[1] + dM[t];

                if(newN >= 0 && newN < N && newM >= 0 && newM < M && !visited[newN][newM]){
                    if (campus[newN][newM] != 'X'){
                        visited[newN][newM] = true;
                        Q.add(new int[]{newN, newM});

                        if(campus[newN][newM] == 'P')
                            pCount++;
                    }
                }
            }
        }

        return pCount;
    }
}
