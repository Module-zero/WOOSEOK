/*
좋은 단어

https://www.acmicpc.net/problem/3986
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오전 1:52
 */

public class Q3986
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N-- > 0)
        {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            int len = str.length();
            for(int i=0; i<len; i++)
            {
                char ch = str.charAt(i);

                if(!stack.isEmpty())
                {
                    char sch = stack.peek();

                    if(sch == ch)
                        stack.pop();
                    else
                        stack.add(ch);
                }
                else
                    stack.add(ch);
            }

            if(stack.isEmpty())
                cnt++;
        }

        System.out.println(cnt);
    }
}
