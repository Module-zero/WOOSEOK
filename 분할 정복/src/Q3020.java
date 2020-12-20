/*
개똥벌레

https://www.acmicpc.net/problem/3020
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 8:46
 */

public class Q3020
{
    static int N;
    static int H;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[] ary = new int[100001];
        int[] ary2 = new int[100001];
        for(int i=0; i<N/2; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            ary2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary, 0, N/2);
        Arrays.sort(ary2, 0, N/2);

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=H; i++)
        {
            int cnt = 0;

            int start = 0;
            int end = N/2;
            // lower bound
            while(start < end)
            {
                int mid = (start + end) / 2;

                if(ary[mid] >= i)
                    end = mid;
                else
                    start = mid + 1;
            }

            cnt += N/2 - end;

            start = 0;
            end = N/2;
            // upper bound
            while(start < end)
            {
                int mid = (start + end) / 2;

                if(ary2[mid] > H - i)
                    end = mid;
                else
                    start = mid + 1;
            }

            cnt += (N/2) - end;
            if(cnt < min)
            {
                min = cnt;
                ans = 1;
            }
            else if(cnt == min)
                ans++;
        }

        StringBuffer sb = new StringBuffer().append(min).append(' ').append(ans);
        System.out.println(sb.toString());
    }
}
