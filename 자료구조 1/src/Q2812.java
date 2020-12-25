/*
크게 만들기

https://www.acmicpc.net/problem/2812
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-23
 * Time: 오후 10:36
 */

public class Q2812
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++)
        {
            int num = str.charAt(i) - '0';
            // 스택에서 자기보다 큰 수를 만날 때까지 스택을 꺼낸다.
            while(K > 0 && !stack.isEmpty())
            {
                int sNum = stack.peek();
                if (sNum < num)
                {
                    stack.pop();
                    K--;
                }
                else
                    break;
            }

            stack.add(num);
        }

        // 내림차순으로 들어갔으므로 맨 뒤의 수를 K개 빼준다.
        while(K-- > 0)
            stack.pop();

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb.reverse().toString());
    }
}
