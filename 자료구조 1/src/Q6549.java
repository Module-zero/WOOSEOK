/*
히스토그램에서 가장 큰 직사각형

https://www.acmicpc.net/problem/6549
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-21
 * Time: 오후 11:36
 */

public class Q6549
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;

            long[] h = new long[100001];
            for (int i = 0; i < n; i++)
                h[i] = Long.parseLong(st.nextToken());

            Stack<Integer> stack = new Stack<>();

            long max = Long.MIN_VALUE;
            for(int i=0; i<n; i++)
            {
                while(!stack.isEmpty())
                {
                    int id = stack.peek();

                    // 스택의 가장 위의 높이가 현재 높이보다 높으면 넓이를 더 늘릴 수 없다.
                    if(h[id] > h[i])
                    {
                        // 스택에서 꺼낸다.
                        stack.pop();

                        int width = i;
                        if(!stack.isEmpty())
                            width = i - stack.peek() - 1;

                        long area = h[id] * width;

                        if(area > max)
                            max = area;
                    }
                    else
                        break;
                }

                stack.push(i);
            }

            while(!stack.isEmpty())
            {
                int id = stack.pop();

                int width = n;
                if(!stack.isEmpty())
                    width = n - stack.peek() - 1;

                long area = h[id] * width;

                if(area > max)
                    max = area;
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
