/*
N과 M (9)

https://www.acmicpc.net/problem/15663
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-17
 * Time: 오전 12:10
 */

public class Q15663
{
    static int N;
    static int M;
    static int[] ary;
    static int[] ans;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int last)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                queue.add(ans[i]);

            return;
        }

        for(int i=0; i<N; i++)
        {
            if(index == 0 && i > 0 && ary[i] == ary[i-1])
                continue;

            if(i == last)
                continue;

            ans[index] = ary[i];
            foo(index+1, i);
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

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        foo(0, -1);

        ans = new int[M];
        while(!queue.isEmpty())
        {
            int[] tmp = new int[M];
            boolean isEquals = true;
            // 큐에서 꺼내서 이전 수열이랑 같은지 조사
            for (int i = 0; i < M; i++)
            {
                tmp[i] = queue.poll();
                if(isEquals && tmp[i] != ans[i])
                    isEquals = false;
            }

            // 같은 수열이 아니면 출력
            if(!isEquals)
            {
                ans = tmp;
                for(int i=0; i<M; i++)
                    sb.append(ans[i] + " ");

                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
