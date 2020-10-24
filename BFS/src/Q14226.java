/*
이모티콘

https://www.acmicpc.net/problem/14226
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 9:14
 */

public class Q14226
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        int clip = 0;
        // [][0] : 
        int[][] check = new int[1001][2];
        // 이모티콘의 개수
        int cnt = 1;
        // 걸린 시간
        int time = 0;

        // [0] : 이모티콘 개수, [1] : 걸린 시간, [2] : 클립에 있는 이모티콘 수
        queue.add(new int[]{cnt, time, clip});

        while(!queue.isEmpty())
        {
            // 큐의 다음 순번을 본다.
            int[] info = queue.peek();

            // 현재 시간의 행동이 큐에서 없어질 때까지
            while(info[1] == time)
            {
                cnt = info[0];
                clip = info[2];
                // 큐에서 뺸다.
                queue.poll();

                queue.add(new int[]{cnt, time + 1, cnt});

                // 클립이 0이면 붙여넣는 의미가 없다.
                if(clip != 0)
                    queue.add(new int[]{cnt + info[2], time + 1, clip});

                queue.add(new int[]{cnt - 1, time + 1, clip});
            }

            time++;
        }
    }
}
