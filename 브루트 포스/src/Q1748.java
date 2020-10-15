/*
수 이어 쓰기 1

문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1≤N≤100,000,000)이 주어진다.

출력
첫째 줄에 새로운 수의 자릿수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-15
 * Time: 오후 3:42
 */

public class Q1748
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int len = 0;
        // 자리수
        int digit = 1;

        int n = 1;
        while(n*10 <= N)
        {
            len += 9 * n * digit;
            n *= 10;
            digit++;
        }

        len += (N - n + 1) * digit;

        System.out.println(len);
    }
}
