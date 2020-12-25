/*
숫자 빈도수

https://www.acmicpc.net/problem/14912
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 4:14
 */

public class Q14912
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i=1; i<=n; i++)
        {
            int tmp = i;
            while(tmp > 0)
            {
                if(tmp % 10 == d)
                    cnt++;
                tmp /= 10;
            }
        }

        System.out.println(cnt);
    }
}
