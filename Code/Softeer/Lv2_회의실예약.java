package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lv2_회의실예약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회의실 수
        int M = Integer.parseInt(st.nextToken()); // 예약된 회의 수

        HashMap<String, boolean[]> roomState = new HashMap<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            roomState.put(st.nextToken(), new boolean[9]);
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            boolean[] newTimetable = updateTimetable(
                    roomState.get(roomName),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            roomState.put(roomName, newTimetable);
        }

        ArrayList<String> roomNameList = new ArrayList<>(roomState.keySet());
        Collections.sort(roomNameList);
        for(int i=0; i<roomNameList.size(); i++){
            if(i!=0){
                System.out.println("-----");
            }
            String roomName = roomNameList.get(i);
            System.out.println("Room "+roomName+":");
            boolean[] reserved = roomState.get(roomName);
            ArrayList<String> resultL = getRoomStateList(reserved);
            if(resultL.size()==0)
                System.out.println("Not available");
            else{
                System.out.println(resultL.size()+" available:");
                for(String time : resultL)
                    System.out.println(time);
            }

        }
    }

    public static boolean[] updateTimetable(boolean[] timetable, int startT, int endT){
        for(int t=startT-9; t<endT-9;t++)
            timetable[t] = true;
        return timetable;
    }

    public static ArrayList<String> getRoomStateList(boolean[] reserved){
        int startT = 0;
        int endT = 0;
        ArrayList<String> resultL = new ArrayList<>();
        for(int i=0; i<9; i++){
            if(!reserved[i]){
                if(startT==0) startT=i+9;
                endT=i+9;
                if(i!=8) continue;
            }
            if(endT!=0){
                String result = "";
                if(startT<10)
                    result+="0";
                result+=startT;
                result+="-";
                if(endT+1<10)
                    result+="0";
                result+=endT+1;
                resultL.add(result);
                startT=0;
                endT=0;
            }
        }
        return resultL;
    }
}
