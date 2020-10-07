/*
8진수 2진수

문제
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 8진수가 주어진다. 주어지는 수의 길이는 333,334을 넘지 않는다.

출력
첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 5:30
 */

public class Q1212
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] cAry = str.toCharArray();
        int cLen = cAry.length;

        StringBuilder answer = new StringBuilder();
        if(cAry[0] == '0')
            answer.append("0");
        else
        {
            for (int i = 0; i < cLen; i++)
            {
                StringBuilder sb = new StringBuilder();
                int value = cAry[i] - '0';

                for (int n = 4; n > 0; n >>= 1)
                {
                    if (value >= n)
                    {
                        sb.append("1");
                        value -= n;
                    } else if (answer.length() != 0 || sb.length() != 0)
                        sb.append("0");
                }

                answer.append(sb.toString());
            }
        }

        System.out.println(answer.toString());
    }
}
