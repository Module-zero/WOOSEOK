/*
빗물

https://www.acmicpc.net/problem/14719
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 5:20
 */

public class Q14719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[501];
        for(int i=0; i<W; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.add(ary[0]);
        // 스택의 max값 저장
        int left = ary[0];
        int k=0;
        for(; k<W; k++)
        {
            if(ary[k] != 0)
            {
                left = ary[k];
                break;
            }
        }

        int ans = 0;
        for(int i=k+1; i<W; i++)
        {
            if(ary[i] >= left)
            {
                while(!stack.isEmpty())
                    ans += left - stack.pop();

                left = ary[i];
            }

            stack.add(ary[i]);
        }

        if(!stack.isEmpty())
        {
            int right = stack.pop();

            while(!stack.isEmpty())
            {
                int num = stack.pop();
                if(num == left)
                    break;

                if(num < right)
                    ans += right - num;
                else
                    right = num;
            }
        }

        System.out.println(ans);
    }
}
