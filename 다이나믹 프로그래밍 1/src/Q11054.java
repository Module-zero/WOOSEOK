/*
가장 긴 바이토닉 부분 수열

https://www.acmicpc.net/problem/11054
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-14
 * Time: 오후 5:25
 */

public class Q11054
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        // 증가
        int[] dp1 = new int[1001];
        // 감소
        int[] dp2 = new int[1001];
        int len = 1;

        // 증가하는 수열
        for (int i=0; i<N; i++)
        {
            // 길이 1로 초기화
            dp1[i] = 1;

            for (int j=0; j<=i-1; j++)
            {
                if (ary[j] < ary[i] && dp1[i] < dp1[j] + 1)
                    dp1[i] = dp1[j] + 1;
            }
        }

        // 감소하는 수열(뒤에서부터 탐색해야 한다.)
        for(int i=N-1; i>=0; i--)
        {
            dp2[i] = 1;

            for(int j=i+1; j<N; j++)
            {
                if(ary[j] < ary[i] && dp2[i] < dp2[j] + 1)
                    dp2[i] = dp2[j] + 1;
            }
        }

        for(int i=0; i<N; i++)
        {
            // i번째 값이 겹치므로 1 감소
            if (len < dp1[i] + dp2[i] - 1)
                len = dp1[i] + dp2[i] - 1;
        }

        System.out.println(len);
    }
}
