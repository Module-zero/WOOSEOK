/*
반도체 설계

https://www.acmicpc.net/problem/2352
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 5:24
 */

public class Q2352
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[40001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[40001];
        ans[0] = ary[1];
        int cnt = 1;
        for(int i=2; i<=n; i++)
        {
            int start = 0;
            int end = cnt;

            while(start < end)
            {
                int mid = (start + end) / 2;

                if(ans[mid] >= ary[i])
                    end = mid;
                else
                    start = mid + 1;
            }

            ans[end] = ary[i];
            if(cnt == end)
                cnt++;
        }

        System.out.println(cnt);
    }
}
