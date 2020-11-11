/*
차량 번호판 1

https://www.acmicpc.net/problem/16968
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 2:46
 */

public class Q16968
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int ans = 1;

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            // 문자만 가능할 경우
            if(ch == 'c')
            {
                // 연속으로 나왔을 경우
                if(i != 0 && str.charAt(i-1) == ch)
                    ans *= 25;
                else
                    ans *= 26;
            }
            // 숫자만 가능할 경우
            else
            {
                // 연속으로 나왔을 경우
                if(i != 0 && str.charAt(i-1) == ch)
                    ans *= 9;
                else
                    ans *= 10;
            }
        }

        System.out.println(ans);
    }
}
