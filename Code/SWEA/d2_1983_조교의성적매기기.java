package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.22
 * @notes
 */

public class d2_1983_조교의성적매기기 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int studentCnt = sc.nextInt();
            int targetIndex = sc.nextInt();
            float targetScore = 0;
            ArrayList<Float> scoreList = new ArrayList<>();
            for(int i=0; i<studentCnt; i++){
                // 총점계산 중간 35 + 기말 45 + 과제 20
                float score = 0;
                score += sc.nextInt()*0.35;
                score += sc.nextInt()*0.45;
                score += sc.nextInt()*0.20;
                if(i+1==targetIndex) targetScore=score;
                else scoreList.add(score);
            }

            int rank = 1;
            for(float score : scoreList){
                if(score>targetScore) rank++;
            }

            double a = Math.ceil((float)rank/(studentCnt/10));
            System.out.print("#"+test_case+" ");
            switch((int)a){
                case 1: System.out.println("A+"); break;
                case 2: System.out.println("A0"); break;
                case 3: System.out.println("A-"); break;
                case 4: System.out.println("B+"); break;
                case 5: System.out.println("B0"); break;
                case 6: System.out.println("B-"); break;
                case 7: System.out.println("C+"); break;
                case 8: System.out.println("C0"); break;
                case 9: System.out.println("C-"); break;
                case 10: System.out.println("D0"); break;
            }

        }
    }
}