/*
문자열 폭발

https://www.acmicpc.net/problem/9935
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 2:48
 */

public class Q9935
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ary = new char[1000001];
        String str = br.readLine();
        for(int i=0; i<str.length(); i++)
            ary[i] = str.charAt(i);

        String bang = br.readLine();

        // [0] : 문자열에서 인덱스, [1] : 폭발 문자열에서 인덱스
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = ary[i];

            // 폭발 문자열의 첫 번째 인덱스와 같으면 넣는다.
            if(ch == bang.charAt(0))
            {
                // 폭발 문자열의 길이가 1이면 바로 삭제
                if(bang.length() == 1)
                    ary[i] = ' ';
                else
                    stack.add(new int[]{i, 0});
            }
            else
            {
                // 다른데 스택이 비지 않았으면 하나를 꺼내 다음 문자인지 비교한다.
                if(!stack.isEmpty())
                {
                    int[] tmp = stack.peek();

                    // 다음 문자인데 폭발 문자열의 마지막 문자면 폭발시킨다.
                    if(ch == bang.charAt(tmp[1] + 1))
                    {
                        // 폭발
                        if(tmp[1] + 1 == bang.length() - 1)
                        {
                            ary[i] = ' ';

                            for(int k=1; k<bang.length(); k++)
                            {
                                int[] stackTmp = stack.pop();

                                // 넣지 않게 ' '로 표시
                                ary[stackTmp[0]] = ' ';
                            }
                        }
                        // 아니면 스택에 넣는다.
                        else
                            stack.add(new int[]{i, tmp[1] + 1});
                    }
                    // 다음 문자가 아니면 스택을 비운다.
                    else
                        stack = new Stack<>();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++)
        {
            if(ary[i] == ' ')
                continue;

            sb.append(ary[i]);
        }

        str = sb.toString();
        if(str.length() == 0)
            str = "FRULA";

        System.out.println(str);
    }
}


