/*
돌 게임 2

https://www.acmicpc.net/problem/9656
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오전 1:29
 */

public class Q9656
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N % 2 == 0)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
