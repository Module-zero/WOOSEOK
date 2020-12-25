/*
거짓말

https://www.acmicpc.net/problem/1043
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오전 12:36
 */

public class Q1043
{
    static int N;
    static int[] p = new int[51];

    public static int find(int n)
    {
        if(n == p[n])
            return n;

        return p[n] = find(p[n]);
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b)
            return;

        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++)
            p[i] = i;

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        // 진실을 아는 사람(0번은 지민이)
        for(int i=0; i<num; i++)
            merge(0, Integer.parseInt(st.nextToken()));

        int[][] party = new int[51][51];

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int pNum = Integer.parseInt(st.nextToken());
            for(int j=0; j<pNum; j++)
            {
                party[i][j] = Integer.parseInt(st.nextToken());

                // union find
                if(j > 0)
                    merge(party[i][0], party[i][j]);
            }
        }

        int cnt = 0;
        for(int i=0; i<M; i++)
        {
            boolean impossible = false;

            for(int j=0; j<N; j++)
            {
                if(party[i][j] == 0)
                    break;

                if(find(0) == find(party[i][j]))
                {
                    impossible = true;
                    break;
                }
            }

            if(!impossible)
                cnt++;
        }

        System.out.println(cnt);
    }
}
