/*
균형잡힌 세상

https://www.acmicpc.net/problem/4949
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-20
 * Time: 오후 7:19
 */

public class Q4949
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            String str = br.readLine();
            if(str.equals("."))
                break;

            Stack<Character> stack = new Stack<>();
            int len = str.length();
            boolean found = false;
            for(int i=0; i<len; i++)
            {
                char ch = str.charAt(i);
                switch(ch)
                {
                    case '(':
                        stack.push(ch);
                        break;
                    case ')':
                        if(stack.isEmpty())
                        {
                            i = len;
                            found = true;
                        }
                        else
                        {
                            char sCh = stack.peek();
                            if(sCh == '(')
                                stack.pop();
                            else
                            {
                                i = len;
                                found = true;
                            }
                        }
                        break;
                    case '[':
                        stack.push(ch);
                        break;
                    case ']':
                        if(stack.isEmpty())
                        {
                            i = len;
                            found = true;
                        }
                        else
                        {
                            char sCh = stack.peek();

                            if(sCh == '[')
                                stack.pop();
                            else
                            {
                                i = len;
                                found = true;
                            }
                        }
                        break;
                }
            }

            if(!found && stack.isEmpty())
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        System.out.print(sb.toString());
    }
}
