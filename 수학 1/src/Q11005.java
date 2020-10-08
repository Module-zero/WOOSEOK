/*
진법 변환2

문제
10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.

출력
첫째 줄에 10진법 수 N을 B진법으로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 11:48
 */

public class Q11005
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        if(N == 0)
            sb.append("0");
        else
        {
            while(N > 0)
            {
                int num = N % B;
                char ch = 0;
                if(num >= 10)
                {
                    // 문자로 변환
                    ch = (char)('A' + num - 10);
                }

                if(ch != 0)
                    sb.insert(0, ch);
                else
                    sb.insert(0, num);

                N /= B;
            }
        }

        System.out.println(sb.toString());
    }
}
