/*
검열

https://www.acmicpc.net/problem/3111
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-23
 * Time: 오후 7:35
 */

public class Q3111
{
    static int lenA;
    static int lenT;

    static class MyStack
    {
        char[] stack;
        char[] sA;
        int top;

        public MyStack(String str)
        {
            this.stack = new char[300001];
            this.sA = new char[25];
            // 스택으로 비교하기 때문에 반대로 저장한다.(뒤부터 꺼내기 때문)
            for(int i=0; i<lenA; i++)
                this.sA[i] = str.charAt(lenA - i - 1);

            top = 0;
        }

        public boolean add(char ch)
        {
            boolean ret = false;

            stack[top++] = ch;

            // 스택에 A의 길이만큼 문자가 쌓이면 A일 가능성이 있으므로 검사
            if(top >= lenA)
            {
                int i = 0;
                for(; i<lenA; i++)
                {
                    // 문자가 다르면 바로 종료
                    if(stack[top - i - 1] != sA[i])
                        break;
                }

                // 끝까지 돌았으면 A라는 의미
                if(i == lenA)
                {
                    top -= lenA;
                    ret = true;
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        lenA = A.length();
        String T = br.readLine();
        lenT = T.length();

        MyStack front = new MyStack(A);
        MyStack back = new MyStack(new StringBuffer(A).reverse().toString());
        boolean isFront = true;

        int fIndex = 0;
        int bIndex = lenT - 1;
        while(fIndex <= bIndex)
        {
            if(isFront)
            {
                if(front.add(T.charAt(fIndex)))
                    isFront = false;
                fIndex++;
            }
            else
            {
                if(back.add(T.charAt(bIndex)))
                    isFront = true;
                bIndex--;
            }
        }

        while(front.top > 0)
            back.add(front.stack[--front.top]);

        StringBuilder sb = new StringBuilder();
        while(back.top > 0)
            sb.append(back.stack[--back.top]);

        System.out.println(sb.toString());
    }
}

