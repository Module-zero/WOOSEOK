/*
구간 나누기 2

https://www.acmicpc.net/problem/13397
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-07
 * Time: 오후 9:14
 */

public class Q13397
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[5001];
        int start = 0;
        int end = 0;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());

            if(end < ary[i])
                end = ary[i];
        }

        int ans = Integer.MAX_VALUE;
        while(start <= end)
        {
            int mid = (start + end) / 2;

            int min = ary[0];
            int max = ary[0];
            int cnt = 1;
            for(int i=1; i<N; i++)
            {
                max = Integer.max(ary[i], max);
                min = Integer.min(ary[i], min);

                // 구간의 점수가 한계치를 넘으면 그룹을 새로 생성
                int score = max - min;
                if(score > mid)
                {
                    cnt++;
                    min = ary[i];
                    max = ary[i];
                }
            }

            if(cnt <= M)
            {
                ans = Integer.min(mid, ans);

                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        System.out.println(ans);
    }
}
