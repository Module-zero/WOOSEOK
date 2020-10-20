/*
스타트와 링크

https://www.acmicpc.net/problem/14889
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 10:11
 */

public class Q14889
{
    static int N;
    static int[][] S;
    static int gap = Integer.MAX_VALUE;

    public static void foo(int index, int[] start, int[] link, int sCnt, int lCnt)
    {
        if(index == N)
        {
            int sSum = 0;
            for(int i=0; i<sCnt-1; i++)
            {
                int id1 = start[i];
                for(int j=i+1; j<sCnt; j++)
                {
                    int id2 = start[j];

                    sSum += S[id1][id2];
                    sSum += S[id2][id1];
                }
            }

            int lSum = 0;
            for(int i=0; i<lCnt-1; i++)
            {
                for(int j=i+1; j<lCnt; j++)
                {
                    int id1 = link[i];
                    int id2 = link[j];

                    lSum += S[id1][id2];
                    lSum += S[id2][id1];
                }
            }

            int diff = sSum - lSum;
            if(diff < 0)
                diff = -diff;

            if(gap > diff)
                gap = diff;
        }

        if(sCnt < N/2)
        {
            start[sCnt] = index;
            foo(index + 1, start, link, sCnt + 1, lCnt);
        }

        if(lCnt < N/2)
        {
            link[lCnt] = index;
            foo(index + 1, start, link, sCnt, lCnt + 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, new int[N], new int[N], 0, 0);

        System.out.println(gap);
    }
}
