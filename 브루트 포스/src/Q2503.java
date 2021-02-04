/*
숫자 야구

https://www.acmicpc.net/problem/2503
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-04
 * Time: 오후 2:17
 */

public class Q2503
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000];
        for(int i=123; i<=987; i++)
            check[i] = true;

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            String astr = Integer.toString(ans);
            for(int num=123; num<=987; num++)
            {
                if(!check[num])
                    continue;

                String str = Integer.toString(num);

                if(str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0')
                {
                    check[num] = false;
                    continue;
                }

                if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
                {
                    check[num] = false;
                    continue;
                }

                int s = 0;
                int b = 0;
                for(int x=0; x<3; x++)
                {
                    for(int y=0; y<3; y++)
                    {
                        if(x == y && astr.charAt(x) == str.charAt(y))
                            s++;

                        if(x != y && astr.charAt(x) == str.charAt(y))
                            b++;
                    }
                }

                if(strike != s || ball != b)
                    check[num] = false;
            }
        }

        int cnt = 0;
        for(int i=123; i<=987; i++)
        {
            if(check[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
