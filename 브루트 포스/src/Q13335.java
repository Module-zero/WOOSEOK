/*
트럭

https://www.acmicpc.net/problem/13335
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
 * Date: 2020-12-28
 * Time: 오후 2:42
 */

public class Q13335
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=0; i<n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int t = 0;
        int[] sTime = new int[1001];
        for(int i=0; i<n; i++)
        {
            // 뒤의 트럭이 갈 수 있을 무게가 될 때까지 앞의 트럭이 빠져야 한다.
            if(sum + ary[i] > L)
            {
                while(sum + ary[i] > L)
                {
                    int num = queue.poll();
                    sum -= ary[num];
                    t = sTime[num] + w;
                }
            }
            // 1초 증가
            else
                t++;

            // 빠질 시간이 된 트럭을 뺀다.
            while(!queue.isEmpty() && t >= sTime[queue.peek()] + w)
            {
                int num = queue.poll();
                sum -= ary[num];
            }

            queue.add(i);
            sum += ary[i];
            sTime[i] = t;
        }

        System.out.println(sTime[n-1] + w);
    }
}
