/*
숨바꼭질 2

https://www.acmicpc.net/problem/12851
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-03
 * Time: 오후 9:53
 */

public class Q12851
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K)
        {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        int[] time = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        time[N] = 0;
        queue.add(N);

        int cnt = 0;
        int ans = 100000;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            int[] ary = {tmp-1, tmp+1, tmp*2};
            for(int i=0; i<3; i++)
            {
                if(ary[i] < 0 || ary[i] > 100000)
                    continue;

                if(ary[i] == K && time[tmp] + 1 <= ans)
                {
                    if(ans == 100000)
                        sb.append(time[tmp]+1).append('\n');

                    ans = time[tmp] + 1;
                    cnt++;
                }

                if(time[ary[i]] == 0 || time[ary[i]] == time[tmp] + 1)
                {
                    time[ary[i]] = time[tmp] + 1;
                    queue.add(ary[i]);
                }
            }
        }

        sb.append(cnt);
        System.out.println(sb.toString());
    }
}
