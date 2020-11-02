/*
전구와 스위치

https://www.acmicpc.net/problem/2138
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-02
 * Time: 오후 10:18
 */

public class Q2138
{
    static int N;
    static char[] A = new char[100000];
    static char[] B = new char[100000];

    public static void press(int i, int cnt)
    {
        if(i == N)
        {
            boolean isSame = true;

            for (int a = 0; a < N; a++)
            {
                if (A[a] != B[a])
                {
                    isSame = false;
                    break;
                }
            }

            if (isSame)
                System.out.println(cnt);

            return;
        }

        press(i+1, cnt);

        for(int a=i-1; a<=i+1; a++)
        {
            if(a < 0 || a >= N)
                continue;

            A[a] = (A[a] == '0') ? '1' : '0';
        }

        for(int a=0; a<N; a++)
            System.out.print(A[a] + " ");
        System.out.println();

        press(i+1, cnt+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String strA = br.readLine();
        for(int i=0; i<N; i++)
            A[i] = strA.charAt(i);

        String strB = br.readLine();
        for(int i=0; i<N; i++)
            B[i] = strB.charAt(i);

        press(0, 0);

        for(int i=0; i<N; i++)
        {
            if(A[i] != B[i])
            {
                System.out.println("-1");
                return;
            }
        }
    }
}
