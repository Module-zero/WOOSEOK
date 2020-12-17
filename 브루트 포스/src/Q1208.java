/*
부분수열의 합 2

https://www.acmicpc.net/problem/1208
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 9:56
 */

public class Q1208
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[1000001];
        for(int i = 0; i < N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        // 중간에서 만남
        int M = N/2;
        N = N - M;

        int[] first = new int[1<<N];
        // 비트마스크를 사용해 부분수열 생성
        for(int i=0; i<(1<<N); i++)
        {
            // 부분수열의 합 저장
            for(int k=0; k<N; k++)
            {
                int num = 1 << k;
                if((i & num) != 0)
                    first[i] += ary[k];
            }
        }

        int[] second = new int[1<<M];
        for(int i=0; i<(1<<M); i++)
        {
            // 부분수열의 합 저장
            for(int k=0; k<M; k++)
            {
                int num = 1 << k;
                if((i & num) != 0)
                    second[i] += ary[N+k];
            }
        }

        // 정렬
        Arrays.sort(first);
        Arrays.sort(second);

        N = (1 << N);
        M = (1 << M);
        int i = 0;
        int j = M - 1;

        long ans = 0;
        while(i < N && j >= 0)
        {
            if(first[i] + second[j] == S)
            {
                long cntF = 1;
                long cntS = 1;
                i++;
                j--;

                while(i < N && first[i] == first[i-1])
                {
                    i++;
                    cntF++;
                }

                while(j >= 0 && second[j] == second[j+1])
                {
                    j--;
                    cntS++;
                }

                ans += cntF * cntS;
            }
            else if(first[i] + second[j] < S)
                i++;
            else
                j--;
        }

        // 크기가 양수인 부분수열이므로 0 + 0은 제외
        if(S == 0)
            ans--;

        System.out.println(ans);
    }
}
