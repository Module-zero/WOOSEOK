/*
NMK

https://www.acmicpc.net/problem/1201
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-02
 * Time: 오후 12:16
 */

public class Q1201
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N < M+K-1 || N > M*K)
        {
            System.out.println(-1);
            return;
        }

        int[] ary = new int[501];
        for(int i=1; i<=N; i++)
            ary[i] = i;

        // 감소하는 수열
        int mid = (1 + K) / 2;
        for(int i=1; i<=mid; i++)
        {
            int target = (K + 1) - i;
            ary[target] = i;
            ary[i] = target;
        }

        int start = K + 1;
        // M - 1개의 그룹을 만든다.
        for(int i=1; i<=M-1; i++)
        {
            //         시작 인덱스, 개수를 구하는 식, 개수-1 = 끝 인덱스
            int end = (K + 1) + ((N - K) * i / (M - 1)) - 1;

            mid = (start + end) / 2;
            // start~end를 뒤집는다.
            for(int j=start; j<=mid; j++)
            {
                int diff = j - start;
                int target = end - diff;
                ary[target] = j;
                ary[j] = target;
            }

            start = end + 1;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++)
            sb.append(ary[i]).append(' ');

        System.out.println(sb.toString());
    }
}
