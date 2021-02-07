/*
입국심사

https://www.acmicpc.net/problem/3079
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 4:15
 */

public class Q3079
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[100001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ary, 0, N);

        long start = 0;
        long end = (long)ary[N-1] * M;
        long res = (long)ary[N-1] * M;
        while(start < end)
        {
            long mid = (start + end) / 2;

            long cnt = 0;
            for(int i=0; i<N; i++)
                cnt += mid / ary[i];

            // 모든 사람이 검문을 받지 못했을 경우 시간을 늘린다.
            if(cnt < M)
                start = mid+1;
            // 모든 사람이 검문을 받았을 경우 시간을 줄인다.
            else
            {
                res = Long.min(res, mid);
                end = mid;
            }
        }

        System.out.println(res);
    }
}
