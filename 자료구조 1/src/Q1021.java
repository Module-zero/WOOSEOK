/*
회전하는 큐

https://www.acmicpc.net/problem/1021
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 6:07
 */

public class Q1021
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[50];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++)
            dq.add(i);

        int sum = 0;
        for(int i=0; i<M; i++)
        {
            Iterator<Integer> dit = dq.descendingIterator();
            int dcnt = 0;
            while(dit.hasNext())
            {
                dcnt++;

                int num = dit.next();
                if(num == ary[i])
                    break;
            }

            Iterator<Integer> it = dq.iterator();
            int cnt = 0;
            while(it.hasNext())
            {
                int num = it.next();
                if(num == ary[i])
                    break;

                cnt++;
            }

            if(dcnt < cnt)
            {
                for(int k=0; k<dcnt-1; k++)
                    dq.addFirst(dq.pollLast());

                dq.pollLast();
                sum += dcnt;
            }
            else
            {
                for(int k=0; k<cnt; k++)
                    dq.add(dq.pollFirst());

                dq.pollFirst();
                sum += cnt;
            }
        }

        System.out.println(sum);
    }
}
