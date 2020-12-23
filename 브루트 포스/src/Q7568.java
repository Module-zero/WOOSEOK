/*
덩치

https://www.acmicpc.net/problem/7568
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-21
 * Time: 오후 5:49
 */

public class Q7568
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] height = new int[51];
        int[] weight = new int[51];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            height[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[51];
        for(int i=0; i<N; i++)
        {
            int cnt = 1;
            for(int j=0; j<N; j++)
            {
                if(i == j)
                    continue;

                if(height[i] < height[j] && weight[i] < weight[j])
                    cnt++;
            }

            ans[i] = cnt;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
            sb.append(ans[i]).append(' ');

        System.out.println(sb.toString());
    }
}
