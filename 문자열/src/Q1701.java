/*
Cubeditor

https://www.acmicpc.net/problem/1701
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-11
 * Time: 오전 1:36
 */

public class Q1701
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();
        int max = 0;
        StringBuffer sb = new StringBuffer();
        // 중간에서 연속되는 문자열이 있을 수 있으므로 문자열의 맨 뒤에서부터 앞의 문자를 하나씩 더한 문자열을 생성하고 검사한다.
        for(int k=len-1; k>=0; k--)
        {
            // 초기화해줘야 한다.
            int[] fail = new int[5001];
            sb.insert(0, str.charAt(k));

            String tStr = sb.toString();
            int tLen = tStr.length();
            int j = 0;

            // KMP 알고리즘
            for (int i = 1; i < tLen; i++)
            {
                while (j > 0 && tStr.charAt(i) != tStr.charAt(j))
                    j = fail[j - 1];

                if (tStr.charAt(i) == tStr.charAt(j))
                {
                    fail[i] = ++j;
                    max = Integer.max(fail[i], max);
                }
            }
        }

        System.out.println(max);
    }
}
