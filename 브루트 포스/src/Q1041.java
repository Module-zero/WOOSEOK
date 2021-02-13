/*
주사위

https://www.acmicpc.net/problem/1041
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-13
 * Time: 오후 9:44
 */

public class Q1041
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        // 주사위의 총 수 : N^3 - (N-2)^3 - (N-2)^2
        // 1면이 보이는 주사위의 수 : 4
        // 3면이 보이는 주사위의 수 : 5*(N-2)^2 + 4*(N-2)
        // 나머지 주사위 : 2면이 보임

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min1 = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] ary = new int[6];
        for(int i=0; i<6; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());

            if(ary[i] < min1)
                min1 = ary[i];
            if(ary[i] > max)
                max = ary[i];
        }

        long ans = 0;
        if(N == 1)
        {
            int sum = 0;
            for(int i=0; i<6; i++)
                sum += ary[i];

            System.out.println(sum - max);
            return;
        }


        long totCnt = (N*N*N) - ((N-2)*(N-2)*(N-1));

        int min2 = Integer.MAX_VALUE;
        for(int i=0; i<5; i++)
        {
            for(int j=i+1; j<6; j++)
            {
                // 정반대면은 제외
                if(j == 5 - i)
                    continue;

                min2 = Integer.min(ary[i] + ary[j], min2);
            }
        }

        int min3 = Integer.MAX_VALUE;
        for(int i=0; i<5; i++)
        {
            if(i == 2 || i == 3)
                continue;

            for(int j=i+1; j<6; j++)
            {
                if(j == 2 || j == 3 || j == 5 - i)
                    continue;

                min3 = Integer.min(ary[i] + ary[j], min3);
            }
        }

        // 세 면의 최솟값
        min3 = Integer.min(min3 + ary[2], min3 + ary[3]);

        // 1면
        long cnt1 = (N-2)*(5*N-6);
        ans += min1 * cnt1;
        totCnt -= cnt1;

        // 3면
        ans += min3 * 4;
        totCnt -= 4;

        // 2면
        ans += totCnt * min2;

        System.out.println(ans);
    }
}
