/*
K번째 수

https://www.acmicpc.net/problem/1300
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-08
 * Time: 오후 3:40
 */

public class Q1300
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1;
        long end = N*N;
        long ans = 0;
        while(start <= end)
        {
            long mid = (start + end) / 2;

            long cnt = 0;
            for(long i=1; i<=N; i++)
            {
                // mid보다 작거나 같은 수의 개수를 센다.(mid가 행에 포함될 경우에만)
                cnt += Long.min(mid/i, N);
            }

            // cnt가 k보다 크면 개수가 답보다 많다는 의미이므로 mid보다 작은 값이 정답
            // 개수가 많거나 같은 수 중 최솟값을 구하면 된다.
            if(cnt >= k)
            {
                ans = mid;
                end = mid - 1;
            }
            // cnt가 k보다 작으면 mid보다 큰 값이 정답
            else
                start = mid + 1;
        }

        System.out.println(ans);
    }
}
