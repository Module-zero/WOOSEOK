/*
점프 점프

https://www.acmicpc.net/problem/11060
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
 * Date: 2021-01-29
 * Time: 오전 1:33
 */

public class Q11060
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[1001];
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] d = new int[1001];
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();
            if(tmp == N-1)
            {
                System.out.println(d[tmp]);
                return;
            }

            int lim = A[tmp];
            for(int i=1; i<=lim; i++)
            {
                if(tmp + i < N && d[tmp+i] == 0)
                {
                    queue.add(tmp + i);
                    d[tmp + i] = d[tmp] + 1;
                }
            }
        }

        System.out.println(-1);
    }
}
