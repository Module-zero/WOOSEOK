/*
가장 긴 증가하는 부분 수열 2

https://www.acmicpc.net/problem/12015
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-01
 * Time: 오후 4:20
 */

public class Q12015
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[1000001];
        ans[0] = ary[0];

        int cnt = 1;

        for(int i=1; i<N; i++)
        {
            // lower bound
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
            // 끝 인덱스에 값을 추가했으면 전체 수 + 1
            if(cnt == end)
                cnt++;
        }

        System.out.println(cnt);
    }
}
