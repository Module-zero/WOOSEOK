/*
외계인의 기타 연주

https://www.acmicpc.net/problem/2841
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 3:19
 */

public class Q2841
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] pq = new PriorityQueue[6];
        for(int i=0; i<6; i++)
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());

        int cnt = 0;
        while(N-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            int line = Integer.parseInt(st.nextToken()) - 1;
            int fret = Integer.parseInt(st.nextToken());

            while(!pq[line].isEmpty() && pq[line].peek() > fret)
            {
                pq[line].poll();
                cnt++;
            }

            Integer num = pq[line].peek();
            if(num == null || num < fret)
            {
                pq[line].add(fret);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
