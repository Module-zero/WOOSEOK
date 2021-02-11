/*
창고 다각형

https://www.acmicpc.net/problem/2304
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-10
 * Time: 오후 10:48
 */

public class Q2304
{
    static class Temp implements Comparable<Temp>
    {
        int left;
        int height;

        public Temp(int left, int height)
        {
            this.left = left;
            this.height = height;
        }

        @Override
        public int compareTo(Temp o)
        {
            return left - o.left;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Temp[] ary = new Temp[1001];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            ary[i] = new Temp(left, height);
        }

        Arrays.sort(ary, 0, N);

        Stack<Temp> stack = new Stack<>();
        int area = 0;
        int h = ary[0].height;
        int left = 0;
        for(int i=0; i<N; i++)
        {
            if(!stack.isEmpty())
            {
                if(h < ary[i].height)
                {
                    while(!stack.isEmpty())
                        left = stack.pop().left;

                    area += (ary[i].left - left) * h;

                    h = ary[i].height;
                }
            }

            stack.add(ary[i]);
        }

        while(!stack.isEmpty())
        {
            Temp tmp = stack.pop();

            if(stack.isEmpty())
                area += tmp.height;
            else
            {
                while(!stack.isEmpty() && stack.peek().height < tmp.height)
                    stack.pop();

                int right = stack.peek().left + 1;
                area += (tmp.left + 1 - right) * tmp.height;
            }
        }

        System.out.println(area);
    }
}
