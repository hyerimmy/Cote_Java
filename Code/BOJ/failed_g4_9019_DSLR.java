package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.21.
 * @notes - 에센셜3 <br>
 * - 방문한 숫자인 경우 제외하기
 */

public class failed_g4_9019_DSLR {
    public static boolean[] visited = new boolean[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(getMinFuncList(A, B));
        }
    }

    public static String getMinFuncList(int A, int B) {
        Queue<FuncResult> Q = new LinkedList<>();
        Q.add(new FuncResult(A, ""));

        String answer = "";
        while (!Q.isEmpty()) {
            FuncResult fr = Q.poll();

            int funcResultN = funcD(fr.n);
            if (funcResultN == B) {
                answer =  fr.funcList + "D";
                break;
            }
            else {
                if(!visited[funcResultN]) {
                    visited[funcResultN] = true;
                    Q.add(new FuncResult(funcResultN, fr.funcList + "D"));
                }
            }

            funcResultN = funcS(fr.n);
            if (funcResultN == B) {
                answer =  fr.funcList + "S";
                break;
            }
            else {
                if(!visited[funcResultN]) {
                    visited[funcResultN] = true;
                    Q.add(new FuncResult(funcResultN, fr.funcList + "S"));
                }
            }

            if(fr.funcList.length()==0 || fr.funcList.charAt(fr.funcList.length()-1) != 'R') {
                funcResultN = funcL(fr.n);
                if (funcResultN == B) {
                    answer = fr.funcList + "L";
                    break;
                } else {
                    if(!visited[funcResultN]) {
                        visited[funcResultN] = true;
                        Q.add(new FuncResult(funcResultN, fr.funcList + "L"));
                    }
                }
            }

            if(fr.funcList.length()==0 || fr.funcList.charAt(fr.funcList.length()-1) != 'L') {
                funcResultN = funcR(fr.n);
                if (funcResultN == B) {
                    answer = fr.funcList + "R";
                    break;
                } else {
                    if(!visited[funcResultN]) {
                        visited[funcResultN] = true;
                        Q.add(new FuncResult(funcResultN, fr.funcList + "R"));
                    }
                }
            }

        }
        return answer;
    }

    public static int funcD(int n) {
        return (2 * n) % 10000;
    }

    public static int funcS(int n) {
        if (n == 0)
            return 9999;
        return n - 1;
    }

    public static int funcL(int n) {
        String nString = String.valueOf(n);
        String resultNString = nString.substring(1) + nString.charAt(0);
        return Integer.parseInt(resultNString);
    }

    public static int funcR(int n) {
        String nString = String.valueOf(n);
        int maxIdx = nString.length() - 1;
        String resultNString = nString.charAt(maxIdx) + nString.substring(0, maxIdx);
        return Integer.parseInt(resultNString);
    }
}

class FuncResult {
    public int n;
    public String funcList;

    public FuncResult(int n, String funcList) {
        this.n = n;
        this.funcList = funcList;
    }
}