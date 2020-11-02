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
    static char[] A1 = new char[100000];
    static char[] A2 = new char[100000];
    static char[] B = new char[100000];

    public static void press(int n, char[] A)
    {
        for(int i=n-1; i<=n+1; i++)
        {
            if(i < 0 || i >= N)
                continue;

            A[i] = (A[i] == '0') ? '1' : '0';
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String strA = br.readLine();
        for(int i=0; i<N; i++)
        {
            A1[i] = strA.charAt(i);
            A2[i] = strA.charAt(i);
        }

        String strB = br.readLine();
        for(int i=0; i<N; i++)
            B[i] = strB.charAt(i);

        // --- 입력

        int cnt = 0;

        // 0번 스위치를 누르지 않았을 때
        for(int i=1; i<N; i++)
        {
            if(A1[i-1] != B[i-1])
            {
                press(i, A1);
                cnt++;
            }
        }

        boolean isSame = true;
        for(int i=0; i<N; i++)
        {
            if(A1[i] != B[i])
            {
                isSame = false;
                break;
            }
        }

        if(isSame)
        {
            System.out.println(cnt);
            return;
        }

        // 0번 스위치를 눌렀을 때
        press(0, A2);
        cnt = 1;

        for(int i=1; i<N; i++)
        {
            if(A2[i-1] != B[i-1])
            {
                press(i, A2);
                cnt++;
            }
        }

        for(int i=0; i<N; i++)
        {
            if(A2[i] != B[i])
            {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(cnt);
    }
}
