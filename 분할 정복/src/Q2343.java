/*
기타 레슨

https://www.acmicpc.net/problem/2343
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-07
 * Time: 오후 7:08
 */

public class Q2343
{
    static int[] ary = new int[100001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(ary[i], max);
        }

        int start = max;
        int end = 1000000000;
        int min = Integer.MAX_VALUE;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            // 블루레이의 개수
            int cnt = 1;
            int sum = 0;
            for(int i=0; i<N; i++)
            {
                // 블루레이에 담을 수 없으면 다음 블루레이에 담는다.
                if(sum + ary[i] > mid)
                {
                    sum = ary[i];
                    cnt++;
                }
                // 담을 수 있으면 현재 블루레이에 담는다.
                else
                    sum += ary[i];
            }

            // 원하는 개수와 같거나 더 적게 담았으면 최소값을 찾기 위해 블루레이 크기를 줄인다.
            // 원하는 개수보다 적게 담았으면 블루레이 크기를 줄여 하나에 더 적게 담아 개수를 늘린다.
            if(cnt <= M)
            {
                if(mid < min)
                    min = mid;

                end = mid - 1;
            }
            // 원하는 개수보다 많이 담았으면 블루레이 크기를 늘려 하나에 더 많이 담아 개수를 줄인다.
            else
                start = mid + 1;
        }

        System.out.println(min);
    }
}
