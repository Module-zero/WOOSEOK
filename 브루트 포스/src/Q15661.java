/*
링크와 스타트

https://www.acmicpc.net/problem/15661
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오전 10:33
 */

public class Q15661
{
    static int N;
    static int[][] S = new int[21][21];
    static int gap = Integer.MAX_VALUE;

    public static void foo(int index, int[] start, int[] link, int sNum, int lNum)
    {
        if(index == N+1)
        {
            // 한 팀에 한 명도 없으면 탈출
            if(sNum == 1 || lNum == 1)
                return;

            int sSum = 0;
            for(int i=1; i<=sNum-2; i++)
            {
                int id1 = start[i];
                for(int j=i+1; j<=sNum-1; j++)
                {
                    int id2 = start[j];

                    sSum += S[id1][id2] + S[id2][id1];
                }
            }

            int lSum = 0;
            for(int i=1; i<=lNum-2; i++)
            {
                int id1 = link[i];
                for(int j=i+1; j<=lNum-1; j++)
                {
                    int id2 = link[j];

                    lSum += S[id1][id2] + S[id2][id1];
                }
            }

            int diff = sSum - lSum;
            if(diff < 0)
                diff = -diff;

            if(gap > diff)
                gap = diff;

            return;
        }

        start[sNum] = index;
        foo(index+1, start, link, sNum+1, lNum);
        link[lNum] = index;
        foo(index+1, start, link, sNum, lNum+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(1, new int[21], new int[21], 1, 1);

        System.out.println(gap);
    }
}
