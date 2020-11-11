/*
숫자 재배치

https://www.acmicpc.net/problem/16943
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오전 12:40
 */

public class Q16943
{
    static String A;
    static int B;
    static int len;
    // 최대 9자리
    static boolean[] check = new boolean[9];
    static int max = Integer.MIN_VALUE;

    public static void solve(int index, int num)
    {
        if(index == len)
        {
            // B보다 작거나 같으면서 가장 큰 값
            if(num <= B && num > max)
                max = num;

            return;
        }

        for(int i=0; i<len; i++)
        {
            // 안 썼던 자리수면 넣는다.
            if(!check[i])
            {
                int n = A.charAt(i) - '0';
                check[i] = true;
                solve(index + 1, num*10 + n);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        len = A.length();

        for(int i=0; i<len; i++)
        {
            int n = A.charAt(i) - '0';
            // 맨 앞자리는 0이 될 수 없다.
            if(n == 0)
                continue;

            check[i] = true;
            solve(1, n);
            check[i] = false;
        }

        if(max < 0)
            System.out.println(-1);
        else
            System.out.println(max);
    }
}
