/*
탑

https://www.acmicpc.net/problem/2493
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-20
 * Time: 오후 11:17
 */

public class Q2493
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[500001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> before = new Stack<>();
        Stack<int[]> after = new Stack<>();

        for(int i=1; i<=N; i++)
        {
            height[i] = Integer.parseInt(st.nextToken());
            before.add(new int[]{i, height[i]});
        }

        int[] ans = new int[500001];
        StringBuffer sb = new StringBuffer();
        while(!before.isEmpty())
        {
            int[] left = before.pop();

            while(!after.isEmpty())
            {
                int[] right = after.peek();
                if(left[1] >= right[1])
                {
                    ans[right[0]] = left[0];
                    after.pop();
                }
                else
                    break;
            }

            after.push(left);
        }

        for(int i=1; i<=N; i++)
            sb.append(ans[i]).append(' ');

        System.out.println(sb.toString());
    }
}
