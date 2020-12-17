/*
게임

https://www.acmicpc.net/problem/1072
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 4:56
 */

public class Q1072
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = Y*100/X;

        long ans = -1;
        long start = 0;
        long end = X;
        while(start <= end)
        {
            long mid = (start + end) / 2;

            long newZ = (Y+mid)*100/(X+mid);
            if(newZ == Z)
                start = mid + 1;
            else
            {
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
