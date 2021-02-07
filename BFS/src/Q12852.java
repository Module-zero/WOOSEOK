/*
1로 만들기 2

https://www.acmicpc.net/problem/12852
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오전 1:22
 */

public class Q12852
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        boolean[] check = new boolean[1000001];
        int[] prev = new int[1000001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        prev[N] = -1;
        check[N] = true;

        while(!queue.isEmpty())
        {
            int tmp = queue.poll();
            if(tmp == 1)
                break;

            if(tmp % 3 == 0)
            {
                int rem = tmp / 3;
                if(!check[rem])
                {
                    check[rem] = true;
                    queue.add(rem);
                    prev[rem] = tmp;
                }

                if(rem == 1)
                    break;
            }

            if(tmp % 2 == 0)
            {
                int rem = tmp / 2;
                if(!check[rem])
                {
                    check[rem] = true;
                    queue.add(rem);
                    prev[rem] = tmp;
                }

                if(rem == 1)
                    break;
            }

            int rem = tmp-1;
            if(!check[rem])
            {
                check[rem] = true;
                queue.add(rem);
                prev[rem] = tmp;

                if(rem == 1)
                    break;
            }
        }

        int cnt = -1;
        int rem = 1;
        Stack<Integer> stack = new Stack<>();
        while(rem != -1)
        {
            stack.add(rem);
            cnt++;
            rem = prev[rem];
        }
        sb.append(cnt).append('\n');

        while(!stack.isEmpty())
            sb.append(stack.pop()).append(' ');
        System.out.println(sb.toString());
    }
}
