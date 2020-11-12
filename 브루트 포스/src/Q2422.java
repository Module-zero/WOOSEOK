/*
한윤정이 이탈리아에 가서 아이스크림을 사먹는데

https://www.acmicpc.net/problem/2422
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 2:00
 */

public class Q2422
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] ary = new boolean[201][201];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ary[a][b] = true;
            ary[b][a] = true;
        }

        int cnt = 0;
        for(int i=1; i<=N-2; i++)
        {
            for(int j=i+1; j<=N-1; j++)
            {
                if(ary[i][j])
                    continue;

                for(int k=j+1; k<=N; k++)
                {
                    if(ary[i][k] || ary[j][k])
                        continue;

                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
