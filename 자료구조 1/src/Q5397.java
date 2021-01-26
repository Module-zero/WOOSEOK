/*
키로거

https://www.acmicpc.net/problem/5397
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 11:36
 */

public class Q5397
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0)
        {
            String str = br.readLine();

            Stack<Character> front = new Stack<>();
            Stack<Character> back = new Stack<>();
            int len = str.length();
            for(int i=0; i<len; i++)
            {
                char ch = str.charAt(i);

                switch(ch)
                {
                    case '<':
                        if(!front.isEmpty())
                            back.add(front.pop());
                        break;
                    case '>':
                        if(!back.isEmpty())
                            front.add(back.pop());
                        break;
                    case '-':
                        if(!front.isEmpty())
                            front.pop();
                        break;
                    default:
                        front.add(ch);
                        break;
                }
            }

            StringBuffer tmp = new StringBuffer();
            while(!front.isEmpty())
                tmp.append(front.pop());

            tmp.reverse();
            while(!back.isEmpty())
                tmp.append(back.pop());

            sb.append(tmp.toString()).append('\n');
        }

        System.out.print(sb.toString());
    }
}
