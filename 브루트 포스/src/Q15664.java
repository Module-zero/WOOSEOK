/*
N과 M (10)

https://www.acmicpc.net/problem/15664
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-17
 * Time: 오전 12:55
 */

public class Q15664
{
    static int N;
    static int M;
    static int[] ary;
    static int[] ans;
    static int[] cnt;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int start)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(ans[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++)
        {
            int num = ary[i];

                ans[index] = num;
                foo(index+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[N];
        ans = new int[M];
        cnt = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            ary[i] = num;
            cnt[num]++;
        }

        Arrays.sort(ary);

        foo(0, 0);
        System.out.print(sb.toString());
    }
}
