/*
타일링

https://www.acmicpc.net/problem/1793
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-10
 * Time: 오후 9:57
 */

public class Q1793
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for(int i=3; i<=250; i++)
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));

        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            sb.append(dp[Integer.parseInt(str)]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
