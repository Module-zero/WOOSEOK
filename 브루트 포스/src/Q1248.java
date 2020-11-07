/*
맞춰봐

https://www.acmicpc.net/problem/1248
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오후 8:59
 */

public class Q1248
{
    static int N;
    static char[][] S = new char[21][21];
    static int[] ans = new int[21];
    static StringBuilder sb = new StringBuilder();
    static boolean isFound = false;

    public static void foo(int id1)
    {
        for(int n=-10; n<=10; n++)
        {
            ans[id1] = n;

            int tmp = 0;
            boolean isOk = true;
            for(int i=id1; i>=1; i++)
            {
                tmp += ans[i];

                switch(S[i][id1])
                {
                    case '+':
                        if(tmp <= 0)
                            isOk = false;
                        break;
                    case '-':
                        if(tmp >= 0)
                            isOk = false;
                        break;
                    case '0':
                        if(tmp != 0)
                            isOk = false;
                        break;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int k = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=i; j<=N; j++)
            {
                S[i][j] = str.charAt(k);
                k++;
            }
        }

        for(int i=1; i<=N; i++)
            sb.append(ans[i]).append(" ");

        System.out.println(sb.toString());
    }
}
