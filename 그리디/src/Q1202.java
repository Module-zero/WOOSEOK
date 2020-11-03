/*
보석 도둑

https://www.acmicpc.net/problem/1202
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-03
 * Time: 오후 2:56
 */

public class Q1202
{
    static class Jewel implements Comparable<Jewel>
    {
        int M;
        int V;
        boolean isBag;

        public Jewel(int M, int V, boolean isBag)
        {
            this.M = M;
            this.V = V;
            this.isBag = isBag;
        }

        @Override
        public int compareTo(Jewel o)
        {
            if(M < o.M)
                return -1;
            else if(M == o.M)
            {
                if(V < o.V)
                    return -1;
                else if(V == o.V)
                    return 0;
                else
                    return 1;
            }
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] J = new Jewel[1000000];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            J[i] = new Jewel(M, V, false);
        }

        int[] C = new int[K];

        for(int i=0; i<K; i++)
        {
            C[i] = Integer.parseInt(br.readLine());
            J[N + i] = new Jewel(C[i], 1000001, true);
        }

        Arrays.sort(J, 0, N+K);

        for(int i=0; i<N+K; i++)
            System.out.println(J[i].M + " : " + J[i].V + " : "  + J[i].isBag);

        int cnt = 0;
        long sum = 0;
        for(int i=0; i<N; i++)
        {
            // K개를 골랐거나, N개를 다 봤으면 종료
            if(cnt == K)
                break;

            // 가방에 들어갈 수 있을 경우
            if(J[i].M <= C[cnt])
            {
                sum += J[i].V;
                cnt++;
            }
        }

        System.out.println(sum);
    }
}