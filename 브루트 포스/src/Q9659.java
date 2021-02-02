/*
돌 게임 5

https://www.acmicpc.net/problem/9659
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 4:56
 */

public class Q9659
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if(N % 2 == 0)
            System.out.println("CY");
        else
            System.out.println("SK");
    }
}
