/*
가장 긴 증가하는 부분 수열 3

https://www.acmicpc.net/problem/12738
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-18
 * Time: 오전 12:04
 */

public class Q12738
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[1000001];
        int cnt = 1;
        ans[0] = A[0];
        for(int i=1; i<N; i++)
        {
            int start = 0;
            int end = cnt;

            while(start < end)
            {
                int mid = (start + end) / 2;

                if(ans[mid] >= A[i])
                    end = mid;
                else
                    start = mid + 1;
            }

            ans[end] = A[i];
            if(end == cnt)
                cnt++;
        }

        System.out.println(cnt);
    }
}
