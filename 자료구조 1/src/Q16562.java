/*
친구비

https://www.acmicpc.net/problem/16562
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오전 1:22
 */

public class Q16562
{
    static int[] p = new int[10001];
    static int[] A = new int[10001];

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
        if(A[b] > A[a])
            A[b] = A[a];
        else
            A[a] = A[b];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // 주인공은 0번째
        A[0] = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
            p[i] = i;
        }

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            merge(f1, f2);
        }

        int sum = 0;
        int i=1;
        for(; i<=N; i++)
        {
            int pi = find(i);

            // 이미 친구
            if(pi == 0)
                continue;
            else
            {
                if(sum + A[pi] <= k)
                {
                    sum += A[pi];
                    merge(0, i);
                }
                else
                    break;
            }
        }

        if(i == N+1)
            System.out.println(sum);
        else
            System.out.println("Oh no");
    }
}
