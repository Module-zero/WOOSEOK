/*
하노이 탑 이동 순서

https://www.acmicpc.net/problem/11729
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오후 3:39
 */

public class Q11729
{
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void hanoy(int cur, int tar, int n)
    {
        if(n == 0)
            return;

        // 이동 횟수 증가
        cnt++;
        // n-1개의 블럭을 tar가 아닌 장대로 이동시킴(마지막 블럭이 tar로 가야하기 때문)
        hanoy(cur, 6-cur-tar, n-1);
        // 마지막 블럭이 tar로 감
        sb.append(cur).append(" ").append(tar).append("\n");
        // n-1개의 블럭을 tar로 이동시킴
        hanoy(6-cur-tar, tar, n-1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoy(1, 3, N);
        System.out.println(cnt);
        System.out.print(sb.toString());
    }
}
