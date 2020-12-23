/*
경비원

https://www.acmicpc.net/problem/2564
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-23
 * Time: 오후 4:42
 */

public class Q2564
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            // dir : 행, dist : 열
            switch(dir)
            {
                case 1:
                    dir = 0;
                    break;
                case 2:
                    dir = R;
                    break;
                case 3:
                    dir = dist;
                    dist = 0;
                    break;
                case 4:
                    dir = dist;
                    dist = C;
                    break;
            }

            list.add(new int[]{dir, dist});
        }

        st = new StringTokenizer(br.readLine());
        int xR = Integer.parseInt(st.nextToken());
        int xC = Integer.parseInt(st.nextToken());
        switch(xR)
        {
            case 1:
                xR = 0;
                break;
            case 2:
                xR = R;
                break;
            case 3:
                xR = xC;
                xC = 0;
                break;
            case 4:
                xR = xC;
                xC = C;
                break;
        }
        int sum = 0;
        for(int[] tmp : list)
        {
            int rDiff = 0;
            int cDiff = 0;

            // 경비원이 북|남에 있을 경우
            if(xR == 0 || xR == R)
            {
                rDiff = xR - tmp[0];
                if(rDiff < 0)
                    rDiff = -rDiff;

                if(xR == tmp[0])
                {
                    cDiff = xC - tmp[1];
                    if(cDiff < 0)
                        cDiff = -cDiff;
                }
                else
                    cDiff = Integer.min(xC + tmp[1], C - xC + C - tmp[1]);
            }
            // 경비원이 서|동에 있을 경우
            else
            {
                cDiff = xC - tmp[1];
                if(cDiff < 0)
                    cDiff = -cDiff;

                if(xC == tmp[1])
                {
                    rDiff = xR - tmp[0];
                    if(rDiff < 0)
                        rDiff = -rDiff;
                }
                else
                    rDiff = Integer.min(xR + tmp[0], R - xR + R - tmp[0]);
            }

            sum += rDiff + cDiff;
        }

        System.out.println(sum);
    }
}
