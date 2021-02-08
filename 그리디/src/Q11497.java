/*
통나무 건너뛰기

https://www.acmicpc.net/problem/11497
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-08
 * Time: 오후 1:45
 */

public class Q11497
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] ary = new int[10001];
            for(int i=0; i<N; i++)
                ary[i] = Integer.parseInt(st.nextToken());
            int si = 0;
            int ei = N-1;
            int k = 0;

            Arrays.sort(ary, 0, N);
            boolean b = true;
            int[] tmp = new int[10001];
            while(si <= ei)
            {
                if(b)
                {
                    tmp[si] = ary[k];
                    si++; k++;
                    b = false;
                }
                else
                {
                    tmp[ei] = ary[k];
                    ei--; k++;
                    b = true;
                }
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++)
            {
                int next = (i == N-1) ? 0 : i+1;

                int diff = Math.abs(tmp[next] - tmp[i]);
                max = Integer.max(max, diff);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
