package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_전광판 {
    public static int[][] numberLight = new int[10][7];

    public static void main(String[] args) throws IOException {
        numberLight[0] = new int[]{1,1,1,0,1,1,1};
        numberLight[1] = new int[]{0,0,1,0,0,1,0};
        numberLight[2] = new int[]{1,0,1,1,1,0,1};
        numberLight[3] = new int[]{1,0,1,1,0,1,1};
        numberLight[4] = new int[]{0,1,1,1,0,1,0};
        numberLight[5] = new int[]{1,1,0,1,0,1,1};
        numberLight[6] = new int[]{1,1,0,1,1,1,1};
        numberLight[7] = new int[]{1,1,1,0,0,1,0};
        numberLight[8] = new int[]{1,1,1,1,1,1,1};
        numberLight[9] = new int[]{1,1,1,1,0,1,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(A.length()>=B.length())
                System.out.println(getCountSum(A, B));
            if(A.length()<B.length())
                System.out.println(getCountSum(B, A));
        }
    }

    public static int getCountSum(String A, String B){
        int countSum = 0;

        for(int i=0; i<A.length(); i++){
            char a = A.charAt(A.length()-i-1);
            if(B.length()<=i){
                countSum += getCount(numberLight[a-'0']);
            } else {
                char b = B.charAt(B.length()-i-1);
                if(a != b)
                    countSum += getDifferentCount(numberLight[a-'0'], numberLight[b-'0']);
            }
        }
        return countSum;
    }

    public static int getDifferentCount(int[] nA1, int[] nA2){
        int count = 0;
        for(int i=0; i<7; i++){
            if(nA1[i]!=nA2[i]) count++;
        }
        return count;
    }

    public static int getCount(int[] nA1){
        int count = 0;
        for(int i=0; i<7; i++){
            if(nA1[i] == 1) count++;
        }
        return count;
    }
}
