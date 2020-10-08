/*
진법 변환

문제
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

출력
첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-08
 * Time: 오전 12:31
 */

public class Q2745
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int nLen = N.length();

        if(B == 0)
        {
            System.out.println("0");
        }
        else
        {
            int num = 0;
            int tB = 1;

            for (int i = 0; i < nLen; i++)
            {
                char ch = N.charAt(nLen-i-1);
                int value = 0;
                if(ch >= 'A' && ch <= 'Z')
                {
                    // 숫자로 변환
                    value = ch - 'A' + 10;
                }
                else
                    value = ch - '0';

                num += value * tB;

                tB *= B;
            }

            System.out.println(num);
        }
    }
}
