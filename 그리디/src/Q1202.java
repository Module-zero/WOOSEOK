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

        public Jewel(int M, int V)
        {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewel o)
        {
            if(M > o.M)
                return 1;
            else if(M == o.M)
            {
                if(V > o.V)
                    return -1;
                else if(V == o.V)
                    return 0;
                else
                    return 1;
            }
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[300001];
        int[] bags = new int[300001];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int M =  Integer.parseInt(st.nextToken());
            int V =  Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(M, V);
        }

        Arrays.sort(jewels, 0, N);

        for(int i=0; i<K; i++)
            bags[i] = Integer.parseInt(br.readLine());

        Arrays.sort(bags, 0, K);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        long sum = 0;
        int jId = 0;
        for(int bId = 0; bId < K; bId++)
        {
            // 가방에 들어갈 수 있는 보석을 다 큐에 넣는다.
            while(jId < N && jewels[jId].M <= bags[bId])
            {
                queue.add(-jewels[jId].V);
                jId++;
            }

            if(!queue.isEmpty())
                sum += -queue.poll();
        }

        System.out.println(sum);
    }
}