/*
어린 왕자

https://www.acmicpc.net/problem/1004
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 10:27
 */

public class Q1004
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++)
            {
                st = new StringTokenizer(br.readLine());
                int xc = Integer.parseInt(st.nextToken());
                int yc = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean sIn = false;
                boolean eIn = false;

                int d1 = (xc - x1) * (xc - x1) + (yc - y1) * (yc - y1);
                int d2 = (xc - x2) * (xc - x2) + (yc - y2) * (yc - y2);
                int rs = r * r;
                if(d1 < rs)
                    sIn = true;
                if(d2 < rs)
                    eIn = true;

                if((sIn && !eIn) || (!sIn && eIn))
                    cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
