/*
돌 게임

https://www.acmicpc.net/problem/9655
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 4:44
 */

public class Q9655
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N % 2 == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
